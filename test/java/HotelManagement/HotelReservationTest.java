package HotelManagement;

import static org.junit.Assert.assertEquals;
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
		assertEquals("Lakewood", hotelReservation.findCheapestHotel("10Sep2020", "11Sep2020"));
	}
} 