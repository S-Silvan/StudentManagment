package controller;

import java.io.IOException;
import java.util.Scanner;

public class AppStarter {

	public static void main(String[] args) throws IOException {
		Scanner in=new Scanner(System.in);
		AdminController ac=new AdminController();
		
		int option=0;
		System.out.println("0.Add Student");
		System.out.println("1.Read one Student");
		System.out.println("2.Read all Student");
		System.out.println("3.Update Student");
		System.out.println("4.Delete Student");
		System.out.println("5.Add department");
		System.out.println("6.Read one department");
		System.out.println("7.Read all department");
		System.out.println("8.Update department");
		System.out.println("9.Delete department");
		System.out.println("Enter your option");
		option=in.nextInt();
		switch(option) {
		case 0:
			ac.addStudent();
			break;
		case 1:
			ac.displayOneStudent();
			break;
		case 2:
			ac.displayAllStudent();
			break;
		case 3:
			ac.updateStudent();
			break;
		case 4:
			ac.deleteStudent();
			break;
		case 5:
			ac.addDepartment();
			break;
		case 6:
			ac.displayOneDepartment();
			break;
		case 7:
			ac.displayAllDepartment();
			break;
		case 8:
			ac.updateDepartment();
			break;
		case 9:
			ac.deleteDepartment();
		}
	}

}
