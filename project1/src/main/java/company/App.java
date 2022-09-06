package company;
import company.entity.Employee;
import company.entity.Ticket;
import company.service.EmployeeService;
import company.service.TicketService;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void menu() {
        // initialize objects for Service:
        EmployeeService employee = new EmployeeService();
        TicketService ticket = new TicketService();
        TicketService ticketService = new TicketService();
        Ticket ticket1=new Ticket();
        // set up scanners
        Scanner intScanner = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);
        Scanner doubleScanner = new Scanner(System.in);
        // loop endlessly
        while (true) {
            // print out the options:
            printOptions();
            // get the choice from the user:
            int choice = intScanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter employee information");
                    System.out.print("firstname => ");
                    String firstName = stringScanner.nextLine();
                    System.out.print("lastname=> ");
                    String lastName = stringScanner.nextLine();
                    System.out.print("username => ");
                    String username = stringScanner.nextLine();
                    System.out.print("password => ");
                    String password = stringScanner.nextLine();
                    //System.out.print("role => ");
                    //String role = stringScanner.nextLine();
                    Employee newEmployee = new Employee(firstName,lastName,username,password);
                    System.out.println(employee.insertRegister(newEmployee));
                    break;
                case 2:
                    System.out.print("Enter username: ");
                    String x= stringScanner.nextLine();
                    System.out.print("Enter password: ");
                    String y= stringScanner.nextLine();
                    System.out.println(employee.getLogin(x,y));
                    break;
                case 3:
                    System.out.println("Enter ticket information");
                    System.out.print("description => ");
                    String description = stringScanner.nextLine();
                    System.out.print("amount=> ");

                    double amount = doubleScanner.nextDouble();
                    System.out.print("status => ");
                    String status = stringScanner.nextLine();
                    System.out.print("employee_id => ");
                    int employee_id = intScanner.nextInt();
                    System.out.print("firstname => ");
                    String firstname = stringScanner.nextLine();
                    System.out.print("lastname => ");
                    String lastname = stringScanner.nextLine();
                    //System.out.print("role => ");
                    //String role = stringScanner.nextLine();
                    Ticket newticket = new Ticket(description,amount,status,employee_id,firstname,lastname);
                    System.out.println(ticket.insertTicket(newticket));
                case 4:
                   // System.out.print("employee_id => ");
                    //int employeeId = intScanner.nextInt();
                    //System.out.print("firstname => ");
                    //String stat = stringScanner.nextLine();
                    //List<Ticket> tickets1 = ticketService.getSubmission(employeeId, stat);
                    //for(int i = 0; i < tickets1.size(); i ++) {
                      //  System.out.println(tickets1.get(i));

                   // }
                   // List <Ticket> tickets1=ticketService.getSubmission(ticket1.getEmployee_id(), ticket1.getStatus());
                   // for(Ticket tickets: tickets1){
                   //     System.out.println(tickets);
                   // }
                    System.out.println("emID");
                    int g =intScanner.nextInt();
                    System.out.println("enter stat");
                    String h = stringScanner.nextLine();
                    List<Ticket>ticket9=ticketService.getSubmission(g,h);
                    for(int i=0; i < ticket9.size();i++){
                        System.out.println(ticket9.get(i));
                    }

                    break;
                case 5:
                    System.out.print("enter tId=> ");
                    int tId = intScanner.nextInt();
                    System.out.println("enter updated status");
                    String s= stringScanner.nextLine();
                    Ticket tickets = new Ticket(tId,s);
                    //System.out.print("enter tId=> ");
                   // int td = intScanner.nextInt();
                    System.out.println(ticket.updateTicket(tickets));
                    break;
            }
        }

    }
    public static void printOptions() {
        System.out.println("What would you like to do?");
        System.out.println("1 - Add employee");
        System.out.println("2- login");
        System.out.println("3- insert a ticket");
        System.out.println("4- view tickets");
        System.out.println("5- update a ticket");
    }
}