package org.example.repository;

import org.example.model.dto.FlightDto;
import org.example.model.entity.FlightEntity;

import java.util.Optional;

public interface FlightRepository {

    Optional<FlightEntity> getFlightById(int id);
    Optional<FlightEntity> getFlightByLocation(String location);
    void createFlight(FlightDto flightDto);

}
