package org.example.repository.bookingDao;

import org.example.model.entity.BookingEntity;
import org.example.repository.BookingRepository;

import java.util.List;

public class BookingDao implements BookingRepository {
    @Override
    public boolean bookAReservation(String[] passengers, long flightId) {
        return false;
    }

    @Override
    public void cancelAReservation(long bookingId) {

    }

    @Override
    public List<BookingEntity> getMyReservations(String passengerName) {
        return null;
    }
}
