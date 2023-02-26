package dao.impl;

import dao.CityDao;
import dao.HibernateSessionFactoryUtil;
import model.City;
import org.hibernate.Session;

import java.util.Optional;

public class CityDaoImpl implements CityDao {
    @Override
    public Optional<City> findById(long id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return Optional.ofNullable(session.get(City.class, id));
        }
    }
}
