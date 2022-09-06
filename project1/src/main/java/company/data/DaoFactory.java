package company.data;

public class DaoFactory {
    private static EmployeeDao employeeDao = null;
    private static TicketDao ticketDao = null;

    private DaoFactory() {
    }


    public static EmployeeDao getEmployeeDao() {
        if(employeeDao == null) {
            System.out.println("This should only be called once (Pet Dao Creation)");
            // if we haven't created a pet dao yet, we do that here:
            employeeDao = new EmployeeDaoImpl();
        }
        return employeeDao;
    }
    public static TicketDao getTicketDao() {
        if(employeeDao == null) {
            System.out.println("This should only be called once (Pet Dao Creation)");
            // if we haven't created a pet dao yet, we do that here:
            ticketDao = new TicketDaoImpl();
        }
        return ticketDao;
    }


}
