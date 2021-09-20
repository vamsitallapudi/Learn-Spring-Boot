package com.coderefer.learnconcepts.lld.designParkingLot;

import java.util.List;

public class ParkingLot {
    List<ParkingFloor> parkingFloors;
    List<Entrance> entrances;
    List<Exit> exits;

    Address address;

    String parkingLotName;

    public boolean isParkingSpaceAvailableForVehicle(Vehicle vehicle) {
        return false;
    }

    public boolean updateParkingAttendant(ParkingAttendant attendant, int gateId) {
        return false;
    }
}


class Gate {
    int gateId;
    ParkingAttendant parkingAttendant;
}

class ParkingAttendant {

}

class Entrance extends Gate {
    public ParkingTicket issueParkingTicket(User user, double price, Vehicle vehicle) {
        ParkingTicket parkingTicket = new ParkingTicket(price, vehicle, user, false);
        ParkingTickets.addParkingTicket(parkingTicket);
        return parkingTicket;
    }
}

class Exit extends Gate {
    public void payForParking(ParkingTicket ticket) {
        ticket.pay();
    }
}

class ParkingTickets {
    static List<ParkingTicket> parkingTickets;

    public static void addParkingTicket(ParkingTicket parkingTicket) {
        parkingTickets.add(parkingTicket);
    }

    public static ParkingTicket getParkingTicket(int id) {
        return parkingTickets.stream().filter(p -> p.id == id).findFirst().get();
    }
}

class ParkingTicket {
    double price;
    Vehicle vehicle;
    boolean paid;
    User user;
    int id;
    static int counter;

    ParkingTicket(double price, Vehicle vehicle, User user, boolean paid) {
        this.id = counter++;
        this.price = price;
        this.vehicle = vehicle;
        this.user = user;
        this.paid = paid;
    }

    void pay() {
        user.pay(price);
    }
}

class Address {
    String country;
    String state;
    String city;
}

class User {
    double walletBalance;

    void pay(double price) {
        walletBalance -= price;
        System.out.println("Money deducted from wallet");
    }

}

abstract class Vehicle {
    protected Size size;
}

class Car extends Vehicle {
    public Car() {
        size = Size.CAR;
    }
}

class Bike extends Vehicle {
    public Bike() {
        size = Size.BIKE;
    }
}

class Truck extends Vehicle {
    public Truck() {
        size = Size.TRUCK;
    }
}


class ParkingFloor {
    int levelId;
    boolean isFull;
    List<ParkingSpot> parkingSpots;
    ParkingDisplayBoard parkingDisplayBoard;

    long capacity(Size size) {
        return parkingSpots.stream().filter(p -> (p.size == size && p.isAvailable == true)).count();
    }

    public void updateDisplayBoard() {
        parkingDisplayBoard.updateBikesCapacity(capacity(Size.BIKE));
        parkingDisplayBoard.updateCarsCapacity(capacity(Size.CAR));
        parkingDisplayBoard.updateTrucksCapacity(capacity(Size.TRUCK));
    }
}

class ParkingDisplayBoard {
    long bikesCapacity;
    long carsCapacity;
    long truckCapacity;

    public void updateBikesCapacity(long capacity) {
        bikesCapacity = capacity;
    }

    public void updateCarsCapacity(long capacity) {
        carsCapacity = capacity;
    }

    public void updateTrucksCapacity(long capacity) {
        truckCapacity = capacity;
    }
}

class ParkingSpot {
    int id;
    boolean isAvailable;
    double cost;
    Size size;
}

enum Size {
    BIKE, CAR, TRUCK
}
