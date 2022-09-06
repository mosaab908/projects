package company.data;

import company.entity.Ticket;

import java.util.List;

public interface TicketDao {

    public Ticket insertTicket(Ticket ticket);
    public List<Ticket> getSubmission(int employee_id, String status);
    public Ticket updateTicket(Ticket tickets);
    public Ticket getTicketByID(int tId);



}
