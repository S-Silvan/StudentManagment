package service;

import java.util.List;

import tdo.Department;
import tdo.Student;

public interface AdminService {
	int addStudent(Student student);
	Student getOneStudent(int studentId);
	List<Student> getAllStudent();
	int updateStudent(Student student);
	int removeStudent(int studentId);
	
	int addDepartment(Department department);
	Department getOneDepartment(int departmentId);
	List<Department> getAllDepartment();
	int updateDepartment(Department department);
	int removeDepartment(int departmentId);
}
