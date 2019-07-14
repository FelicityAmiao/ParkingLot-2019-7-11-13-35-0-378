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

    public boolean isCarFull() {
        return cars.size() == 10;
    }

    public boolean hasParkedCar(Car car) {
        return cars.containsValue(car);
    }

    public boolean isFakeOrUsedTicket(Ticket ticket) {
        return cars.containsKey(ticket);
    }

    public int getRestCapacity() {
        return 10 - cars.size();
    }
}
