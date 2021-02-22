package db;

import java.sql.Connection;
import java.util.Objects;

public class DbPropertiesFactory implements DbFactory {
    private static DbPropertiesFactory factory;
    private static Connection connection;
    private String propertiesFile;

    public static DbPropertiesFactory getInstance() {
        if (factory == null) {
            factory = new DbPropertiesFactory();
        }

        return factory;
    }

    @Override
    public Connection getConnection() {
        if (connection == null) {
            System.out.println("Creating connection...");
            Db db = new DbProperties(this.getPropertiesFile());
            connection = db.newConnection();
        }
        return connection;
    }

    private String getPropertiesFile() {
        return Objects.requireNonNullElse(propertiesFile, "db.properties");
    }

    public DbPropertiesFactory setPropertiesFile(String propertiesFile) {
        factory.propertiesFile = propertiesFile;
        return factory;
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing connection...");
        connection.close();
    }
}
