package HotelManagement;

public class Hotel {

	public String hotelName;
	public int regWeekdayRate;

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getRegWeekdayRate() {
		return regWeekdayRate;
	}

	public void setRegWeekdayRate(int regWeekdayRate) {
		this.regWeekdayRate = regWeekdayRate;
	}

	public Hotel(String hotelName, int regWeekdayRate) {
		super();
		this.hotelName = hotelName;
		this.regWeekdayRate = regWeekdayRate;
	}
}
