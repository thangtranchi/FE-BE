package com.metasoft.em.model;

public class DepartmentModel {
	
	private long departmentId;
	private String name;
	private String manager;
	private String additionalEmployee;
	private boolean isRoot;
	private String parent;
	
	/**
	 * 
	 */
	public DepartmentModel() {
		super();
	}
	
	/**
	 * @param departmentId
	 * @param name
	 * @param manager
	 * @param additionalEmployee
	 * @param isRoot
	 * @param parent
	 */
	public DepartmentModel(long departmentId, String name, String manager,
			String additionalEmployee, boolean isRoot, String parent) {
		super();
		this.departmentId = departmentId;
		this.name = name;
		this.manager = manager;
		this.additionalEmployee = additionalEmployee;
		this.isRoot = isRoot;
		this.parent = parent;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getAdditionalEmployee() {
		return additionalEmployee;
	}
	public void setAdditionalEmployee(String additionalEmployee) {
		this.additionalEmployee = additionalEmployee;
	}
	public boolean isRoot() {
		return isRoot;
	}
	public void setRoot(boolean isRoot) {
		this.isRoot = isRoot;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}
}
