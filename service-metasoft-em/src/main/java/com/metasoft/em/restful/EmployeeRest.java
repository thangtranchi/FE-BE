package com.metasoft.em.restful;

import java.util.Date;
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

import com.metasoft.em.model.EmployeeModel;
import com.metasoft.em.service.EmployeeService;

/**
 * Export the Restful web service to public
 * 
 * @author Tran C Thang
 *
 */
public class EmployeeRest {

	@Autowired
	EmployeeService service;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/saveemployee")
	@ResponseBody
	public Boolean saveEmployee(EmployeeModel model) {
		return service.saveEmployee(model);
	}

	@GET
	@Consumes(MediaType.TEXT_HTML)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getallemployee")
	@ResponseBody
	public List<EmployeeModel> getAllEmployee() {
		return service.getAll();
	}

	@GET
	@Consumes(MediaType.TEXT_HTML)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getemployee/{employeeId}")
	@ResponseBody
	public EmployeeModel getEmployeeById(
			@PathParam(value = "employeeId") String employeeId) {
		return service.getEmployeeById(employeeId);
	}

	@GET
	@Consumes(MediaType.TEXT_HTML)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/tosite/{employeeId}/{siteId}")
	@ResponseBody
	public Boolean assignEmployeeToSite(
			@PathParam(value = "employeeId") String employeeId,
			@PathParam(value = "siteId") String siteId) {
		return service.assignToSite(Long.parseLong(employeeId),
				Long.parseLong(siteId));
	}

	@GET
	@Consumes(MediaType.TEXT_HTML)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/todepartment/{employeeId}/{departmentId}")
	@ResponseBody
	public Boolean assignEmployeeToDepartment(
			@PathParam(value = "employeeId") String employeeId,
			@PathParam(value = "departmentId") String departmentId) {
		return service.assignToDepartment(Long.parseLong(employeeId),
				Long.parseLong(departmentId));
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/delemployee/{employeeId}")
	@ResponseBody
	public Boolean deleteEmployeeById(
			@PathParam(value = "employeeId") String employeeId) {
		return service.deleteEmployee(Long.parseLong(employeeId));
	}

	@GET
	@Consumes(MediaType.TEXT_HTML)
	@Produces(MediaType.TEXT_HTML)
	@Path("/countavaiable")
	@ResponseBody
	public Long countAvailableEmployee() {
		return service.countEmployeeEmployed();
	}

	@GET
	@Consumes(MediaType.TEXT_HTML)
	@Produces(MediaType.TEXT_HTML)
	@Path("/countleft/{start}/{end}")
	@ResponseBody
	public Long countLeftEmployeeInDuration(
			@PathParam(value = "start") Date start,
			@PathParam(value = "end") Date end) {
		return service.countLeftEmployeeInDuration(start, end);
	}
	
	@GET
	@Consumes(MediaType.TEXT_HTML)
	@Produces(MediaType.TEXT_HTML)
	@Path("/ratemale")
	@ResponseBody
	public String calculateRate() {
		return service.rateMaleAndFemale();
	}
}
