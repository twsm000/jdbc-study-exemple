package application;

import db.DbFactory;
import db.DbPropertiesFactory;
import model.dao.DaoFactory;
import model.entities.Person;
import services.ServicesFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        System.out.println("Starting application...");

        try (DbFactory dbFactory = DbPropertiesFactory.getInstance()) {
            start(dbFactory.getConnection());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return;
        }

        System.out.println("Closing application...");
    }

    private static void start(Connection conn) throws SQLException {
        //DaoFactory dao = ServicesFactory.jdbc(conn);
        DaoFactory dao = ServicesFactory.example();
        List<Person> list = dao.Person().findAll();
        list.sort(Comparator.comparing(Person::getSkillLevel));
        list.forEach(System.out::println);
    }
}
