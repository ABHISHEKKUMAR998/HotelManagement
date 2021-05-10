package HotelManagement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.time.temporal.ChronoField;
import java.time.DayOfWeek;

public class HotelReservation {
	private static Map<String, Hotel> hotelMap;

	public HotelReservation() {
		hotelMap = new HashMap<>();
	}

	public boolean addHotel(String name, int regWeekdayRate) {
		Hotel hotelObject = new Hotel(name, regWeekdayRate);
		hotelMap.put(name, hotelObject);
		return true;
	}
	public boolean addHotel(String name, int regWeekdayRate, int regWeekendRate) {
		Hotel hotelObject = new Hotel(name, regWeekdayRate, regWeekendRate);
		hotelMap.put(name, hotelObject);
		return true;
	}
	public boolean addHotel(String name, int regWeekdayRate, int regWeekendRate, int hotelRating) {
		Hotel hotelObject = new Hotel(name, regWeekdayRate, regWeekendRate, hotelRating);
		hotelMap.put(name, hotelObject);
		return true;
	}

	public void printHotels() {
		for (Map.Entry<String, Hotel> entry : hotelMap.entrySet()) {
			System.out.println("Hotel Name : " + entry.getKey());
			System.out.println("Rate on weekdays for regular customers : " + entry.getValue().getRegWeekdayRate());
			System.out.println("Rate on Weekends for Regular Customers : " + entry.getValue().getRegWeekendRate());
			System.out.println("Hotel Rating : " + entry.getValue().getHotelRating());
			System.out.println();
		}
	}

	
	public boolean findCheapestHotel(String fromDate, String toDate) {
		Map<Integer, ArrayList<Hotel>> rentMap = createRentMap(fromDate, toDate);
		int minimumRent = Integer.MAX_VALUE; //Assigns max possible value
		for (Map.Entry<Integer, ArrayList<Hotel>> entry : rentMap.entrySet()) {
			if (entry.getKey() < minimumRent)
				minimumRent = entry.getKey();
		}

		System.out.println("Cheapest Hotel for you is : ");
		for (Hotel hotel : rentMap.get(minimumRent)) {
			System.out.print(hotel.getHotelName() + "  "); 			
		}
		System.out.println("\nTotal Rent : " + minimumRent);			
		return true;
	}

	public static Map<Integer, ArrayList<Hotel>> createRentMap(String fromDate, String toDate) {
		HashMap<Integer, ArrayList<Hotel>> rentMap = new HashMap<>();
		int days[] = numberOfDays(fromDate, toDate);
		for (Map.Entry<String, Hotel> entry : hotelMap.entrySet()) {
			int weekdayRent = entry.getValue().getRegWeekdayRate() * days[0];
			int weekendRent = entry.getValue().getRegWeekendRate() * days[1];
			int totalRent = weekdayRent + weekendRent;

			rentMap.computeIfAbsent(totalRent, key -> new ArrayList<>()).add(entry.getValue());
		}
		return rentMap;
	}

	public static int[] numberOfDays(String fromDate, String toDate) { 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyy");

		LocalDate from = LocalDate.parse(fromDate, formatter);    // convert String to LocalDate
		LocalDate to = LocalDate.parse(toDate, formatter);		 // convert String to LocalDate
		int numWeekdays = 0;
		int numWeekendDays = 0;
		int days[];
		days = new int[2];

		for (LocalDate date = from; date.isBefore(to.plusDays(1)); date = date.plusDays(1)) {
			DayOfWeek day = DayOfWeek.of(date.get(ChronoField.DAY_OF_WEEK));
			switch(day) {
			case SATURDAY :
				numWeekendDays++;
				break;

			case SUNDAY :
				numWeekendDays++;
				break;

			default :
				numWeekdays++;
				break;
			}
		}
		days[0] = numWeekdays;
		days[1] = numWeekendDays;
		return days;
	}
	public static void main(String[] args) {

		System.out.println("Welcome to Hotel Reservation Program");
	}
}