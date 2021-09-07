package dao;

import java.util.List;

import tdo.Department;

public interface DepartmentDao {
	int createDepartment(Department department);
	Department readOneDepartment(int departmentId);
	List<Department> readAllDepartment();
	int updateDepartment(Department department);
	int deleteDepartment(int departmentId);
}
