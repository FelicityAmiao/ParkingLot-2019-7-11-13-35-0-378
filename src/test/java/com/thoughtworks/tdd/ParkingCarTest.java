package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class ParkingCarTest {

    @Test
    public void should_return_car_when_call_fetch_given_ticket_by_parking_car() {
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        parkingBoy.setParkingLot(parkingLot);
        Ticket ticket = parkingBoy.park(car, new Ticket());
        Car car2 = parkingBoy.fetch(ticket);

        assertSame(car, car2);
    }

    @Test
    public void should_return_car_when_call_fetch_given_corresponding_ticket_by_parking_car() {
        Car car = new Car();
        Car car2 = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        parkingBoy.setParkingLot(parkingLot);
        Ticket ticket = parkingBoy.park(car, new Ticket());
        Ticket ticket2 = parkingBoy.park(car2, new Ticket());
        Car fetchCar = parkingBoy.fetch(ticket);
        Car fetchCar2 = parkingBoy.fetch(ticket2);

        assertSame(car, fetchCar);
        assertSame(car2, fetchCar2);
    }

    @Test
    public void should_return_no_car_when_call_fetch_given_fake_ticket_by_parking_car() {
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        parkingBoy.setParkingLot(parkingLot);
        Ticket fakeTicket = new Ticket();
        Car fetchCar = parkingBoy.fetch(fakeTicket);

        assertNull(fetchCar);
    }

    @Test
    public void should_return_no_car_when_call_fetch_given_no_ticket() {
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        parkingBoy.setParkingLot(parkingLot);
        Car fetchCar = parkingBoy.fetch(null);

        assertNull(fetchCar);
    }

    @Test
    public void should_return_no_car_when_call_fetch_given_used_ticket_by_parking_car() {
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        parkingBoy.setParkingLot(parkingLot);
        Ticket ticket = parkingBoy.park(car, new Ticket());
        parkingBoy.fetch(ticket);
        Car fetchCar = parkingBoy.fetch(ticket);

        assertNull(fetchCar);
    }

    @Test
    public void should_return_no_ticket_when_call_park_given_parking_lot_is_full_of_10() {
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        parkingBoy.setParkingLot(parkingLot);
        for(int i = 0; i < 10; i++) {
            parkingBoy.park(car, new Ticket());
        }
        Ticket ticket = parkingBoy.park(car, new Ticket());

        assertNull(ticket);
    }

    @Test
    public void should_return_no_ticket_when_call_park_given_parked_car() {
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        parkingBoy.setParkingLot(parkingLot);
        parkingBoy.park(car, new Ticket());
        Ticket ticket = parkingBoy.park(car, new Ticket());

        assertNull(ticket);
    }

    @Test
    public void should_return_no_ticket_when_call_park_given_null_car() {
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        parkingBoy.setParkingLot(parkingLot);
        Ticket ticket = parkingBoy.park(null, new Ticket());

        assertNull(ticket);
    }

    @Test
    public void should_return_error_message_when_call_fetch_given_wrong_ticket() {
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        parkingBoy.setParkingLot(parkingLot);
        Ticket ticket = parkingBoy.park(car, new Ticket());
        Ticket fakeTicket = new Ticket();
        Car fetchCar = parkingBoy.fetch(fakeTicket);
        parkingBoy.fetch(ticket);
        Car fetchCar2 = parkingBoy.fetch(ticket);
        String errorMessage = parkingBoy.getErrorMessage();

        assertNull(fetchCar);
        assertNull(fetchCar2);
        assertEquals("Unrecognized parking ticket.", errorMessage);
    }

    @Test
    public void should_return_error_message_when_call_fetch_given_no_ticket() {
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        parkingBoy.setParkingLot(parkingLot);
        parkingBoy.park(car, new Ticket());
        Car fetchCar1 = parkingBoy.fetch(null);
        String errorMessage = parkingBoy.getErrorMessage();

        assertNull(fetchCar1);
        assertEquals("Please provide your parking ticket.", errorMessage);
    }

    @Test
    public void should_return_error_message3_when_call_park_given_parking_lot_full_of_10() {
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        parkingBoy.setParkingLot(parkingLot);
        for(int i = 0; i < 10; i++) {
            parkingBoy.park(car, new Ticket());
        }
        parkingBoy.park(car, new Ticket());
        String errorMessage = parkingBoy.getErrorMessage();

        assertEquals("Not enough position.", errorMessage);
    }

}
