package com.metasoft.em.controller;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.metasoft.em.model.DepartmentModel;
import com.metasoft.em.restclient.RestClientService;

@Controller
public class DepartmentController {

	@Autowired
	private RestClientService restService;

	@RequestMapping(value = "/department", method = RequestMethod.GET)
	public ModelAndView handleGet() {
		ModelAndView view = new ModelAndView("department");
		view.addObject("allDept", restService.getAllDepartments());
		view.addObject("allEmployees", restService.getAllEmployee());
		return view;
	}

	@RequestMapping(value = "/ajax/addDepartment", method = RequestMethod.POST, headers = "Accept=*/*")
	@ResponseBody
	public DepartmentModel[] addDepartment(
			@RequestBody DepartmentModel department) {
		restService.saveDepartment(department);
		return restService.getAllDepartments();
	}

	@RequestMapping(value = "/ajax/checkDepartment", method = RequestMethod.POST, headers = "Accept=*/*")
	@ResponseBody
	public Boolean checkDepartment(@RequestBody DepartmentModel department) {
		return restService.checkDepartment(department);
	}

	@RequestMapping(value = "/ajax/getDepartment", method = RequestMethod.GET)
	@ResponseBody
	public DepartmentModel getDepartmentById(@QueryParam("id") String id) {
		return restService.getDepartmentById(id);
	}

	@RequestMapping(value = "/ajax/deleteDepartment", method = RequestMethod.GET)
	@ResponseBody
	public DepartmentModel[] deleteDepartment(@QueryParam("id") String id) {
		restService.deleteDepartment(id);
		return restService.getAllDepartments();
	}

}
