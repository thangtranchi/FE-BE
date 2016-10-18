package com.metasoft.em.restclient;

import com.metasoft.em.model.DepartmentModel;
import com.metasoft.em.model.EmployeeModel;
import com.metasoft.em.model.SiteModel;

/**
 * For calling the Restful from Client side
 * @author Tran C Thang
 *
 */
public interface RestClientService {

	/**
	 * get employee by ID
	 * @param id
	 * @return
	 */
	 EmployeeModel getEmployeeById(String id);
	 
	 /**
	  * get All Employee
	  * @return
	  */
	 EmployeeModel[] getAllEmployee();
	 
	 /**
	  * save or update employee
	  * @param employee
	  */
	 void saveOrUpdateEmployee(EmployeeModel employee);
	 
	 /**
	  * assign an employee to a site
	  * @param employeeId
	  * @param siteId
	  * @return
	  */
	 Boolean assignToSite(String employeeId, String siteId);
	 
	 /**
	  * assign an employee to a department
	  * @param employeeId
	  * @param departmentId
	  * @return
	  */
	 Boolean assignToDepartmentRest(String employeeId, String departmentId);
	 
	 /**
	  * delete an employee
	  * @param id
	  */
	 void deleteEmployee(String id);
	 
	 /**
	  * get all Sites
	  * @return
	  */
	 SiteModel[] getAllSites();
	 
	 /**
	  * save a Site
	  * @param site
	  * @return
	  */
	 Boolean saveSite(SiteModel site);
	 
	 /**
	  * check Site name is existed or not
	  * @param site
	  * @return
	  */
	 Boolean checkSite(SiteModel site);
	 
	 /**
	  * get a Site by Id
	  * @param id
	  * @return
	  */
	 SiteModel getSiteById(String id);
	 
	 /**
	  * delete a site
	  * @param id
	  */
	 void deleteSite(String id);
	 
	 /**
	  * get all the Department
	  * @return
	  */
	 DepartmentModel[] getAllDepartments();
	 
	 /**
	  * save a Department
	  * @param department
	  */
	 void saveDepartment(DepartmentModel department);
	 
	 /**
	  * check Department name is existed or not 
	  * @param department
	  * @return
	  */
	 Boolean checkDepartment(DepartmentModel department);
	 
	 /**
	  * get Department by Id
	  * @param id
	  * @return
	  */
	 DepartmentModel getDepartmentById(String id);
	 
	 /**
	  * delete Department 
	  * @param id
	  */
	 void deleteDepartment(String id);
}
