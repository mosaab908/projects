package company.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import company.service.EmployeeService;
import company.entity.Employee;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class EmployeeServlet extends HttpServlet {
    @Override  //employee login
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username= req.getParameter("username");
        String password = req.getParameter("password");
        PrintWriter out = resp.getWriter();
        Employee employee;
        EmployeeService employeeService = new EmployeeService();
         employee = employeeService.getLogin(username,password);
        ObjectMapper mapper = new ObjectMapper();
        employee = mapper.readValue(req.getReader(), Employee.class);
        if(employee == null ){
            resp.sendError(400, "invalid");
        }
        else{
            out.println("you are logged in");
            out.print(employee);
        }

    }

    @Override  //new employee
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        EmployeeService employeeService = new EmployeeService();

        ObjectMapper mapper = new ObjectMapper();

        Employee employee;
        employee = mapper.readValue(req.getReader(), Employee.class);
        employee = employeeService.insertRegister(employee);
        out.println(employee);
        out.println("Registration complete");
    }
}