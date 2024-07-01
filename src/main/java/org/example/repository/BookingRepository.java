package org.example.repository;

import org.example.model.entity.BookingEntity;

import java.util.List;

public interface BookingRepository {

    boolean bookAReservation(String [] passangers, long flightId);
    void cancelAReservation(long bookingId);
    List<BookingEntity> getMyReservations(String passengerName);
}
