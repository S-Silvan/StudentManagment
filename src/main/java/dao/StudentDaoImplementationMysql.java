package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tdo.Department;
import tdo.Student;
import util.Database;

public class StudentDaoImplementationMysql implements StudentDao{

	public int createStudent(Student student) {
		int result=0;
		Connection conn=Database.getConnection();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("INSERT INTO "
					+ "students(student_name,student_roll_no,student_phone_number,department_id) "
					+ "VALUES (?,?,?,?)");
			ps.setString(1, student.getName());
			ps.setInt(2, student.getRollNo());
			ps.setString(3, student.getPhoneNumber());
			ps.setInt(4, student.getDepartment().getId());
			result=ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(ps!=null) 
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return result;
	}

	public Student readOneStudent(int studentId) {
		Student student=null;
		Connection conn=Database.getConnection();
		PreparedStatement ps=null;
		String query="SELECT * FROM students "
				+ "INNER JOIN departments ON students.department_id=departments.department_id "
				+ "WHERE student_id=?";
		try {
			ps=conn.prepareStatement(query);
			ps.setInt(1, studentId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Department department=new Department();
				department.setDepartmentName(rs.getString("department_name"));
				
				student=new Student();
				student.setName(rs.getString("student_name"));
				student.setRollNo(rs.getInt("student_roll_no"));
				student.setPhoneNumber(rs.getString("student_phone_number"));
				student.setDepartment(department);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(ps!=null)
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return student;
	}

	public List<Student> readAllStudent() {
		List<Student> studentList=new ArrayList<Student>();
		Connection conn=Database.getConnection();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("SELECT * FROM students "
					+ "INNER JOIN departments ON students.department_id=departments.department_id");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Department department=new Department();
				department.setDepartmentName(rs.getString("department_name"));
				
				Student student=new Student();
				student.setId(rs.getInt("student_id"));
				student.setName(rs.getString("student_name"));
				student.setRollNo(rs.getInt("student_roll_no"));
				student.setPhoneNumber(rs.getString("student_phone_number"));
				student.setDepartment(department);
				
				studentList.add(student);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(ps!=null)
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return studentList;
	}

	public int updateStudent(Student student) {
		int result=0;
		Connection conn=Database.getConnection();
		PreparedStatement ps=null;
		try {
			String query="UPDATE students SET "
					+ "student_name='"+student.getName()+"',"
					+ "student_roll_no='"+student.getRollNo()+"',"
					+ "student_phone_number='"+student.getPhoneNumber()+"',"
					+ "department_id='"+student.getDepartment().getId()+"' "
					+ "WHERE student_id="+student.getId();
			ps=conn.prepareStatement(query);
			result=ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(ps!=null)
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return result;
	}

	public int deleteStudent(int studentId) {
		int result=0;
		Connection conn=Database.getConnection();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("DELETE FROM students WHERE student_id=?");
			ps.setInt(1, studentId);
			result=ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(ps!=null)
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return result;
	}
	
}
