package com.metasoft.em.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metasoft.em.dao.SiteRepository;
import com.metasoft.em.entities.Site;
import com.metasoft.em.model.SiteModel;
import com.metasoft.em.service.SiteService;
import com.metasoft.em.utils.ConverterModelEntity;

@Service
@Transactional
public class SiteServiceImpl implements SiteService {

	@Autowired
	SiteRepository repository;

	/**
	 * Get site by ID
	 */
	public SiteModel getSiteById(long id) {
		Site site = repository.findOne(id);
		return ConverterModelEntity.siteEntityToModel(site);
	}

	/**
	 * Get Site by wildcard
	 */
	public List<SiteModel> getSitesByKeyword(String keyword) {
		List<Site> siteList = repository.findByNameContaining(keyword);
		List<SiteModel> modelList = new ArrayList<SiteModel>();
		for (Site site : siteList) {
			modelList.add(ConverterModelEntity.siteEntityToModel(site));
		}
		return modelList;
	}

	/**
	 * Get Site by location
	 */
	public List<SiteModel> getSiteByLocation(String longitude, String lattitude) {
		float x = Float.parseFloat(longitude);
		float y = Float.parseFloat(lattitude);
		List<Site> siteList = repository.findByLongitudeAndLattitude(x, y);
		List<SiteModel> modelList = new ArrayList<SiteModel>();
		for (Site site : siteList) {
			modelList.add(ConverterModelEntity.siteEntityToModel(site));
		}
		return modelList;
	}

	public boolean saveSite(SiteModel model) {
		//Add new Site
		if(model.getSiteId()==-1){
			repository.save(ConverterModelEntity.siteModelToEntity(model));
			return true;
		}
		//Update site
		else{
			Site site = repository.findOne(model.getSiteId());
			site.setLattitude(model.getLattitude());
			site.setLongitude(model.getLongitude());
			site.getAddress().setHouseNumber(model.getAddress().getHouseNumber());
			site.getAddress().setStreet(model.getAddress().getStreet());
			site.getAddress().setPostCode(model.getAddress().getPostCode());
			site.getAddress().setCity(model.getAddress().getCity());
			site.setName(model.getName());
			site.setExternal(model.isExternal());
			repository.save(site);
			return true;

		}
	}

	public boolean deleteSite(long id) {
		Site site = repository.findOne(id);
		if (site == null) {
			return false;
		} else {
			repository.delete(id);
			return true;
		}
	}

	public List<SiteModel> getAll() {
		List<Site> siteList = repository.findAll();
		List<SiteModel> modelList = new ArrayList<SiteModel>();
		for (Site site : siteList) {
			modelList.add(ConverterModelEntity.siteEntityToModel(site));
		}
		return modelList;
	}

	public Boolean checkSiteIsExisted(SiteModel model) {
		List<Site> sites = repository.findByName(model.getName());
		boolean existedSiteName = sites!=null&&sites.size()>0;
		//Add new Site
		if(model.getSiteId()==-1){
			if(existedSiteName && sites.get(0).getName()!=null && sites.get(0).getName().equalsIgnoreCase(model.getName())){
				//Site name is already existed!!!
				return false;
			}
		}
		//Update site
		else{
			if(existedSiteName && sites.get(0).getSiteId()!=model.getSiteId()){
				//Site name is already existed on another site!!!
				return false;
			}
		}
		return true;
	}
}
