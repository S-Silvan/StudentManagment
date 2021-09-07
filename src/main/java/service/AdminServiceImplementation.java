package service;

import java.util.List;

import dao.DepartmentDao;
import dao.DepartmentDaoImplementationMysql;
import dao.StudentDao;
import dao.StudentDaoImplementationMysql;
import tdo.Department;
import tdo.Student;

public class AdminServiceImplementation implements AdminService {
	private StudentDao studentDao=new StudentDaoImplementationMysql();
	private DepartmentDao departmentDao=new DepartmentDaoImplementationMysql();
	
	public int addStudent(Student student) {
		int result=studentDao.createStudent(student);
		return result;
	}

	public Student getOneStudent(int studentId) {
		Student student=studentDao.readOneStudent(studentId);
		return student;
	}

	public List<Student> getAllStudent() {
		List<Student> studentList=studentDao.readAllStudent();
		return studentList;
	}

	public int updateStudent(Student student) {
		int result=studentDao.updateStudent(student);
		return result;
	}

	public int removeStudent(int studentId) {
		int result=studentDao.deleteStudent(studentId);
		return result;
	}

	public int addDepartment(Department department) {
		int result=departmentDao.createDepartment(department);
		return result;
	}

	public Department getOneDepartment(int departmentId) {
		Department department=departmentDao.readOneDepartment(departmentId);
		return department;
	}

	public List<Department> getAllDepartment() {
		List<Department> departmentList=departmentDao.readAllDepartment();
		return departmentList;
	}

	public int updateDepartment(Department department) {
		int result=departmentDao.updateDepartment(department);
		return result;
	}

	public int removeDepartment(int departmentId) {
		int result=departmentDao.deleteDepartment(departmentId);
		return result;
	}

}
