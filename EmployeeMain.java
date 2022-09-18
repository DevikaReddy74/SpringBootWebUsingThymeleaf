package com.rays;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.rays.dao.EmployeeDao;
import com.rays.dao.EmployeeDaoImpl;
import com.rays.dao.pojo.Employee;

public class EmployeeMain {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		EmployeeDao employeeDao = new EmployeeDaoImpl();
		do {
			System.out.println("1.Add Employee\n2.View All Employee");
			System.out.println("3.View Employee By Id\n4.Update Employee");
			System.out.println("5.Remove Employee");
			int key = sc.nextInt();
			switch (key) {
			case 1:
				int insert = employeeDao.insertEmployee(userInput());
				if (insert > 0) {
					System.out.println("Employee Added Successfully..");
				} else {
					System.out.println("Employee Not Added!!!");
				}
				System.out.println("");
				break;
			case 2:
				List<Employee> empList = employeeDao.getAllEmployee();
				for (Employee e : empList) {
					System.out.println(e);
				}
				System.out.println("");
				break;
			case 3:
				System.out.print("Enter Employee ID: ");
				Employee e = employeeDao.getEmployeeById(sc.nextInt());
				if (e != null)
					System.out.println(e);
				else {
					System.out.println("Employee ID not found... ");
				}
				System.out.println("");
				break;
			case 4:
				int update = employeeDao.updateEmployee(userInput());
				if (update > 0) {
					System.out.println("Employee updated Successfully..");
				} else {
					System.out.println("Employee Not updated!!!");
				}
				System.out.println("");
				break;
			case 5:
				System.out.print("Enter Employee ID: ");
				int id=sc.nextInt();
				Employee e2 = employeeDao.getEmployeeById(id);
				if (e2 != null){
					int delete = employeeDao.deleteEmployee(id);
					if (delete > 0) {
						System.out.println("Employee deleted Successfully..");
					} else {
						System.out.println("Employee Not Deleted!!!");
					}
				}
				else {
					System.out.println("Employee ID not found... ");
				}
				System.out.println("");
				break;
			default:
				break;
			}
			System.out.println("Do you want to continue 1.Yes   2.No");
		} while (sc.nextInt() == 1);
		System.out.println("Thanks for Using this application...Come Again...");
	}

	static Employee userInput() {
		Employee emp = new Employee();
		try {
			System.out.print("Enter Id: ");
			emp.setEmpId(sc.nextInt());
			sc.nextLine();
			System.out.print("Enter Name: ");
			emp.setEmpName(sc.nextLine());
			System.out.print("Enter Age: ");
			emp.setEmpAge(sc.nextInt());
			sc.nextLine();
			System.out.print("Enter Join Date (yyyy/MM/dd): ");
			String jDate = sc.nextLine();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			emp.setEmpJoinDate(sdf.parse(jDate));
			System.out.print("Enter Salary: ");
			emp.setEmpSalary(sc.nextDouble());
		} catch (Exception e) {
			System.out.println("Error in Employee Input..." + e);
		}
		return emp;
	}

}
