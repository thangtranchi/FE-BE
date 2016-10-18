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

import com.metasoft.em.model.DepartmentModel;
import com.metasoft.em.service.DepartmentService;

/**
 * Export the Restful web service to public
 * 
 * @author Tran C Thang - TCT
 *
 */
public class DepartmentRest {

	@Autowired
	DepartmentService service;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/savedepartment")
	@ResponseBody
	public boolean saveSite(DepartmentModel model) {
		return service.saveDepartment(model);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/checkdepartment")
	@ResponseBody
	public boolean checkDepartmentNameIsExisted(DepartmentModel model) {
		return service.checkDepartmentNameIsExisted(model);
	}
	
	@GET
	@Consumes(MediaType.TEXT_HTML)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getalldepartment")
	@ResponseBody
	public List<DepartmentModel> getAllSite() {
		return service.getAllDepartment();
	}

	@GET
	@Consumes(MediaType.TEXT_HTML)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getdepartment/{id}")
	@ResponseBody
	public DepartmentModel getSite(@PathParam(value = "id") String id) {
		return service.getDepartmentById(Long.parseLong(id));
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/deletedepartment/{id}")
	@ResponseBody
	public Boolean deleteSiteById(@PathParam(value = "id") String id) {
		return service.deleteDepartment(Long.parseLong(id));
	}
}
