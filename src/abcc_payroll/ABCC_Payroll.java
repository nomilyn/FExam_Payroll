package abcc_payroll;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ABCC_Payroll {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String answer = "";
        int totalNumberOfAllEmployees = 0;
        int totalNumberOfFacultyEmployees = 0;
        int totalNumberOfNonFacultyEmployees = 0;
        int employeeID = 0;
        ArrayList<EmployeePaySlip> employees = new ArrayList();
        
        do {
            System.out.print("Enter Employee ID : ");
            try {
                employeeID = read.nextInt();
            }
            catch(InputMismatchException ex) {
                System.out.println("Error : " +ex.getMessage());
                exit(0);
            }
            
            System.out.print("Enter First Name : ");
            String firstName = read.next();
            
            System.out.print("Enter Last Name : ");
            String lastName = read.next();
            
            System.out.print("Enter Employee Type [F/N] : ");
            String employeeType = read.next();

            double numberOfHoursWorked = 0;
            switch(employeeType.toUpperCase()) {
                case "F":                  
                    System.out.print("Enter Qualification Code [M/B] : ");
                    String qualificationCode = read.next();
                    
                    System.out.print("Enter Number of Hours Worked: ");
                    numberOfHoursWorked = read.nextDouble();
                    
                    totalNumberOfFacultyEmployees++;
                    
                    FacultyPaySlip facultyPaySlip = new FacultyPaySlip(new Employee(employeeID, firstName, lastName, employeeType), qualificationCode, numberOfHoursWorked);
                    employees.add(facultyPaySlip);
                    
                    break;
                case "N":    
                    System.out.print("Enter Monthly Salary : ");
                    double monthlySalary = read.nextDouble();
                    
                    System.out.print("Enter Number of Hours Worked : ");
                    numberOfHoursWorked = read.nextDouble();
                    
                    totalNumberOfNonFacultyEmployees++;
                    
                    NonFacultyPaySlip nonFacultyPaySlip = new NonFacultyPaySlip(new Employee(employeeID, firstName, lastName, employeeType), monthlySalary, numberOfHoursWorked);
                    employees.add(nonFacultyPaySlip);
                    break;
                default:
                    System.out.println("You have entered an incorrect option");
            }
           
            System.out.print("\nDo you want to add another employee? If YES, enter 'Y'. Otherwise any key to exit : ");
            answer = read.next();
            System.out.println();
        } while(answer.equalsIgnoreCase("Y"));
        
        totalNumberOfAllEmployees = totalNumberOfFacultyEmployees + totalNumberOfNonFacultyEmployees;

        System.out.println("\n----------------------------------------------------------------------------");
        System.out.println("Pay Slip has been generated. Please check the 'payroll.txt' file. Thank you.");
        System.out.println("----------------------------------------------------------------------------\n");
        
        //writing output to the file
        try {
            FileWriter file = new FileWriter("payroll.txt");
            BufferedWriter output = new BufferedWriter(file);
            for(int i = 0; i < employees.size(); i++) {
                output.write("P A Y   S L I P");
                output.write("\nEmployee ID : " + employees.get(i).employee.getEmployeeID());
                output.write("\nFull Name : " + employees.get(i).employee.getEmployeeName());
                output.write("\nEmployee Type : " + employees.get(i).employee.getEmployeeType()); 
                output.write("\nGross Salary : " + employees.get(i).calculateGrossSalary());
                output.write("\nDeductions : " + employees.get(i).calculateDeduction());
                output.write("\nNet Salary : " + employees.get(i).calculateNetSalary());
                output.write("\n=====================================================\n");
            }
            
            output.write("\nTotal Number of Faculty Employees : "+totalNumberOfFacultyEmployees);
            output.write("\nTotal Number of Non Faculty Employees : "+totalNumberOfNonFacultyEmployees);
            output.write("\nTotal Number of ALL Employees : "+totalNumberOfAllEmployees);
            output.write("\n");        

            output.close();
        } 
        catch (IOException ex) {
            System.out.println("Error : "+ ex.getMessage());
        }
    }   
}
