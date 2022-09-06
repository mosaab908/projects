package company.data;

import company.entity.Employee;


public interface EmployeeDao {

    public Employee insertRegister(Employee employee);
    public Employee getLogin(String username, String password);
    //public Employees insertTicket(Tickets ticket);
   // public Employees getSubmission(int employee_id);

}
