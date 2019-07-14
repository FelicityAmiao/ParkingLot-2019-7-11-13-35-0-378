package com.thoughtworks.tdd;

public class ParkingBoy {
    private ParkingLot parkingLot;

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket park(Car car, Ticket ticket) {
        if(parkingLot.isCarFull()) {
            return null;
        }else {
            parkingLot.parkCar(car, ticket);
            return ticket;
        }
    }

    public Car fetch(Ticket ticket) {
        return this.parkingLot.getCar(ticket);
    }
}
