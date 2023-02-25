
import dao.EmployeeDao;
import dao.impl.EmployeeDaoImpl;
import model.City;
import model.Employee;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class Application {
    public static void main(String[] args) {
        // Создаем объект класса ДАО
        EmployeeDao employeeDao = new EmployeeDaoImpl();

        Employee employee1 = new Employee("Маня", "Федотова","жен", 22);
        // Создаем объект
        employeeDao.create(employee1);

        // Получаем объект по id
        System.out.println(employeeDao.readById(2));

        // Получаем полный список объектов
        List<Employee> list = employeeDao.readAll();

        for (Employee employee : list) {
            System.out.println(employee);
        }

        Employee employee2 = new Employee("Коля", "Мишин", "муж", 41);

        // Изменяем объект
       // employeeDao.updateById(employee2);

        // Удаляем объект
       // employeeDao.deleteById(3);

    }

}