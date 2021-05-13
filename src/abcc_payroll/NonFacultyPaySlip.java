package abcc_payroll;

public class NonFacultyPaySlip extends EmployeePaySlip {
    private double monthlySalary;

    public NonFacultyPaySlip() {
    }

    public NonFacultyPaySlip(Employee employee, double monthlySalary, double hoursWorked) {
        super(employee, hoursWorked);
        this.monthlySalary = monthlySalary;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateGrossSalary() {
        final double REGULAR_HOURS_WORKED = 160;
        double paidPerHour = this.monthlySalary / REGULAR_HOURS_WORKED;
        if(hoursWorked < REGULAR_HOURS_WORKED) {
            this.grossSalary = hoursWorked * paidPerHour;
        }
        else if(hoursWorked > REGULAR_HOURS_WORKED) {
            double doubleTimePay = (hoursWorked - REGULAR_HOURS_WORKED) * paidPerHour * 2;
            this.grossSalary = this.monthlySalary + doubleTimePay;
        }
        else {
            this.grossSalary = this.monthlySalary;
        }
        return this.grossSalary;
    }

    @Override
    public String toString() {
        return "NonFacultyPaySlip{" + "monthlySalary=" + monthlySalary + '}';
    }
}
