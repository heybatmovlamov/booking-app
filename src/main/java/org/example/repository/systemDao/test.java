package org.example.repository.systemDao;

import org.example.config.JdbcConfig;
import org.example.repository.flightDao.FlightDao;

public class test {
    private final SystemDao systemRepo;
    private final FlightDao flightRepo;
    private final JdbcConfig jdbcConfig;

    public test(SystemDao systemRepo, FlightDao flightRepo, JdbcConfig jdbcConfig) {
        this.systemRepo = systemRepo;
        this.flightRepo = flightRepo;
        this.jdbcConfig = jdbcConfig;
    }

    public static void main(String[] args) {

    }
}
