package com.thoughtworks.tdd;

public class ParkingBoy {
    private ParkingLot parkingLot;

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket park(Car car) {
        parkingLot.parkCar(car);
        return new Ticket();
    }

    public Car fetch(Ticket ticket) {
        return this.parkingLot.getCar(ticket);
    }
}
