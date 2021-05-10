package HotelManagement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

public class HotelReservationTest {

	@Test
	public void whenNewHotelAdded_shouldReturnTrue() {

		HotelReservation hotelReservationObject = new HotelReservation();
		Assert.assertTrue(hotelReservationObject.addHotel("Lakewood", 110));
		Assert.assertTrue(hotelReservationObject.addHotel("Bridgewood", 160));
		Assert.assertTrue(hotelReservationObject.addHotel("Ridgewood", 110));

		hotelReservationObject.printHotels();
	}
	@Test
	public void whenFindCheapestHotelMethodCalled_shouldReturn_nameOfHotel() {
		HotelReservation hotelReservation = new HotelReservation();
		assertTrue(hotelReservation.addHotel("Lakewood", 110));
		assertTrue(hotelReservation.addHotel("Bridgewood", 160));
		assertTrue(hotelReservation.addHotel("Ridgewood", 220));
		assertTrue(hotelReservation.findCheapestHotel("Regular", "11Sep2020", "12Sep2020"));
	}
	@Test
	public void whenNewHotelAddedWithWeekend_shouldReturnTrue() {

		HotelReservation hotelReservationObject = new HotelReservation();
		assertTrue(hotelReservationObject.addHotel("Lakewood", 110, 90));
		assertTrue(hotelReservationObject.addHotel("Bridgewood", 160, 60));
		assertTrue(hotelReservationObject.addHotel("Ridgewood", 110, 150));

		hotelReservationObject.printHotels();
	}
	@Test
	public void whenFindCheapestHotelIsCalled_shouldReturn_nameOfHotelWithCheapestRent() {
		HotelReservation hotelReservation = new HotelReservation();
		assertTrue(hotelReservation.addHotel("Lakewood", 110, 90));
		assertTrue(hotelReservation.addHotel("Bridgewood", 160, 60));
		assertTrue(hotelReservation.addHotel("Ridgewood", 220, 150));
		assertTrue(hotelReservation.findCheapestHotel("Regular", "11Sep2020", "12Sep2020"));
		}

	@Test
	public void whenNewHotelAddedWithRating_shouldReturnTrue() {

		HotelReservation hotelReservationObject = new HotelReservation();
		assertTrue(hotelReservationObject.addHotel("Lakewood", 110, 90, 3));
		assertTrue(hotelReservationObject.addHotel("Bridgewood", 160, 60, 4));
		assertTrue(hotelReservationObject.addHotel("Ridgewood", 220, 150, 5));

		hotelReservationObject.printHotels();

	}
	@Test
	public void whenCheapestBestRatedCalled_shouldReturn_bestRatedHotel() {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 110, 90, 3);
		hotelReservation.addHotel("Bridgewood", 150, 50, 4);
		hotelReservation.addHotel("Ridgewood", 220, 150, 5);
		assertTrue(hotelReservation.cheapestBestRatedHotel("Regular", "11Sep2020", "12Sep2020"));
	}
	@Test
	public void whenFindBestRatedMethodCalled_shouldReturn_bestRatedHotel() {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 110, 90, 3);
		hotelReservation.addHotel("Bridgewood", 150, 50, 4);
		hotelReservation.addHotel("Ridgewood", 220, 150, 5);
		assertTrue(hotelReservation.findBestRatedHotelForGivenDates("11Sep2020", "12Sep2020"));
	}
	@Test
	public void whenAddedRatesForRewardCustomers_shouldAdd_hotelWithAllRates() {
		HotelReservation hotelReservationObject = new HotelReservation();
		hotelReservationObject.addHotel("Lakewood", 110, 90, 3, 80, 80);
		hotelReservationObject.addHotel("Bridgewood", 150, 50, 4, 110, 50);
		hotelReservationObject.addHotel("Ridgewood", 220, 150, 5, 100, 40);
		hotelReservationObject.printHotels();
		}
	@Test
	public void whenCheapestBestRatedCalledForRewardCustomers_shouldReturn_bestRatedHotel() {
		HotelReservation hotelReservationObject = new HotelReservation();
		hotelReservationObject.addHotel("Lakewood", 110, 90, 3);
		hotelReservationObject.addHotel("Bridgewood", 150, 50, 4);
		hotelReservationObject.addHotel("Ridgewood", 220, 150, 5);
		assertTrue(hotelReservationObject.cheapestBestRatedHotel("Reward", "11Sep2020", "12Sep2020"));
	}
	
	@Test
	public void whenInvalidEntriesGiven_shouldThrowInvalidEntryException() {
		HotelReservation hotelReservationObject = new HotelReservation();
		hotelReservationObject.addHotel("Lakewood", 110, 90, 3, 80, 80);
		hotelReservationObject.addHotel("Bridgewood", 150, 50, 4, 110, 50);
		hotelReservationObject.addHotel("Ridgewood", 220, 150, 5, 100, 40);
		assertThrows(InvalidEntryException.class, () -> {
			hotelReservationObject.validateInputs("Random", "11Sep2020", "12Sep2020");
		});
	}
} 