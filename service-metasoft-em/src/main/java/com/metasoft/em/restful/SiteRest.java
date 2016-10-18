package com.metasoft.em.restful;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;

import com.metasoft.em.model.SiteModel;
import com.metasoft.em.service.SiteService;

/**
 * Export the Restful web service to public
 * 
 * @author Tran C Thang
 *
 */
public class SiteRest {

	@Autowired
	SiteService service;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/savesite")
	@ResponseBody
	public boolean saveSite(SiteModel model) {
		return service.saveSite(model);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/checkvalidsite")
	@ResponseBody
	public boolean checkSite(SiteModel model) {
		return service.checkSiteIsExisted(model);
	}
	
	@GET
	@Consumes(MediaType.TEXT_HTML)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getsitebyid/{id}")
	@ResponseBody
	public SiteModel getSiteByName(@PathParam(value = "id") String id) {
		return service.getSiteById(Long.parseLong(id));
	}
	
	@GET
	@Consumes(MediaType.TEXT_HTML)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getallsites")
	@ResponseBody
	public List<SiteModel> getAllSite() {
		return service.getAll();
	}

	@GET
	@Consumes(MediaType.TEXT_HTML)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getsitebykeyword/{keyword}")
	@ResponseBody
	public List<SiteModel> getSiteByKeyword(
			@PathParam(value = "keyword") String keyword) {
		return service.getSitesByKeyword(keyword);
	}
	
	@GET
	@Consumes(MediaType.TEXT_HTML)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getsitebylocation/{latitude}/{longtitude}")
	@ResponseBody
	public List<SiteModel> getSiteByLocaltion(
			@PathParam(value = "latitude") String latitude,@PathParam(value = "longtitude") String longtitude) {
		return service.getSiteByLocation(longtitude, latitude);
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/deletesite/{id}")
	@ResponseBody
	public Boolean deleteSiteById(@PathParam(value = "id") String id) {
		return service.deleteSite(Long.parseLong(id));
	}
}
