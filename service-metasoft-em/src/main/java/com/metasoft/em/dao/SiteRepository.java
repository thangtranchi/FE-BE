package com.metasoft.em.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metasoft.em.entities.Site;
/**
 * 
 * @author Tran C Thang
 *
 */
public interface SiteRepository extends JpaRepository<Site, Long> {
	
	/**
	 * Find by site name 
	 * @param name
	 * @return List<Site>
	 */
	List<Site> findByName(String name);
	
	/**
	 * Find by keyword (site name)
	 * @param name
	 * @return List<Site>
	 */
	List<Site> findByNameContaining(String name);
	
	/**
	 * 
	 * @param longitude
	 * @param lattitude
	 * @return
	 */
	List<Site> findByLongitudeAndLattitude(float longitude,float lattitude);
}
