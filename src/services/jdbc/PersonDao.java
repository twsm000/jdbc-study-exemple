package services.jdbc;

import model.entities.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDao implements model.dao.PersonDao {
    private Connection connection;

    public PersonDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Person> findAll() {
        List<Person> people = new ArrayList<>();
        String sql = "SELECT * FROM pessoas";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    people.add(newPerson(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return people;
    }

    Person newPerson(ResultSet rs) throws SQLException {
        Person person = new Person();
        person.setName(rs.getString("participante"));
        person.setModeling(rs.getInt("modelagem"));
        person.setJava(rs.getInt("java"));
        person.setGit(rs.getInt("git"));
        person.setApiRest(rs.getInt("api_rest"));
        person.setSpring(rs.getInt("spring"));
        return person;
    }
}
