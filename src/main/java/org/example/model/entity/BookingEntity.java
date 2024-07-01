package org.example.model.entity;

public class BookingEntity {

    private static Long id;
    private String[] passengers;
    private long flightId;
    private int amount;

    public BookingEntity(String[] passengers, long flightId, int amount) {
        id = generateUniqueId();
        this.passengers = passengers;
        this.flightId = flightId;
        this.amount = amount;
    }

    private synchronized long generateUniqueId() {
        return id++;
    }
}
