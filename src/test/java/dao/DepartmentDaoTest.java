package dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import tdo.Department;

class DepartmentDaoTest {

	@Test
	void addDepartmentTest() {
		DepartmentDaoImplementationMysql sdi=new DepartmentDaoImplementationMysql();
		Department department=new Department();
		int result=sdi.createDepartment(department);
		assertTrue(result!=0);
	}
	
	@Test
	void readOneDepartmentTest() {
		DepartmentDaoImplementationMysql sdi=new DepartmentDaoImplementationMysql();
		Department department=sdi.readOneDepartment(1);
		assertNotNull(department);
	}
	
	@Test
	void readAllDepartmentTest() {
		DepartmentDaoImplementationMysql sdi=new DepartmentDaoImplementationMysql();
		List<Department> departmentList=sdi.readAllDepartment();
		assertTrue(departmentList.size()>0);
	}
	
	@Test 
	void updateDepartmentTest() {
		DepartmentDaoImplementationMysql sdi=new DepartmentDaoImplementationMysql();
		Department department=new Department();
		department.setId(1);
		department.setDepartmentName("Computer Science and Engineering");
		int result=sdi.updateDepartment(department);
		assertTrue(result!=0);
	}

}
