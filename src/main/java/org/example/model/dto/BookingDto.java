package org.example.model.dto;

public class BookingDto {

    private Long id;
    private String[] passengers;
    private long flightId;
    private int amount;

    public BookingDto(Long id, String[] passengers, long flightId, int amount) {
        this.id = id;
        this.passengers = passengers;
        this.flightId = flightId;
        this.amount = amount;
    }
}