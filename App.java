package Hybernate.org.EmployeeManagement;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	private static Scanner sc = new Scanner(System.in);
	private static Session session = null;
	private static Transaction transaction = null;
    public static void main( String[] args )
    {
    	while (true) {
    		System.out.println("\n--- Employee Management System---");
    		System.out.println("Press 1: create Employee");
    		System.out.println("Press 2: Read Employee");
    		System.out.println("Press 3: Delete Employee");
    		System.out.println("Press 4: Update Employee");
    		System.out.println("Pres any other number to Exit");
    		
    		System.out.println("Enter your choice: ");
    		int choice = sc.nextInt();
    		
    		switch(choice) {
    		case 1 : createEmployee();
    		break;
    		case 2 : ReadEmployee();
    		break;
    		case 3 : deleteEmployee();
    		break;
       		case 4 : UpdateEmployee();
       		break;
    		
    		default : {
    			System.out.println("Exiting... Thank You!");
    			return;
    		}
    		}
    	}
      
    }
    
    private static void createEmployee() {
    	System.out.println("\n--- Create Employee---");
    	session = sessionFactory.openSession();
    	transaction = session.beginTransaction();
    	Employee employee = new Employee();
    	sc.nextLine();
    	System.out.println("Enter Employee Name: ");
    	String Employee_Name = sc.nextLine();
    	employee.setEmployee_Name(Employee_Name);
    	
    	System.out.println("Enter Employee Salary: ");
    	int Employee_salary = sc.nextInt();
    	employee.setEmployee_salary(Employee_salary);
    	sc.nextLine();
    	
    	System.out.println("Enter Employee Department: ");
    	String Employee_Department = sc.nextLine();
    	employee.setEmployee_Department(Employee_Department);
    
    	
    	System.out.println("Enter Employee Age: ");
    	int Employee_Age = sc.nextInt();
    	employee.setEmployee_Age(Employee_Age);	
    	
        System.out.println("Employee created successfully with ID: " + employee.getEmployee_ID());
        
        session.persist(employee);
        transaction.commit();
        session.close();
      }
    
    private static void ReadEmployee() {
    	System.out.println("\n--- Read Employee ---");
    	System.out.println("Enter Employee ID:");
    	int Employee_ID = sc.nextInt();
    	
    	Session session = sessionFactory.openSession();
    	Employee employee = session.get(Employee.class, Employee_ID);
    	session.close();
    	 sc.nextLine();
    	
    	if (employee != null) {
    		System.out.println("Employee Details:");
    		System.out.println("Employee_ID: " + employee.getEmployee_ID());
    		System.out.println("Employee_Name: " + employee.getEmployee_Name());
    		System.out.println("Employee_salary: " + employee.getEmployee_salary());
    		System.out.println("Employee_Department: " + employee.getEmployee_Department());
    		System.out.println("Employee_Age: " + employee.getEmployee_Age());
    	} else {
    		System.out.println("Employee with Employee_ID " + Employee_ID + " not found");
    	}
    }
    
    private static void deleteEmployee() {
    	System.out.println("\n--- Delete Employee ---");
    	System.out.println("Enter Employee ID:");
    	int Employee_ID = sc.nextInt();
    	
    	
    	Session session  = sessionFactory.openSession();
    	Transaction transaction = session.beginTransaction();
    	Employee employee = session.get(Employee.class, Employee_ID);
    	 sc.nextLine();
    	 
    	if (employee != null) {
    		session.remove(employee);
    		transaction.commit();
    		System.out.println("Employee with ID " + Employee_ID + " deleted Successfully.");
    	} else {
    		System.out.println("Employee with Employee_ID " + Employee_ID + " not found");
    	}
    }
    
    private static void UpdateEmployee() {
    	System.out.println("\n--- Update Employee---");
    	System.out.println("Enter Employee ID:");
        int Employee_ID = sc.nextInt();
       
    	
    	Session session  = sessionFactory.openSession();
    	Transaction transaction = session.beginTransaction();
    	Employee employee = session.get(Employee.class, Employee_ID);
    	 sc.nextLine();
    	 
    	if (employee != null) {
    		System.out.println("Enter New Employee Name: ");
    		String Employee_Name = sc.nextLine();
    		

        	System.out.println("Enter Employee Salary: ");
        	int Employee_salary = sc.nextInt();
        	sc.nextLine();
        	
        	System.out.println("Enter Employee Department: ");
        	String Employee_Department = sc.next();
        	sc.nextLine();
        	
        	System.out.println("Enter Employee Age: ");
        	int Employee_Age = sc.nextInt();
        	sc.nextLine();
        	
        	employee.setEmployee_Name(Employee_Name);
        	employee.setEmployee_salary(Employee_salary);
        	employee.setEmployee_Department(Employee_Department);
        	employee.setEmployee_Age(Employee_Age);
        	
        	session.update(employee);
        	transaction.commit();
        	session.close();
        	
        	System.out.println("Employee With ID " + Employee_ID + " updated Successfully");     	
    	} else {
    		System.out.println("Employee with Employee_ID " + Employee_ID + " not found");
    	}
    
    }
}


