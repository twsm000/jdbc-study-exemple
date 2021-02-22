package db;

import java.sql.Connection;

public interface DbFactory extends AutoCloseable {
    Connection getConnection();
}
