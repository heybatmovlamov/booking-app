package org.example.repository.systemDao;

import lombok.SneakyThrows;
import org.example.config.JdbcConfig;
import org.example.repository.SystemRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SystemBookingDao  implements SystemRepository {
    private final JdbcConfig jdbcConfig;

    public SystemBookingDao(JdbcConfig jdbcConfig) {
        this.jdbcConfig = jdbcConfig;
    }

    @SneakyThrows
    @Override
    public boolean createTable() {
        String sql = "CREATE TABLE booking(" +
                "id BIGSERIAL PRIMARY KEY, " +
                "passengers TEXT[], " +
                "amount INT NOT NULL, " +
                "flightId BIGINT NOT NULL, " +
                "FOREIGN KEY (flightId) REFERENCES flight(id)" +
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
