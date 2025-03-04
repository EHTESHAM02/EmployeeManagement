package Hybernate.org.EmployeeManagement;

import jakarta.persistence.*;

@Entity
@Table(name = "company_employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Employee_ID;
	
	@Column
	private String Employee_Name;
	
	@Column
	private int Employee_salary;
	
	@Column
	private String Employee_Department;
	
	@Column
	private int Employee_Age;

	public int getEmployee_ID() {
		return Employee_ID;
	}

	public void setEmployee_ID(int employee_ID) {
		this.Employee_ID = employee_ID;
	}

	public String getEmployee_Name() {
		return Employee_Name;
	}

	public void setEmployee_Name(String employee_Name) {
		this.Employee_Name = employee_Name;
	}

	public int getEmployee_salary() {
		return Employee_salary;
	}

	public void setEmployee_salary(int employee_salary) {
		this.Employee_salary = employee_salary;
	}

	public String getEmployee_Department() {
		return Employee_Department;
	}

	public void setEmployee_Department(String employee_Department) {
		this.Employee_Department = employee_Department;
	}

	public int getEmployee_Age() {
		return Employee_Age;
	}

	public void setEmployee_Age(int employee_Age) {
		this.Employee_Age = employee_Age;
	}


}
