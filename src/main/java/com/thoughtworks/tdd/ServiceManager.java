package com.thoughtworks.tdd;

import java.util.List;

public class ServiceManager extends ParkingBoy{
    private List<ParkingBoy> parkingBoys;


    public ServiceManager(List<ParkingBoy> parkingBoys) {
        this.parkingBoys = parkingBoys;
    }

    public Ticket specifyParkingBoyPark(ParkingBoy specifyParkingBoy, Car car) {
        return specifyParkingBoy.park(car, new Ticket());
    }

    public List<ParkingBoy> getManagerParkingBoys() {
        return this.parkingBoys;
    }

    public Car specifyParkingBoyFetch(ParkingBoy parkingBoy, Ticket ticket) {
        return parkingBoy.fetch(ticket);
    }
}
