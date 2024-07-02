package org.example.controller.flightServlet;

import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.example.config.JdbcConfig;
import org.example.model.entity.FlightEntity;
import org.example.repository.flightDao.FlightDao;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Optional;

@NoArgsConstructor
public class FlightByIdServlet extends HttpServlet {

    private  FlightDao flightDao;

    @Override
    public void init(ServletConfig config) {
        JdbcConfig jdbcConfig = new JdbcConfig();
        this.flightDao = new FlightDao(jdbcConfig);
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("application/json");

        PrintWriter pw = resp.getWriter();

        int id = Integer.parseInt(req.getParameter("id"));
        Optional<FlightEntity> flightById = flightDao.getFlightById(id);
        System.out.println("GET method called -> " + LocalDateTime.now());

        flightById.ifPresent(flight -> pw.println(flight.toString()));
    }
}