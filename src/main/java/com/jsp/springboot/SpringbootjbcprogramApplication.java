package com.jsp.springboot;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;


import com.jsp.springjdbc.dao.employee;
import com.jsp.springjdbc.dao.employeedao;

@SpringBootApplication
@ComponentScan(basePackages = "com.jsp.springjdbc.dao")
public class SpringbootjbcprogramApplication 
{

	public static void main(String[] args) 
	{
		ConfigurableApplicationContext context=SpringApplication.run(SpringbootjbcprogramApplication.class, args);
		

        // Get the employeedao bean
        employeedao employeeDao = context.getBean(employeedao.class);

        System.out.println("Choose an option :");
        System.out.println("1. Add an Employee      2. Delete an Employee   3.Retrive an Employee  4.Update an Employee");
     
        
        Scanner scan=new Scanner(System.in);

        int option = scan.nextInt();
        scan.nextLine(); // Consume the newline character after reading the integer

        switch (option) {
            case 1:
                // Add an employee
                System.out.print("Enter Employee ID: ");
                int eid = scan.nextInt();
                scan.nextLine(); // Move to the next line after reading the integer

                System.out.print("Enter Employee Name: ");
                String ename = scan.nextLine();

                System.out.print("Enter Employee Salary: ");
                int esalary = scan.nextInt();
                scan.nextLine();

                System.out.print("Enter Employee Department Number: ");
                int edeptno = scan.nextInt();
                scan.nextLine();

                System.out.print("Enter Employee Email: ");
                String email = scan.nextLine();

                System.out.print("Enter Employee Password: ");
                String password = scan.nextLine();

                System.out.print("Enter Employee Mobile Number: ");
                String mobileNo = scan.nextLine();

                // Create an employee object and set its attributes
                employee emp = new employee();
                emp.setEID(eid);
                emp.setENAME(ename);
                emp.setESALARY(esalary);
                emp.setEDEPTNO(edeptno);
                emp.setEMAIL(email);
                emp.setPASSWORD(password);
                emp.setEMOBILENO(mobileNo);

                // Call the addemployee method to insert the employee
                int rowsAffected = employeeDao.addemployee(emp);
                System.out.println("no of records inserted: " + rowsAffected);

                if (rowsAffected > 0) {
                    System.out.println("Employee record inserted successfully!");
                } else {
                    System.out.println("Failed to insert employee record.");
                }
                break;

            case 2:
            	 // Delete an employee
                System.out.print("Enter Employee ID to delete: ");
                int employeeIdToDelete = scan.nextInt();
                scan.nextLine(); // Consume the newline character after reading the integer

                int rowsAffected1 = employeeDao.delemployee(employeeIdToDelete);
                if (rowsAffected1 > 0) {
                    System.out.println("Employee record deleted successfully!");
                } else {
                    System.out.println("Failed to delete employee record.");
                }
                break;
                
            case 3:
            	
            	
            	 // Retrieve an employee
                System.out.print("Enter Employee ID to retrieve: ");
                int employeeIdToRetrieve = scan.nextInt();
                scan.nextLine(); // Consume the newline character after reading the integer

                employee retrievedEmployee = employeeDao.getEmployeeById(employeeIdToRetrieve);
                if (retrievedEmployee != null) 
                {
                    System.out.println("Retrieved Employee: " + retrievedEmployee);
                } else {
                    System.out.println("Employee not found.");
                }
                break;
            
                
            case 4:
            	
                // Update an employee
                System.out.print("Enter Employee ID to update: ");
                int employeeIdToUpdate = scan.nextInt();
                scan.nextLine(); // Consume the newline character after reading the integer

                employee retrievedEmployee1 = employeeDao.getEmployeeById(employeeIdToUpdate);
                if (retrievedEmployee1 != null) {
                    System.out.print("Enter updated Employee Name: ");
                    String updatedName = scan.nextLine();

                    System.out.print("Enter updated Employee Salary: ");
                    int updatedSalary = scan.nextInt();
                    scan.nextLine();

                    // Update the employee object with the new values
                    retrievedEmployee1.setENAME(updatedName);
                    retrievedEmployee1.setESALARY(updatedSalary);

                    // Call the updateEmployee method to update the employee
                    int rowsAffected2 = employeeDao.updateEmployee(retrievedEmployee1);
                    if (rowsAffected2 > 0) 
                    {
                        System.out.println("Employee record updated successfully!");
                    } else {
                        System.out.println("Failed to update employee record.");
                    }
                } else {
                    System.out.println("Employee not found.");
                }
                break;

            default:
                System.out.println("Invalid option selected.");
        }

        // Close the Scanner
        scan.close();
    }

}
