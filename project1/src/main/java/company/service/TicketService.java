package company.service;

import company.data.DaoFactory;
import company.data.TicketDao;
import company.entity.Ticket;
import java.util.List;
import java.util.List;

public class TicketService {
    public Ticket insertTicket(Ticket ticket) {
        //System.out.println("In the service layer, getting the DAO and calling the insert DAO method");
        // declare a pet dao and give it the temporary implementation that we have:
        TicketDao ticketDao = DaoFactory.getTicketDao();
        // insert the pet and return the return value:
        return ticketDao.insertTicket(ticket);
    }

    public List<Ticket> getSubmission(int employee_id, String status) {
        TicketDao ticketDao = DaoFactory.getTicketDao();
        return ticketDao.getSubmission(employee_id, status);

    }

    public Ticket updateTicket(Ticket ticket) {
        TicketDao ticketDao = DaoFactory.getTicketDao();
        return ticketDao.updateTicket(ticket);
    }
    public Ticket getTicketByID(int tId){
        TicketDao ticketDao = DaoFactory.getTicketDao();
        return ticketDao.getTicketByID(tId);
    }

}