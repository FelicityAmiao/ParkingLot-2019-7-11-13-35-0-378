package com.thoughtworks.tdd;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<Ticket, Car> cars = new HashMap<>();

    public void parkCar(Car car, Ticket ticket) {
        cars.put(ticket, car);
    }

    public Car getCar(Ticket ticket) {
        return cars.remove(ticket);
    }
}