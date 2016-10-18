package com.metasoft.em.model;

/**
 * 
 * @author Tran C Thang
 *
 */
public class SiteModel {

	private long siteId;
	private String name;
	private AddressModel address;
	private float longitude;
	private float lattitude;
	private boolean isExternal;
	
	/**
	 * 
	 */
	public SiteModel() {
		
	}
	
	/**
	 * @param siteId
	 * @param name
	 * @param address
	 * @param longitude
	 * @param lattitude
	 * @param isExternal
	 * @param currentName
	 */
	public SiteModel(long siteId, String name, AddressModel address,
			float longitude, float lattitude, boolean isExternal) {
		super();
		this.siteId = siteId;
		this.name = name;
		this.address = address;
		this.longitude = longitude;
		this.lattitude = lattitude;
		this.isExternal = isExternal;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public AddressModel getAddress() {
		return address;
	}
	public void setAddress(AddressModel address) {
		this.address = address;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public float getLattitude() {
		return lattitude;
	}
	public void setLattitude(float lattitude) {
		this.lattitude = lattitude;
	}
	public boolean isExternal() {
		return isExternal;
	}
	public void setExternal(boolean isExternal) {
		this.isExternal = isExternal;
	}
	public long getSiteId() {
		return siteId;
	}
	public void setSiteId(long siteId) {
		this.siteId = siteId;
	}
	 
}
