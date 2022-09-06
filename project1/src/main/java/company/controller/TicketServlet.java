package company.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import company.entity.Employee;
import company.service.EmployeeService;
import company.service.TicketService;
import company.entity.Ticket;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static java.lang.System.out;

public class TicketServlet extends HttpServlet {
    @Override     //submit a ticket
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            PrintWriter out = resp.getWriter();
            TicketService ticketService = new TicketService();

            ObjectMapper mapper = new ObjectMapper();

            Ticket ticket;
            ticket = mapper.readValue(req.getReader(), Ticket.class);
            ticket = ticketService.insertTicket(ticket);
            out.println(ticket);

    }

    @Override         //update ticket
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        TicketService ticketService = new TicketService();
        ObjectMapper mapper = new ObjectMapper();

        Ticket ticket;
        try{
            ticket= mapper.readValue(req.getReader(), Ticket.class);
        }catch (Exception e) {
            e.printStackTrace();
            resp.sendError(400, "invalid");
            return;
        }
        Ticket ticketDb = ticketService.getTicketByID(ticket.gettId());
        if(ticketDb.getStatus().equals("pending")){
            ticket= ticketService.updateTicket(ticket);
            out.println(ticket);
            out.println("status updated");
        }
        else {out.println("ticket has already been updated before, and cannot be updated again");
        }
        //ticket = ticketService.updateTicket(ticket);
        //out.println(ticket);
    }

    @Override      //tickets history
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        TicketService ticketService = new TicketService();
        Ticket ticket;
        ObjectMapper mapper = new ObjectMapper();

        try{
            ticket = mapper.readValue(req.getReader(),Ticket.class);
        }catch (Exception e) {
            e.printStackTrace();
            resp.sendError(400,"invalid format");
            return;
        }
        int employee_id = ticket.getEmployee_id();
        String status=ticket.getStatus();
        List<Ticket> tickets= ticketService.getSubmission(employee_id,status);
        for(Ticket tiket:tickets){
            out.println(tiket);
            out.println("submitted ticket(s)");
        }
    }

}
