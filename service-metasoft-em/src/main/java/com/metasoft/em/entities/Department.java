package com.metasoft.em.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Department entity
 * @author Tran C Thang
 *
 */
@Entity
@Table(name = "department")
public class Department {

	private long departmentId;
	private String name;
	private String manager;
	private String additionalEmployee;
	private boolean isRoot;
	private String parent;
	private List<Employee> employeeList;

	/**
	 * 
	 */
	public Department() {
		super();
	}

	/**
	 * @param name
	 * @param manager
	 * @param additionalEmployee
	 * @param isRoot
	 * @param parent
	 */
	public Department(String name, String manager, String additionalEmployee,
			boolean isRoot, String parent) {
		super();
		this.name = name;
		this.manager = manager;
		this.additionalEmployee = additionalEmployee;
		this.isRoot = isRoot;
		this.parent = parent;
	}

	@Column(name = "department_name", nullable = false, length = 100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "manager_name")
	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	@Column(name = "additional_employeea", length = 100)
	public String getAdditionalEmployee() {
		return additionalEmployee;
	}

	public void setAdditionalEmployee(String additionalEmployee) {
		this.additionalEmployee = additionalEmployee;
	}

	@Column(name = "is_root")
	public boolean isRoot() {
		return isRoot;
	}

	public void setRoot(boolean isRoot) {
		this.isRoot = isRoot;
	}

	@Column(name = "parent_name", length = 100)
	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "department_employee", joinColumns = @JoinColumn(name = "department_id"), 
				inverseJoinColumns = @JoinColumn(name = "employee_id"))
	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "department_id", nullable = false)
	public long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

}
