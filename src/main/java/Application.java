
import dao.EmployeeDao;
import dao.impl.EmployeeDaoImpl;
import model.City;
import model.Employee;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        EmployeeDao employeeDao = new EmployeeDaoImpl();
        City tula= new City(3,"Тула");
        City kaluga = new City(4, "Калуга");

        Employee manua = employeeDao.create(new Employee("Маня", "Федотова","жен", 22, 3L));
        System.out.println("Добавлен сотрудник" + manua);
        Employee vika = employeeDao.create(new Employee("Вика", "Сидорова","жен", 25, 4L));
        System.out.println("Добавлен сотрудник" + manua);;


        // Получаем объект по id
        System.out.println(employeeDao.readById(1));

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