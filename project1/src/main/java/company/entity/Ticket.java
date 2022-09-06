package company.entity;

public class Ticket {

    private int tId;
    private String description;
    private double amount;
    private String status;
    private int employee_id;
    private String firsName;
    private String lastName;

    public Ticket(){}

    public Ticket(String description, double amount, String status, int employee_id, String firsName, String lastName) {
        this.description = description;
        this.amount = amount;
        this.status = status;
        this.employee_id = employee_id;
        this.firsName = firsName;
        this.lastName = lastName;
    }

    public Ticket(int tId, String description, double amount, String status, int employee_id, String firsName, String lastName) {
        this.tId = tId;
        this.description = description;
        this.amount = amount;
        this.status = status;
        this.employee_id = employee_id;
        this.firsName = firsName;
        this.lastName = lastName;
    }

    public Ticket(int tId, String description, double amount, String status, String firsName, String lastName) {
        this.tId = tId;
        this.description = description;
        this.amount = amount;
        this.status = status;
        this.firsName = firsName;
        this.lastName = lastName;
    }

    public Ticket(int tId, String status) {
        this.tId = tId;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "tId=" + tId +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", employee_id=" + employee_id +
                ", firsName='" + firsName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}