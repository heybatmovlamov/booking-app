package org.example.repository.systemDao;

import lombok.SneakyThrows;
import org.example.config.JdbcConfig;
import org.example.repository.SystemRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SystemFlightDao implements SystemRepository {
   private final JdbcConfig jdbcConfig;

    public SystemFlightDao(JdbcConfig jdbcConfig) {
        this.jdbcConfig = jdbcConfig;
    }

    @SneakyThrows
    @Override
    public boolean createTable() {
        String sql = "CREATE TABLE flight(" +
                "id BIGSERIAL PRIMARY KEY, " +
                "localdatetime TIMESTAMP NOT NULL, " +
                "location VARCHAR(255) NOT NULL, " +
                "seats INT NOT NULL, " +
                "destination VARCHAR(255) NOT NULL" +
                ")";
        Connection connection = jdbcConfig.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        boolean execute = preparedStatement.execute();
        connection.close();
        return execute;
    }

    @SneakyThrows
    @Override
    public boolean dropTable(String tableName) {
        String sql = "DROP TABLE " + tableName;
        Connection connection = jdbcConfig.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        boolean execute = preparedStatement.execute();
        connection.close();
        return execute;
    }
}
