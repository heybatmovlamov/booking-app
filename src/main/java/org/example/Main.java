package org.example;

import lombok.SneakyThrows;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.example.controller.bookingServlet.BookAReservation;
import org.example.controller.bookingServlet.BookingCancelReservation;
import org.example.controller.bookingServlet.BookingGetMyReservations;
import org.example.controller.flightServlet.FlightByIdServlet;
import org.example.controller.flightServlet.FlightByLocationServlet;
import org.example.controller.flightServlet.FlightCreateServlet;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        Server server = new Server(9000);

        ServletContextHandler handler = new ServletContextHandler();

        handler.addServlet(new ServletHolder(new FlightByIdServlet()), "/flight/getById");
        handler.addServlet(new ServletHolder(new FlightByLocationServlet()), "/flight/getByLocation");
        handler.addServlet(new ServletHolder(new FlightCreateServlet()), "/flight/create");
        handler.addServlet(new ServletHolder(new BookAReservation()), "/booking/reservation");
        handler.addServlet(new ServletHolder(new BookingGetMyReservations()),"/booking/myReservations");
        handler.addServlet(new ServletHolder(new BookingCancelReservation()), "/booking/cancelReservation");
        server.setHandler(handler);

        server.start();
        server.join();
    }
}