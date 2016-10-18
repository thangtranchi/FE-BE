package com.metasoft.em.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Address Entity
 * @author Tran C Thang
 *
 */
@Entity
@Table(name = "address")
public class Address {

	private long addressId;
	private String houseNumber;
	private String street;
	private String postCode;
	private String city;
	
	/**
	 * 
	 */
	public Address() {
		super();
	}
	/**
	 * @param addressId
	 * @param houseNumber
	 * @param street
	 * @param postCode
	 * @param city
	 */
	public Address(String houseNumber, String street,
			String postCode, String city) {
		super();
		this.houseNumber = houseNumber;
		this.street = street;
		this.postCode = postCode;
		this.city = city;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "address_id")
	public long getAddressId() {
		return addressId;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	
	@Column(name = "house_number", nullable = true, length = 10)
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	
	@Column(name = "street_name", nullable = true, length = 100)
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	@Column(name = "postcode", nullable = false, length = 10)
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	
	@Column(name = "city", nullable = false, length = 100)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
