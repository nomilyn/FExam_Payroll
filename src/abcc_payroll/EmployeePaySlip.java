package abcc_payroll;

public abstract class EmployeePaySlip {
    protected Employee employee;
    protected double hoursWorked;
    protected double grossSalary;

    public EmployeePaySlip() {
        grossSalary = 0;
    }

    public EmployeePaySlip(Employee employee, double hoursWorked) {
        this.employee = employee;
        this.hoursWorked = hoursWorked;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
    
    public double getIncomeTax() {
        double gross = this.grossSalary;
        final double TAX_RATE = 0.25;
        final double TAX_FREE_ALLOWANCE = 2500;
        double incomeTax = 0;
        
        if(gross < TAX_FREE_ALLOWANCE) { 
            incomeTax = 0;
        }
        else {
           incomeTax =  (gross - TAX_FREE_ALLOWANCE) * TAX_RATE; 
        }
        return incomeTax;
    }
    
    public double getHealthSurchargeFee() {
        double healthSurchargeFee = 19.2;
        if(this.grossSalary > 3000) {
            healthSurchargeFee = 33.00;
        }
        return healthSurchargeFee;
    }
    
    public double calculateDeduction() {
        return getIncomeTax() + getHealthSurchargeFee();
    }
    
    public double calculateNetSalary() {
        return this.grossSalary - this.calculateDeduction();
    }
    
    public abstract double calculateGrossSalary();

    @Override
    public String toString() {
        return "EmployeePaySlip{" + "employee=" + employee + ", hoursWorked=" + hoursWorked + ", grossSalary=" + grossSalary + '}';
    }
    
}

