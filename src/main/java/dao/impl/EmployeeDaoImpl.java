package dao.impl;

import dao.CityDao;
import dao.EmployeeDao;
import dao.HibernateSessionFactoryUtil;
import model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import java.io.Serializable;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    private static final String INSERT = "INSERT INTO employee (name, surname, gender, age, city_id) " +
            "VALUES (?, ?, ?, ?, ?)";

    private static final String FIND_LAST_EMPLOYEE = "SELECT * FROM employee ORDER BY id DESC LIMIT 1 ";
    private static final String FIND_BY_ID = "SELECT * FROM employee WHERE id = ? ";
    private static final String FIND_ALL = "SELECT * FROM employee ";
    private static final String UPDATE = "UPDATE employee SET name=?, surname = ?, gender= ?, age = ?, city_id = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM employee WHERE id = ?";
    private final CityDao cityDao = new CityDaoImpl();

    @Override
    public void create(Employee employee) {

        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Serializable id = session.save(employee);
            employee = session.get(Employee.class, id);

            transaction.commit();
        }
    }


    @Override
    public Employee readById(long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Employee.class, id);
    }


    @Override
    public List<Employee> readAll() {
        List<Employee> users = (List<Employee>) HibernateSessionFactoryUtil
                .getSessionFactory().openSession().createQuery("From Employee").list();
        return users;
    }

    @Override
    public void updateById(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();

        }
    }

        @Override
        public void deleteById ( Employee employee){
            try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();

                session.delete(employee);
                transaction.commit();
            }
        }

    /*private Employee readEmployee(ResultSet resultSet) throws SQLException {
        Long cityId = resultSet.getObject("city_id", Long.class);
        City city = null;
        if (cityId != null) {
            city = (City) cityDao.findById(cityId).orElse(null);
        }
        return new Employee(resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getString("surname"),
                resultSet.getString("gender"),
                resultSet.getInt("age"),
                city);

    }*/
    }
