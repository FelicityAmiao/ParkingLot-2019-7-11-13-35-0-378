package com.thoughtworks.tdd;

public class ParkingLot {
    private Car car;

    public void parkCar(Car car) {
        this.car = car;
    }

    public Car getCar(Ticket ticket) {
        return this.car;
    }
}
