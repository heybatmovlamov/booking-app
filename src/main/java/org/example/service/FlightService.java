package org.example.service;

import org.example.model.dto.FlightDto;
import org.example.model.entity.FlightEntity;
import org.example.repository.FlightRepository;
import org.example.repository.flightDao.FlightDao;

import java.util.Optional;

public class FlightService implements FlightRepository {
    private final FlightDao flightDao;

    public FlightService(FlightDao flightDao) {
        this.flightDao = flightDao;
    }

    @Override
    public Optional<FlightEntity> getFlightById(int id) {
        return flightDao.getFlightById(id);
    }

    @Override
    public Optional<FlightEntity> getFlightByLocation(String location) {
        return flightDao.getFlightByLocation(location);
    }

    @Override
    public void createFlight(FlightDto flightDto) {
        flightDao.createFlight(flightDto);
    }
}
