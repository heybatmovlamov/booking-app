package org.example;

import lombok.SneakyThrows;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.example.controller.flightServlet.FlightByIdServlet;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        Server server = new Server(9000);

        ServletContextHandler handler = new ServletContextHandler();

        handler.addServlet(new ServletHolder(new FlightByIdServlet()), "/flight/id");

        server.setHandler(handler);

        server.start();
        server.join();
    }
}