package com.metasoft.em.model;
/**
 * Address model for RESTful
 * 
 * @author Tran C Thang
 *
 */
public class AddressModel {
	
	private long addressId;
	private String houseNumber;
	private String street;
	private String postCode;
	private String city;
	
	/**
	 * 
	 */
	public AddressModel() {
		super();
	}
	/**
	 * @param addressId
	 * @param houseNumber
	 * @param street
	 * @param postCode
	 * @param city
	 */
	public AddressModel(long addressId, String houseNumber, String street,
			String postCode, String city) {
		super();
		this.addressId = addressId;
		this.houseNumber = houseNumber;
		this.street = street;
		this.postCode = postCode;
		this.city = city;
	}
	public long getAddressId() {
		return addressId;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
