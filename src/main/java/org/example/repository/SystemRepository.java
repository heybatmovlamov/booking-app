package org.example.repository;

public interface SystemRepository {

    boolean createTable();
    boolean dropTable(String tableName);

}
