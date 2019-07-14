package com.thoughtworks.tdd;

public class ParkingBoy {
    private ParkingLot parkingLot;
    private String errorMessage;

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket park(Car car, Ticket ticket) {
        if(car == null || parkingLot.isCarFull() || parkingLot.hasParkedCar(car)) {
            this.errorMessage = "Not enough position.";
            return null;
        }else {
            parkingLot.parkCar(car, ticket);
            return ticket;
        }
    }

    public Car fetch(Ticket ticket) {
        if(parkingLot.isFakeOrUsedTicket(ticket)) {
            this.errorMessage = "Unrecognized parking ticket.";
        }else if(ticket == null) {
            this.errorMessage = "Please provide your parking ticket.";
        }
        return this.parkingLot.getCar(ticket);
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
