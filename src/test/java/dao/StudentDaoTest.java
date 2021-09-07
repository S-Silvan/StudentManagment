package dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import tdo.Department;
import tdo.Student;

class StudentDaoTest {

	@Test
	void addStudentTest() {
		StudentDaoImplementationMysql sdi=new StudentDaoImplementationMysql();
		Student student=new Student();
		Department department=new Department();
		department.setId(1);
		student.setName("Test");
		student.setPhoneNumber("328023832");
		student.setRollNo(2342);
		student.setDepartment(department);
		int result=sdi.createStudent(student);
		assertTrue(result!=0);
	}
	
	@Test
	void readOneStudentTest() {
		StudentDaoImplementationMysql sdi=new StudentDaoImplementationMysql();
		Student student=sdi.readOneStudent(1);
		assertNotNull(student);
	}
	
	@Test
	void readAllStudentTest() {
		StudentDaoImplementationMysql sdi=new StudentDaoImplementationMysql();
		List<Student> studentList=sdi.readAllStudent();
		assertTrue(studentList.size()>0);
	}
	
	@Test 
	void updateStudentTest() {
		StudentDaoImplementationMysql sdi=new StudentDaoImplementationMysql();
		Department department=new Department();
		department.setId(1);
		Student student=new Student();
		student.setId(1);
		student.setName("Silvan");
		student.setPhoneNumber("123467890");
		student.setRollNo(4031);
		student.setDepartment(department);
		int result=sdi.updateStudent(student);
		assertTrue(result!=0);
	}
}
