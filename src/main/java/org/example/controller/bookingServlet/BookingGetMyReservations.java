package org.example.controller.bookingServlet;

import lombok.SneakyThrows;
import org.example.config.JdbcConfig;
import org.example.model.entity.BookingEntity;
import org.example.repository.bookingDao.BookingDao;
import org.example.service.BookingService;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class BookingGetMyReservations extends HttpServlet {
    private BookingService bookingService;

    @Override
    public void init(ServletConfig config) {
        JdbcConfig jdbcConfig = new JdbcConfig();
        BookingDao bookingDao = new BookingDao(jdbcConfig);
        this.bookingService = new BookingService(bookingDao);
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("application/json");
        PrintWriter pw = resp.getWriter();

        // Request'ten parametreleri al
        String[] passengerName = new String[]{req.getParameter("passengerName")};
        System.out.println(Arrays.toString(passengerName));
        // Rezervasyonları al
        List<BookingEntity> reservations = bookingService.getMyReservations(Arrays.toString(passengerName));
        pw.write(reservations.toString());
    }
}
