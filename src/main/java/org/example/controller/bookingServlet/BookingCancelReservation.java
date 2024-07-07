package org.example.controller.bookingServlet;

import lombok.SneakyThrows;
import org.example.config.JdbcConfig;
import org.example.repository.bookingDao.BookingDao;
import org.example.service.BookingService;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class BookingCancelReservation extends HttpServlet {
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

        int id = Integer.parseInt(req.getParameter("id"));
        bookingService.cancelAReservation(id);

        pw.println("reservation cancelled");
    }
}