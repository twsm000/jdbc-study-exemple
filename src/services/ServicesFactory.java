package services;

import model.dao.DaoFactory;

import java.sql.Connection;

public class ServicesFactory {
    public static DaoFactory jdbc(Connection connection) {
        return new services.jdbc.DaoFactory(connection);
    }

    public static DaoFactory example() {
        return new services.example.DaoFactory();
    }
}
