package org.example.repository.bookingDao;

import lombok.SneakyThrows;
import org.example.config.JdbcConfig;
import org.example.model.entity.BookingEntity;
import org.example.repository.BookingRepository;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookingDao implements BookingRepository {
    private final JdbcConfig jdbcConfig;

    public BookingDao(JdbcConfig jdbcConfig) {
        this.jdbcConfig = jdbcConfig;
    }

    @SneakyThrows
    @Override
    public boolean bookAReservation(String[] passengers, long flightId) {
        String sql = "INSERT INTO booking (passengers, amount, flightId) VALUES (cast(? as text[]), ?, ?)";
        Connection connection = jdbcConfig.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        Array passengersArray = connection.createArrayOf("text", passengers);

        preparedStatement.setArray(1, passengersArray);
        preparedStatement.setInt(2, passengers.length);
        preparedStatement.setLong(3, flightId);

        int rowsAffected = preparedStatement.executeUpdate();
        connection.close();
        return rowsAffected > 0;
    }

    @SneakyThrows
    @Override
    public void cancelAReservation(long bookingId) {
        String sql = "DELETE FROM booking WHERE id = ?";
        Connection connection = jdbcConfig.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, bookingId);

        preparedStatement.executeUpdate();
        connection.close();
    }

    @SneakyThrows
    @Override
    public List<BookingEntity> getMyReservations(String passengerName) {
        String sql = "SELECT * FROM booking WHERE ? = ANY(passengers)";
        Connection connection = jdbcConfig.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, passengerName);

        ResultSet resultSet = preparedStatement.executeQuery();
        List<BookingEntity> reservations = new ArrayList<>();

        while (resultSet.next()) {
            long id = resultSet.getLong("id");
            Array passengersArray = resultSet.getArray("passengers");
            String[] passengers = (String[]) passengersArray.getArray();
            int amount = resultSet.getInt("amount");
            long flightId = resultSet.getLong("flightId");

            BookingEntity booking = new BookingEntity(id, passengers, amount, flightId);
            reservations.add(booking);
        }

        connection.close();
        return reservations;
    }
}
