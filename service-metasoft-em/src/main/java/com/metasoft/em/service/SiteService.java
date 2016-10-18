package com.metasoft.em.service;

import java.util.List;

import com.metasoft.em.model.SiteModel;

/**
 * Site Service Interface
 * 
 * @author Tran C Thang
 *
 */
public interface SiteService {

	/**
	 * 
	 * @param keyword
	 * @return List<SiteModel>
	 */
	List<SiteModel> getAll();
	
	/**
	 * get Site by PK
	 * 
	 * @param name
	 * @return Site
	 */
	SiteModel getSiteById(long id);

	/**
	 * check the Site name is existed or not
	 * @param id
	 * @return
	 */
	Boolean checkSiteIsExisted(SiteModel model);
	
	/**
	 * get Site list by wildcard name
	 * 
	 * @param keyword
	 * @return List<SiteModel>
	 */
	List<SiteModel> getSitesByKeyword(String keyword);

	/**
	 * get Site by location
	 * 
	 * @param longitude
	 * @param lattitude
	 * @return Site
	 */
	List<SiteModel> getSiteByLocation(String longitude, String lattitude);

	/**
	 * create new or update a Site
	 * 
	 * @param model
	 * @return boolean
	 */
	boolean saveSite(SiteModel model);

	/**
	 * delete a Site
	 * 
	 * @param name
	 * @return boolean
	 */
	boolean deleteSite(long id);

}
