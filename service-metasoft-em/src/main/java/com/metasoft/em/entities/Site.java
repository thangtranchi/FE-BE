package com.metasoft.em.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Site entity
 * @author Tran C Thang
 *
 */
@Entity
@Table(name = "site")
public class Site {
	private long siteId;
	private String name;
	private Address address;
	private float longitude;
	private float lattitude;
	private boolean isExternal;
	private List<Employee> employeeList;
	
	/**
	 * Defaut Constructor
	 */
	public Site() {
		
	}
	/**
	 * @param name
	 * @param address
	 * @param longitude
	 * @param lattitude
	 * @param isExternal
	 */
	public Site(String name, Address address, float longitude, float lattitude,
			boolean isExternal) {
		this.name = name;
		this.address = address;
		this.longitude = longitude;
		this.lattitude = lattitude;
		this.isExternal = isExternal;
	}

	@Column(name = "site_name", nullable = false, length = 100)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "address_id")
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	@Column(name = "longitude")
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	
	@Column(name = "latitude")
	public float getLattitude() {
		return lattitude;
	}
	public void setLattitude(float lattitude) {
		this.lattitude = lattitude;
	}
	
	@Column(name = "is_external")
	public boolean isExternal() {
		return isExternal;
	}
	public void setExternal(boolean isExternal) {
		this.isExternal = isExternal;
	}
	
	@ManyToMany 
	@JoinTable(name = "site_employee", joinColumns = @JoinColumn(name = "site_id"), 
	inverseJoinColumns = @JoinColumn(name = "employee_id"))
	public List<Employee> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "site_id", nullable = false)
	public long getSiteId() {
		return siteId;
	}
	public void setSiteId(long siteId) {
		this.siteId = siteId;
	}
	
}
