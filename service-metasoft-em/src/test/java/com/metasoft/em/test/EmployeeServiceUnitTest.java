package com.metasoft.em.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.metasoft.em.model.EmployeeModel;
import com.metasoft.em.service.EmployeeService;

public class EmployeeServiceUnitTest extends AbstractUnitTestSetup {

	@Autowired
	private EmployeeService serviceEmployee;

	@Test
	public void testGetAll() {
		List<EmployeeModel> lists = serviceEmployee.getAll();
		assertEquals(6, lists.size());
	}
	
	@Test
	public void testDeleteEmployee() {
		serviceEmployee.deleteEmployee((long)5);
		List<EmployeeModel> lists = serviceEmployee.getAll();
		assertEquals(5, lists.size());
	}
	
	@Test
	public void testAssignToDepartment() {
		serviceEmployee.assignToDepartment((long)5,(long) 23);
		EmployeeModel model = serviceEmployee.getEmployeeById("5");
		List<String> siteList =  model.getDepartmentList();
		assertEquals(2, siteList.size());
	}
	
	@Test
	public void testAssignToSite() {
		serviceEmployee.assignToSite((long)5,(long) 5);
		EmployeeModel model = serviceEmployee.getEmployeeById("5");
		List<String> siteList =  model.getSiteList();
		assertEquals(2, siteList.size());
	}
	
	@Test
	public void testCountAvailableEmployee() {
		assertEquals(5, serviceEmployee.countEmployeeEmployed());
	}
 
}
