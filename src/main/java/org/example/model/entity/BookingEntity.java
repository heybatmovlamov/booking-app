package org.example.model.entity;

import lombok.Data;

@Data
public class BookingEntity {

    private Long id;
    private String[] passengers;
    private int amount;
    private long flightId;

    public BookingEntity(Long id ,String[] passengers,  int amount ,long flightId) {
        this.id=id;
        this.passengers = passengers;
        this.amount = amount;
        this.flightId = flightId;

    }

}
