package db;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbProperties implements Db {
    private final String propertyFile;

    public DbProperties(String propertyFile) {
        this.propertyFile = propertyFile;
    }

    @Override
    public Connection newConnection() {
        Properties properties = loadProperties();
        String url = properties.getProperty("db.url");
        Connection con;
        try {
            con = DriverManager.getConnection(url, properties);
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

        return con;
    }

    private Properties loadProperties() {
        Properties prop;
        try (FileInputStream stream = new FileInputStream(propertyFile)) {
            prop = new Properties();
            prop.load(stream);
        } catch (Throwable e) {
            throw new DbException(e.getMessage());
        }

        return prop;
    }
}
