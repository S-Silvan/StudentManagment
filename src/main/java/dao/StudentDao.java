package dao;

import java.util.List;

import tdo.Student;

public interface StudentDao {
	int createStudent(Student student);
	Student readOneStudent(int studentId);
	List<Student> readAllStudent();
	int updateStudent(Student student);
	int deleteStudent(int studentId);
}
