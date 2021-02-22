package services.example;

import model.dao.PersonDao;

public class DaoFactory implements model.dao.DaoFactory {
    @Override
    public PersonDao Person() {
        return new services.example.PersonDao();
    }
}
