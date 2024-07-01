package org.example.repository.flightDao;

import lombok.SneakyThrows;
import org.example.config.JdbcConfig;
import org.example.model.dto.FlightDto;
import org.example.model.entity.FlightEntity;
import org.example.repository.FlightRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.Optional;

public class FlightDao implements FlightRepository {
    private final JdbcConfig jdbcConfig;

    public FlightDao(JdbcConfig jdbcConfig) {
        this.jdbcConfig = jdbcConfig;
    }

    @SneakyThrows
    @Override
    public Optional<FlightEntity> getFlightById(int id) {
        String sql = "SELECT * FROM flight WHERE id = ?";
        FlightEntity flightEntity = null;
        Connection connection = jdbcConfig.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
        ResultSet resultSet = preparedStatement.getResultSet();

        while (resultSet.next()) {
            long flightId = resultSet.getInt(1);
            LocalDateTime departureTime = resultSet.getTimestamp(2).toLocalDateTime();
            String location = resultSet.getString(3);
            int seats = resultSet.getInt(4);
            String destination = resultSet.getString(5);
            flightEntity = new FlightEntity(flightId,departureTime, location, seats, destination);
        }
        connection.close();
        return  Optional.ofNullable(flightEntity);
    }

    @SneakyThrows
    @Override
    public Optional<FlightEntity> getFlightByLocation(String location) {
        String sql = "SELECT * FROM flight WHERE location = ?";
        FlightEntity flightEntity = null;
        Connection connection = jdbcConfig.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, location);
        preparedStatement.execute();
        ResultSet resultSet = preparedStatement.getResultSet();

        while (resultSet.next()) {
            long flightId = resultSet.getInt(1);
            LocalDateTime departureTime = resultSet.getTimestamp(2).toLocalDateTime();
            location = resultSet.getString(3);
            int seats = resultSet.getInt(4);
            String destination = resultSet.getString(5);
            flightEntity = new FlightEntity(flightId,departureTime, location, seats, destination);
        }
        connection.close();
        return  Optional.ofNullable(flightEntity);
    }

    @SneakyThrows
    @Override
    public void createFlight(FlightDto flightDto) {
        String sql = "INSERT INTO Flight (localDateTime, location, seats, destination) " +
                "VALUES ('" + flightDto.getLocalDateTime().toString() + "', '"
                + flightDto.getLocation() + "', "
                + flightDto.getSeats() + ", '"
                + flightDto.getDestination() + "')";
        Connection connection = jdbcConfig.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.execute();
        connection.close();
    }
}
