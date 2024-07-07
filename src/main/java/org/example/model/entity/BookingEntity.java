package org.example.model.entity;

import lombok.Data;

import java.util.Arrays;

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

    @Override
    public String toString() {
        return "BookingEntity{" +
                "id=" + id +
                ", passengers=" + Arrays.toString(passengers) +
                ", amount=" + amount +
                ", flightId=" + flightId +
                '}';
    }
}
