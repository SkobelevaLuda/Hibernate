
import dao.EmployeeDao;
import dao.impl.EmployeeDaoImpl;
import model.City;
import model.Employee;

import java.sql.*;
import java.util.Optional;

public class Application {
    public static void main(String[] args) {
        EmployeeDao employeeDao = (EmployeeDao) new Employee();
        City kazan = new City(6,"Казань");
        City podolsk = new City(7,"Подольск");

        employeeDao.create(new Employee("Марфа", "Васильева", "жен", 50, kazan))
                .ifPresent(employee -> System.out.println("Добавлен сотрудник" +employee));
        Optional<Employee> employeeOptional=employeeDao.create(new Employee
                ("Иван", "Ванин", "муж", 40, podolsk));
        //  System.out.println(employeeDAO.create(new Employee("Марфа","Васильева", "жен",55)));

        System.out.println("Все сотрудники");
        employeeDao.readAll().forEach(System.out::println);

        if (employeeOptional.isPresent()){
            employeeDao.readById(employeeOptional.get().getId())
                    .ifPresent(employee -> System.out.println("Найден сотрудник"+employee));
        }
        if (employeeOptional.isPresent()){
            Employee employee = employeeOptional.get();
            employee.setAge(25);
            employee.setName("Ольга");
            employeeDao.updateById(employee)
                    .ifPresent(emp -> System.out.println("Обновленный сотрудник"+emp));
        }

        if (employeeOptional.isPresent()){
            employeeDao.deleteById(employeeOptional.get().getId())
                    .ifPresent(emp -> System.out.println(" Удаленный сотрудник"+emp));
        }

    }

}