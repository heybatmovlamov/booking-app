package org.example.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class FlightDto {

    private Long id;
    private LocalDateTime localDateTime;
    private String location;
    private String destination;
    private int seats;

    public FlightDto(LocalDateTime localDateTime, String location, String destination, int seats) {
        this.localDateTime = localDateTime;
        this.location = location;
        this.destination = destination;
        this.seats = seats;
    }
}
