package dao;

import model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDao {

    void create(Employee employee);

    Employee readById(long id);

    List<Employee> readAll();

    void updateById(Employee employee);

    void deleteById(long id);
}
