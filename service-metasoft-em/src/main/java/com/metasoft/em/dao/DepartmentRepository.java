package com.metasoft.em.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metasoft.em.entities.Department;
/**
 * 
 * @author Tran C Thang
 *
 */
public interface DepartmentRepository extends JpaRepository<Department, Long> {

	/**
	 * find Department by name
	 * @param name
	 * @return
	 */
	Department findByName(String name);
	
	/**
	 * find Department by keyword
	 * @param name
	 * @return
	 */
	List<Department> findByNameContaining(String name);
	
	/**
	 * find Department by manager name
	 * @param manager
	 * @return
	 */
	List<Department> findByManager(String manager);
}
