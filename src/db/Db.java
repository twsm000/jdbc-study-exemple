package db;

import java.sql.Connection;

public interface Db {
    Connection newConnection();
}
