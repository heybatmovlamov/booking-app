package org.example.service;

import lombok.AllArgsConstructor;
import org.example.model.entity.BookingEntity;
import org.example.repository.BookingRepository;
import org.example.repository.bookingDao.BookingDao;
import java.util.List;

@AllArgsConstructor
public class BookingService implements BookingRepository {

    private final BookingDao bookingDao;

    @Override
    public boolean bookAReservation(String[] passengers, long flightId) {
       return bookingDao.bookAReservation(passengers,flightId);
    }

    @Override
    public void cancelAReservation(long bookingId) {
         bookingDao.cancelAReservation(bookingId);
    }

    @Override
    public List<BookingEntity> getMyReservations(String passengerName) {
        return bookingDao.getMyReservations(passengerName);
    }
}
