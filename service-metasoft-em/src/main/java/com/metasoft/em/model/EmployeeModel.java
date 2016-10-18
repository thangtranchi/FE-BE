package com.metasoft.em.model;

import java.util.Date;
import java.util.List;

/**
 * 
 * @author Tran C Thang
 *
 */
public class EmployeeModel {

	private long employeeId;
	private String firstName;
	private String lastName;
	private AddressModel address;
	private Boolean gender;
	private Date dob;
	private String email;
	private String fax;
	private String mobileNumber;
	private String businessPhone;
	private boolean isExternal;
	private Date entryDate;
	private Date leaveDate;
	private String dobStr;
	private String entryDateStr;
	private String leaveDateStr;
	private List<String> siteList;
	private List<String> departmentList;

	/**
	 * 
	 */
	public EmployeeModel() {
		super();
	}

	/**
	 * @param employeeId
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param gender
	 * @param dob
	 * @param email
	 * @param fax
	 * @param mobileNumber
	 * @param businessPhone
	 * @param isExternal
	 * @param entryDate
	 * @param leaveDate
	 */
	public EmployeeModel(long employeeId, String firstName, String lastName,
			AddressModel address, Boolean gender, Date dob, String email,
			String fax, String mobileNumber, String businessPhone,
			boolean isExternal, Date entryDate, Date leaveDate) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.gender = gender;
		this.dob = dob;
		this.email = email;
		this.fax = fax;
		this.mobileNumber = mobileNumber;
		this.businessPhone = businessPhone;
		this.isExternal = isExternal;
		this.entryDate = entryDate;
		this.leaveDate = leaveDate;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getBusinessPhone() {
		return businessPhone;
	}

	public void setBusinessPhone(String businessPhone) {
		this.businessPhone = businessPhone;
	}

	public boolean isExternal() {
		return isExternal;
	}

	public void setExternal(boolean isExternal) {
		this.isExternal = isExternal;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Date getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}

	public AddressModel getAddress() {
		return address;
	}

	public void setAddress(AddressModel address) {
		this.address = address;
	}

	public String getDobStr() {
		return dobStr;
	}

	public void setDobStr(String dobStr) {
		this.dobStr = dobStr;
	}

	public String getEntryDateStr() {
		return entryDateStr;
	}

	public void setEntryDateStr(String entryDateStr) {
		this.entryDateStr = entryDateStr;
	}

	public String getLeaveDateStr() {
		return leaveDateStr;
	}

	public void setLeaveDateStr(String leaveDateStr) {
		this.leaveDateStr = leaveDateStr;
	}

	public List<String> getSiteList() {
		return siteList;
	}

	public void setSiteList(List<String> siteList) {
		this.siteList = siteList;
	}

	public List<String> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<String> departmentList) {
		this.departmentList = departmentList;
	}

}
