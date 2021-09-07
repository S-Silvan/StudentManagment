package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tdo.Department;
import util.Database;

public class DepartmentDaoImplementationMysql implements DepartmentDao {

	public int createDepartment(Department department) {
		int result=0;
		Connection conn=Database.getConnection();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("INSERT INTO "
					+ "departments(department_name) "
					+ "VALUES(?)");
			ps.setString(1, department.getDepartmentName());
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

	public Department readOneDepartment(int departmentId) {
		Department department=null;
		Connection conn=Database.getConnection();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("SELECT * FROM departments WHERE department_id=?");
			ps.setInt(1,departmentId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				department=new Department();
				department.setId(departmentId);
				department.setDepartmentName(rs.getString("department_name"));
			}
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
		return department;
	}

	public List<Department> readAllDepartment() {
		List<Department> departmentList=new ArrayList<Department>();
		Connection conn=Database.getConnection();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("SELECT * FROM departments");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Department department=new Department();
				department.setId(rs.getInt("department_id"));
				department.setDepartmentName(rs.getString("department_name"));
				departmentList.add(department);
			}
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
		return departmentList;
	}

	public int updateDepartment(Department department) {
		int result=0;
		Connection conn=Database.getConnection();
		PreparedStatement ps=null;
		String query="UPDATE departments SET "
				+ "department_name='"+department.getDepartmentName()+"' "
				+ "WHERE department_id="+department.getId();
		try {
			ps=conn.prepareStatement(query);
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

	public int deleteDepartment(int departmentId) {
		int result=0;
		Connection conn=Database.getConnection();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("DELETE FROM departments WHERE department_id=?");
			ps.setInt(1, departmentId);
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

}
