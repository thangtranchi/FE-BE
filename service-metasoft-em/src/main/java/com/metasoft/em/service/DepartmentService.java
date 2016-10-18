package com.metasoft.em.service;

import java.util.List;

import com.metasoft.em.model.DepartmentModel;

/**
 * Department Service Interface
 * 
 * @author Tran C Thang
 *
 */
public interface DepartmentService {

	/**
	 * check the Site name is existed or not
	 * 
	 * @param id
	 * @return
	 */
	Boolean checkDepartmentNameIsExisted(DepartmentModel model);

	/**
	 * get Department by Id
	 * 
	 * @param id
	 * @return
	 */
	DepartmentModel getDepartmentById(long id);

	/**
	 * get All Departments
	 * 
	 * @return
	 */
	List<DepartmentModel> getAllDepartment();

	/**
	 * get department by PK
	 * 
	 * @param name
	 * @return DepartmentModel
	 */
	DepartmentModel getDepartmentByName(String name);

	/**
	 * get department list by a keyword
	 * 
	 * @param keyword
	 * @return List<Department>
	 */
	List<DepartmentModel> getDepartmentsByKeyword(String keyword);

	/**
	 * get list department by manager number
	 * 
	 * @param managerNo
	 * @return Department
	 */
	List<DepartmentModel> getDepartmentByManager(String manager);

	/**
	 * create new or update a department
	 * 
	 * @param department
	 * @return boolean
	 */
	boolean saveDepartment(DepartmentModel department);

	/**
	 * delete a department
	 * 
	 * @param departmentName
	 * @return boolean
	 */
	boolean deleteDepartment(Long departmentId);
}
