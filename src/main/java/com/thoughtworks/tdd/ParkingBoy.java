package com.thoughtworks.tdd;

public class ParkingBoy {
    private ParkingLot parkingLot;

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket park(Car car, Ticket ticket) {
        if(car == null || parkingLot.isCarFull() || parkingLot.hasParkedCar(car)) {
            return null;
        }else {
            parkingLot.parkCar(car, ticket);
            return ticket;
        }
    }

    public Car fetch(Ticket ticket) {
        return this.parkingLot.getCar(ticket);
    }

    public String giveErrorMessage(Ticket ticket) {
        if(ticket != null) {
            return "Unrecognized parking ticket.";
        }
        return "Please provide your parking ticket.";
    }
}
