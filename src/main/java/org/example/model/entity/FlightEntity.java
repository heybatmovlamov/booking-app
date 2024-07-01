package org.example.model.entity;

import java.time.LocalDateTime;

public class FlightEntity {

    private  Long id;
    private LocalDateTime localDateTime;
    private String location;
    private int seats;
    private String destination;

    public FlightEntity(Long id , LocalDateTime localDateTime, String location, int seats, String destination) {
        this.id = id;
        this.localDateTime = localDateTime;
        this.location = location;
        this.destination = destination;
        this.seats = seats;
    }
    private synchronized long generateUniqueId() {
        return id++;
    }
    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", time=" + localDateTime +
                ", location='" + location + '\'' +
                ", destination='" + destination + '\'' +
                ", seats=" + seats +
                '}';
    }
}
