package company.service;
import company.data.DaoFactory;
import company.data.EmployeeDao;
import company.entity.Employee;

public class EmployeeService {
    public Employee insertRegister(Employee employees) {
        //System.out.println("In the service layer, getting the DAO and calling the insert DAO method");
        // declare a pet dao and give it the temporary implementation that we have:
        EmployeeDao employeeDao = DaoFactory.getEmployeeDao();
        // insert the pet and return the return value:
        return employeeDao.insertRegister(employees);
    }

    public Employee getLogin(String username, String password) {
        EmployeeDao employeeDao = DaoFactory.getEmployeeDao();
        return employeeDao.getLogin(username, password);

    }
}

