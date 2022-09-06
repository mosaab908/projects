package company.data;

import company.entity.Ticket;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDaoImpl implements TicketDao {

    Connection connection;


    public TicketDaoImpl() {
        connection = ConnectionFactory.getConnection();
    }

    @Override
    public Ticket insertTicket(Ticket ticket) {

        System.out.println(ticket.toString());
        System.out.println("insert a new ticket");
        String sql = "insert into tickets(tId,description,amount,status,employee_id,firstName,lastName) values(default, ?, ?, ?,?,?,? );";

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, ticket.getDescription());
            preparedStatement.setDouble(2, ticket.getAmount());
            preparedStatement.setString(3, ticket.getStatus());
            preparedStatement.setInt(4, ticket.getEmployee_id());
            preparedStatement.setString(5, ticket.getFirsName());
            preparedStatement.setString(6, ticket.getLastName());

            System.out.println(preparedStatement.toString());


            int count = preparedStatement.executeUpdate();

            if (count == 1) {
                System.out.println("Employee added successfully.");

                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                // right when we get our result set, it actually points to nothing, so we increment it:
                resultSet.next();
                /**
                 * Generated id might look like this:
                 * -------
                 * |  1  |
                 * -------
                 */
                // because result sets in general can return multiple values, we have to specify which one we want
                // but in this case, there's only one value so we take the first one
                int generatedId = resultSet.getInt(1);
                // set the id to the original object:
                ticket.settId(generatedId);
            } else {
                System.out.println("Something went wrong with the insert!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong when preparing the statement!");
        }

        return ticket;
    }


    public List<Ticket> getSubmission(int employee_id, String status) {

        String sql = "select * from tickets where employee_id=? and status=? ;";
        List<Ticket> tickets = new ArrayList<>();
        // no actual parameter values here

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //
            preparedStatement.setInt(1, employee_id);
            preparedStatement.setString(2, status);
            System.out.println(preparedStatement);
            // Now that we've prepared the statement, we just want to execute it:
            // Result set is going to store the return value of the query:
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                //parse out and extract the data
                int tId = resultSet.getInt("tId");
                String description = resultSet.getString("description");
                double amount = resultSet.getDouble("amount");
                String sstatus = resultSet.getString("status");
                 int mployee_id = resultSet.getInt("employee_id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");

                // use the data to create a pet object

                Ticket ticket = new Ticket(tId, description, amount, sstatus, mployee_id, firstName, lastName);


                tickets.add(ticket);

            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to retrieve data.");
            e.printStackTrace();

        }
        // if we reach the end of this method, return null
        return tickets;
    }

    public Ticket updateTicket(Ticket ticket) {
        String sql = " update tickets set status = ? where tId = ? ;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ticket.getStatus());
            preparedStatement.setInt(2, ticket.gettId());

            //String s="pending";
            //tickets.setStatus("approved");
            int count = preparedStatement.executeUpdate(); // DML, we use executeUpdate instead of executeQuery
            //ResultSet resultSet = preparedStatement.executeQuery();

            if (count == 1) {
                System.out.println("Update successful!");
                return  ticket;
            } else {
                System.out.println("Something went wrong with the update");
                if (count == 0) {
                    System.out.println("No rows were affected");
                } else {
                    System.out.println("Many rows were affected");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        // return null
        return ticket;
    }

    public Ticket getTicketByID(int tId) {
        String sql = "select * from tickets where tId = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //
            preparedStatement.setInt(1, tId);
            System.out.println(preparedStatement);
            // Now that we've prepared the statement, we just want to execute it:
            // Result set is going to store the return value of the query:
            ResultSet resultSet = preparedStatement.executeQuery();

            // make sure we actually got a value from the query:
            if (resultSet.next()) {
                // parse out and extract the data
                int Id = resultSet.getInt("tId");
                String description = resultSet.getString("description");
                double amount = resultSet.getDouble("amount");
                String status = resultSet.getString("status");
                //String stat = resultSet.getString("status");
                int employee_id = resultSet.getInt("employee_id");
                String firsName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                // use the data to create a pet object
                Ticket ticket = new Ticket(Id, description, amount, status, employee_id, firsName, lastName);
                // return the pet object
                return ticket;
            } else {
                System.out.println("something went wrong when trying to query for the pet, pet might not exist");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to retrieve data.");
            e.printStackTrace();

        }
        // if we reach the end of this method, return null
        return null;
    }
}