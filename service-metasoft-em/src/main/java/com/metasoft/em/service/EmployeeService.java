package com.metasoft.em.service;

import java.util.Date;
import java.util.List;

import com.metasoft.em.model.EmployeeModel;

/**
 * Employee Service Interface
 * 
 * @author Tran C Thang
 *
 */
public interface EmployeeService {

	/**
	 * get employee by Id
	 * @param employeeId
	 * @return EmployeeModel
	 */
	EmployeeModel getEmployeeById(String employeeId);
	
	/**
	 * create new or update Employee
	 * 
	 * @param model
	 * @return boolean
	 */
	boolean saveEmployee(EmployeeModel model);

	/**
	 * delete an employee
	 * 
	 * @param employeeNo
	 * @return boolean
	 */
	boolean deleteEmployee(Long employeeNo);

	/**
	 * assign an employee to a department
	 * 
	 * @param employeeNo
	 * @param departmentName
	 * @return boolean
	 */
	boolean assignToDepartment(Long employeeNo, Long departmentId);

	/**
	 * assign an employee to a Site
	 * 
	 * @param employeeNo
	 * @param siteName
	 * @return long
	 */
	boolean assignToSite(Long employeeNo, Long siteId);

	/**
	 * count all employees
	 * 
	 * @return long
	 */
	long countAllEmployees();

	/**
	 * count all employed employee
	 * 
	 * @return long
	 */
	long countEmployeeEmployed();

	/**
	 * count left employee in give duration
	 * 
	 * @param startDate
	 * @param endDate
	 * @return long
	 */
	long countLeftEmployeeInDuration(Date startDate, Date endDate);

	/**
	 * count Employee by department
	 * 
	 * @param departmentName
	 * @return long
	 */
	long countEmployeeByDepartment(Long departmentId);

	/**
	 * count employee by site
	 * 
	 * @param siteName
	 * @return long
	 */
	long countEmployeeBySite(Long siteId);

	/**
	 * calculate the rate between Male and Female
	 * 
	 * @return
	 */
	String rateMaleAndFemale();
	
	/**
	 * get all employee
	 * @return List<EmployeeModel>
	 */
	List<EmployeeModel> getAll();
}
