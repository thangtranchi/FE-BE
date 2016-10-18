package com.metasoft.em.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.metasoft.em.service.DepartmentService;

public class DepartmentServiceUnitTest extends AbstractUnitTestSetup {

	@Autowired
	private DepartmentService serviceDepartment;

	@Test
	public void testGetAll() {
		assertEquals(8, serviceDepartment.getAllDepartment().size());
	}
	
	@Test
	public void testGetDepartmentByName() {
		assertEquals(23, serviceDepartment.getDepartmentByName("Admin").getDepartmentId());
	}

	@Test
	public void testGetDepartmentByManager() {
		assertEquals(24, serviceDepartment.getDepartmentByManager("MarkZuckerberg").get(0).getDepartmentId());
	}
	
	@Test
	public void testGetDepartmentByKeyword() {
		assertEquals(19, serviceDepartment.getDepartmentsByKeyword("Recruitm").get(0).getDepartmentId());
	}
}
