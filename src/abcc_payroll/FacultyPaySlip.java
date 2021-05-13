package abcc_payroll;

public class FacultyPaySlip extends EmployeePaySlip {
    private String qualificationCode;
       
    public FacultyPaySlip() {
    
    }

    public FacultyPaySlip(Employee employee, String qualificationCode, double hoursWorked) {
        super(employee, hoursWorked);
        this.qualificationCode = qualificationCode;
    }

    public String getQualificationCode() {
        return qualificationCode;
    }

    public void setQualificationCode(String qualificationCode) {
        this.qualificationCode = qualificationCode;
    }

    @Override
    public double calculateGrossSalary() {
        double paidPerHour = 0;
        double allowance = 0;
        if(this.qualificationCode.equalsIgnoreCase("M")) {
            paidPerHour = 175.00;
            allowance = 1500.00;
        }
        else if(this.qualificationCode.equalsIgnoreCase("B")) {
            paidPerHour = 100.00;
            allowance = 600.00;
        }
        this.grossSalary = (hoursWorked * paidPerHour) + allowance;
        return this.grossSalary;
    }   
    
    @Override
    public String toString() {
        return "FacultyPaySlip{" + "qualificationCode=" + qualificationCode + '}';
    }   
}
