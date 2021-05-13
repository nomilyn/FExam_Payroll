package abcc_payroll;

public class Employee {
    private int employeeID;
    private String firstName;
    private String lastName;
    private String employeeType;
    
    public Employee() {
    }

    public Employee(int employeeID, String firstName, String lastName, String employeeType) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeType = employeeType;
    }

     public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }
    
    public String getEmployeeName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "Employee{" + "employeeID=" + employeeID + ", firstName=" + firstName + ", lastName=" + lastName + ", employeeType=" + employeeType + '}';
    } 
}
