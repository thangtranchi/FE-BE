package com.metasoft.em.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.metasoft.em.model.EmployeeModel;
import com.metasoft.em.restclient.RestClientService;

@RestController
public class EmployeeController {

	@Autowired
	private RestClientService restService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView handleGet() {
		ModelAndView view = employeeGet();
		return view;
	}

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public ModelAndView handleGet1() {
		ModelAndView view = employeeGet();
		return view;
	}

	@RequestMapping(value = "/ajax/addEmployee", method = RequestMethod.POST, headers = "Accept=*/*")
	@ResponseBody
	public EmployeeModel[] addEmployee(@RequestBody EmployeeModel employee) {
		restService.saveOrUpdateEmployee(employee);
		return restService.getAllEmployee();
	}

	@RequestMapping(value = "/ajax/getEmployee", method = RequestMethod.GET)
	@ResponseBody
	public EmployeeModel getEmployee(@QueryParam("id") String id) {
		return restService.getEmployeeById(id);
	}

	@RequestMapping(value = "/ajax/deleteEmployee", method = RequestMethod.GET)
	@ResponseBody
	public EmployeeModel[] deleteEmployee(@QueryParam("id") String id) {
		restService.deleteEmployee(id);
		return restService.getAllEmployee();
	}

	@RequestMapping(value = "/ajax/assignToSite", method = RequestMethod.GET)
	@ResponseBody
	public Boolean assignEmployeeToSite(
			@QueryParam("employeeId") String employeeId,
			@QueryParam("siteId") String siteId) {

		return restService.assignToSite(employeeId, siteId);
	}

	@RequestMapping(value = "/ajax/assignToDepartment", method = RequestMethod.GET)
	@ResponseBody
	public Boolean assignEmployeeToDepartment(
			@QueryParam("employeeId") String employeeId,
			@QueryParam("departmentId") String departmentId) {

		return restService.assignToDepartmentRest(employeeId, departmentId);
	}

	@RequestMapping(value = "/downloadCSV", method = RequestMethod.POST)
	public void downloadCSV(HttpServletResponse response) throws IOException {

		response.setContentType("text/csv");
		String reportName = "CSV_Report_Employee.csv";
		response.setHeader("Content-disposition", "attachment;filename="
				+ reportName);

		List<String> rows = new ArrayList<String>();
		rows.add("Employee number,Employee full name,Employee type,entry date,leaving date");
		rows.add("\n");
		EmployeeModel[] models = restService.getAllEmployee();
		for (int i = 0; i < models.length; i++) {
			String type = models[i].isExternal() ? "external" : "internal";
			rows.add(String.valueOf(models[i].getEmployeeId()) + ","
					+ models[i].getFirstName() + " " + models[i].getLastName()
					+ "," + type + "," + models[i].getEntryDateStr() + ","
					+ models[i].getLeaveDate());
			rows.add("\n");
		}

		Iterator<String> iter = rows.iterator();
		while (iter.hasNext()) {
			String outputString = (String) iter.next();
			response.getOutputStream().print(outputString);
		}

		response.getOutputStream().flush();

	}

	private ModelAndView employeeGet() {
		ModelAndView view = new ModelAndView("home");
		view.addObject("allEmployees", restService.getAllEmployee());
		view.addObject("allSites", restService.getAllSites());
		view.addObject("allDeparments", restService.getAllDepartments());
		return view;
	}
}
