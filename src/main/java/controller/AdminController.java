package controller;

import java.util.List;
import java.util.Scanner;

import exception.InvalidDepartmentException;
import exception.InvalidStudentException;
import service.AdminService;
import service.AdminServiceImplementation;
import tdo.Department;
import tdo.Student;
import util.Logger;

public class AdminController {
	private AdminService adminService=new AdminServiceImplementation();
	org.apache.log4j.Logger log=Logger.getLog();
	
	public void addStudent() {
		log.info("Adding student");
		Scanner in=new Scanner(System.in);
		System.out.println("--------------------");
		System.out.println("Student Registration");
		System.out.println("--------------------");
		
		this.displayAllDepartment();
		System.out.println("Enter department ID");
		Department department=new Department();
		department.setId(in.nextInt());
		in.nextLine();
		
		Student student=new Student();
		System.out.println("Enter student name");
		student.setName(in.nextLine());
		System.out.println("Enter student phone number");
		student.setPhoneNumber(in.nextLine());
		System.out.println("Enter student roll no");
		student.setRollNo(in.nextInt());
		student.setDepartment(department);
		
		int result=adminService.addStudent(student);
		in.close();
		if(result!=0)
			System.out.println("Student registered successfully");
		else
			throw new InvalidStudentException("Student registration failed exception");
	}
	
	public void displayOneStudent() {
		log.info("Displaying student");
		Scanner in=new Scanner(System.in);
		
		System.out.println("----------------------");
		System.out.println("Displaying one student");
		System.out.println("----------------------");
		
		System.out.println("Enter student id");
		Student student=adminService.getOneStudent(in.nextInt());
		in.close();
		if(student!=null) {
			System.out.println("Student Name:"+student.getName());
			System.out.println("Student phone number:"+student.getPhoneNumber());
			System.out.println("Student department:"+student.getDepartment().getDepartmentName());
		}else {
			throw new InvalidStudentException("Student not found");
		}
	}
	
	public void displayAllStudent() {
		log.info("Displaying student");
		System.out.println("----------------------");
		System.out.println("Displaying all student");
		System.out.println("----------------------");
		
		List<Student> studentList=adminService.getAllStudent();
		if(studentList.size()>0)
			for(Student student:studentList) {
				System.out.println("Student ID:"+student.getId());
				System.out.println("Student Name:"+student.getName());
				System.out.println("Student phone number:"+student.getPhoneNumber());
				System.out.println("Student department:"+student.getDepartment().getDepartmentName());
				System.out.println("----------------------");
			}
		else
			System.out.println("No records found");
	}
	
	public void updateStudent() {
		log.info("Updating student");
		Scanner in=new Scanner(System.in);
		
		System.out.println("----------------");
		System.out.println("Updating student");
		System.out.println("----------------");
		
		Department department=new Department();
		this.displayAllDepartment();
		this.displayAllStudent();
		System.out.println("Enter department ID");
		department.setId(in.nextInt());
		
		Student student=new Student();
		System.out.println("Enter student ID");
		student.setId(in.nextInt());
		in.nextLine();
		System.out.println("Enter student name");
		student.setName(in.nextLine());
		System.out.println("Enter student phone number");
		student.setPhoneNumber(in.nextLine());
		System.out.println("Enter student roll no");
		student.setRollNo(in.nextInt());
		student.setDepartment(department);
		
		in.close();
		int result=adminService.updateStudent(student);
		if(result!=0)
			System.out.println("Student updation successfully");
		else
			throw new InvalidStudentException("Student updation failed exception");
	}
	
	public void deleteStudent() {
		log.info("Deleting student");
		Scanner in=new Scanner(System.in);
		
		System.out.println("-----------------");
		System.out.println("Deleteing student");
		System.out.println("-----------------");
		
		this.displayAllStudent();
		System.out.println("Enter student id");
		int result=adminService.removeStudent(in.nextInt());
		in.close();
		if(result!=0)
			System.out.println("Student deleted successfully");
		else
			throw new InvalidStudentException("Student deletion failed exception");
	}
	
	public void addDepartment() {
		log.info("Adding department");
		Scanner in=new Scanner(System.in);
		System.out.println("-----------------");
		System.out.println("Adding department");
		System.out.println("-----------------");
		
		Department department=new Department();
		System.out.println("Enter department name");
		department.setDepartmentName(in.nextLine());
		in.close();
		int result=adminService.addDepartment(department);
		if(result!=0)
			System.out.println("Department added successfully");
		else
			throw new InvalidDepartmentException("Invalid student details");
	}
	
	public void displayOneDepartment() {
		log.info("Display department");
		Scanner in=new Scanner(System.in);
		System.out.println("----------------------");
		System.out.println("Display one department");
		System.out.println("----------------------");
		
		System.out.println("Enter department ID");
		Department department=adminService.getOneDepartment(in.nextInt());
		in.close();
		if(department!=null)
			System.out.println(department.getDepartmentName());
		else
			throw new InvalidDepartmentException("Invalid department id");
	}
	
	public void displayAllDepartment() {
		log.info("Displaying department");
		System.out.println("----------------------");
		System.out.println("Display all department");
		System.out.println("----------------------");
		
		List<Department> departmentList=adminService.getAllDepartment();
		
		if(departmentList.size()>0) {
			for(Department department:departmentList)
				System.out.println(department.getId()+"."+department.getDepartmentName());
		}else {
			System.out.println("No records found");
		}
	}
	
	public void updateDepartment() {
		log.info("Updating department");
		Scanner in=new Scanner(System.in);
		System.out.println("-------------------");
		System.out.println("Updating department");
		System.out.println("-------------------");
		
		this.displayAllDepartment();
		Department department=new Department();
		System.out.println("Enter department ID");
		department.setId(in.nextInt());
		in.nextLine();
		System.out.println("Enter department name");
		department.setDepartmentName(in.nextLine());
		in.close();
		int result=adminService.updateDepartment(department);
		if(result!=0)
			System.out.println("Department updation successful");
		else
			throw new InvalidDepartmentException("Department updation failed");
	}
	
	public void deleteDepartment() {
		log.info("Deleting department");
		Scanner in=new Scanner(System.in);
		System.out.println("-------------------");
		System.out.println("Deleting department");
		System.out.println("-------------------");
		
		this.displayAllDepartment();
		System.out.println("Enter department id");
		int result=adminService.removeDepartment(in.nextInt());
		in.close();
		if(result!=0)
			System.out.println("Department deletion successful");
		else
			throw new InvalidDepartmentException("Department deletion failed");
	}
}
