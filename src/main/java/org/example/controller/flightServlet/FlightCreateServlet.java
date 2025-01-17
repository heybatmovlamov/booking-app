package org.example.controller.flightServlet;

import lombok.SneakyThrows;
import org.example.config.JdbcConfig;
import org.example.model.dto.FlightDto;
import org.example.repository.flightDao.FlightDao;
import org.example.service.FlightService;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FlightCreateServlet extends HttpServlet {
    private FlightService flightService;


    @Override
    public void init(ServletConfig config) {
        JdbcConfig jdbcConfig = new JdbcConfig();
        FlightDao flightDao = new FlightDao(jdbcConfig);
        this.flightService = new FlightService(flightDao);
    }


    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("application/json");
        PrintWriter pw = resp.getWriter();

        String localDateTimeS = req.getParameter("localdatetime");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSSS");
        LocalDateTime localDateTime = LocalDateTime.parse(localDateTimeS, formatter);

        String location = req.getParameter("location");
        String destination = req.getParameter("destination");
        int seats = Integer.parseInt(req.getParameter("seats"));

        FlightDto flightDto = new FlightDto(localDateTime, location, destination, seats);
        flightService.createFlight(flightDto);

        pw.write("{\"status\":\"success\"}");
    }
}
