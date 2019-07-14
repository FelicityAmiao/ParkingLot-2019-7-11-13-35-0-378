package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class ParkingCarTest {

    @Test
    public void should_return_car_when_call_fetch_given_ticket_by_parking_car() {
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        parkingBoy.setParkingLot(parkingLot);
        Ticket ticket = parkingBoy.park(car);
        Car car2 = parkingBoy.fetch(ticket);

        assertSame(car, car2);
    }

}
