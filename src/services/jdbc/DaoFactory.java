package services.jdbc;

import model.dao.PersonDao;

import java.sql.Connection;

public class DaoFactory implements model.dao.DaoFactory {
    private Connection connection;

    public DaoFactory(Connection connection) {
        this.connection = connection;
    }

    @Override
    public PersonDao Person() {
        return new services.jdbc.PersonDao(this.connection);
    }
}
