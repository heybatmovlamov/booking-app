package org.example.model.dto;

import lombok.Data;

@Data
public class BookingDto {

    private Long id;
    private String[] passengers;
    private long flightId;
    private int amount;

    public BookingDto(String[] passengers, long flightId, int amount) {
        this.passengers = passengers;
        this.flightId = flightId;
        this.amount = amount;
    }
}