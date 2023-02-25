package dao;

import com.sun.tools.javac.util.List;

import java.util.Optional;

public interface Employee {
    Optional<Employee> create(Employee employee);

    Optional<Employee> readById(long id);

    List<Employee> readAll();

    Optional<Employee> updateById(Employee employee);

    Optional<Employee> deleteById(long id);
}
