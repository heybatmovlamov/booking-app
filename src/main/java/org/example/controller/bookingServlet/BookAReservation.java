package org.example.controller.bookingServlet;

import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.example.config.JdbcConfig;
import org.example.repository.bookingDao.BookingDao;
import org.example.service.BookingService;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@NoArgsConstructor
public class BookAReservation extends HttpServlet {

    private BookingService bookingService;

    @Override
    public void init(ServletConfig config) {
        JdbcConfig jdbcConfig = new JdbcConfig();
        BookingDao flightDao = new BookingDao(jdbcConfig);
        this.bookingService = new BookingService(flightDao);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        resp.setContentType("application/json");
        PrintWriter pw = resp.getWriter();

        String[] passengers = new String[]{req.getParameter("passengers")};
        int flightId = Integer.parseInt(req.getParameter("flightId"));

        bookingService.bookAReservation(passengers, flightId);
        pw.write("{\"status\":\"success\"}");
    }
}
