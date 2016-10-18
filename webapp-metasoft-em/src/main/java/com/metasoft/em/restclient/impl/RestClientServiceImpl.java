package com.metasoft.em.restclient.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.metasoft.em.model.DepartmentModel;
import com.metasoft.em.model.EmployeeModel;
import com.metasoft.em.model.SiteModel;
import com.metasoft.em.restclient.RestClientService;

/**
 * The Class ETACourierConfigServiceImpl.
 */
@Service
public class RestClientServiceImpl implements RestClientService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${employee.getbyId}")
	private String getEmployeeByIdUrl;

	@Value("${employee.getAll}")
	private String getAllEmployeeUrl;

	@Value("${employee.save}")
	private String saveEmployeeUrl;

	@Value("${employee.toSite}")
	private String assignEmployeeToSiteUrl;

	@Value("${employee.toDepartment}")
	private String assignEmployeeToDeptUrl;

	@Value("${employee.delete}")
	private String deleteEmployeeUrl;

	@Value("${site.getAll}")
	private String getAllSiteUrl;

	@Value("${site.saveSite}")
	private String saveSiteUrl;

	@Value("${site.checkSite}")
	private String checkSiteUrl;

	@Value("${site.getById}")
	private String getSiteByIdUrl;

	@Value("${site.delete}")
	private String delteSiteUrl;

	@Value("${department.getAll}")
	private String getAllDepartmentUrl;

	@Value("${department.save}")
	private String saveDepartmentUrl;

	@Value("${department.checkDepartment}")
	private String checkDepartmentUrl;
	
	@Value("${department.getById}")
	private String getDepartmentByIdUrl;
	
	@Value("${department.delete}")
	private String deleteDepartmentUrl;

	public EmployeeModel getEmployeeById(String id) {
		return restTemplate.getForObject(getEmployeeByIdUrl + id.trim(),
				EmployeeModel.class);
	}

	public EmployeeModel[] getAllEmployee() {
		return restTemplate.getForObject(getAllEmployeeUrl,
				EmployeeModel[].class);
	}

	public void saveOrUpdateEmployee(EmployeeModel employee) {
		restTemplate.postForObject(saveEmployeeUrl, employee, Boolean.class);
	}

	public Boolean assignToSite(String employeeId, String siteId) {
		return restTemplate.getForObject(
				assignEmployeeToSiteUrl + employeeId.trim() + "/"
						+ siteId.trim(), Boolean.class);
	}

	public Boolean assignToDepartmentRest(String employeeId, String departmentId) {
		return restTemplate.getForObject(
				assignEmployeeToDeptUrl + employeeId.trim() + "/"
						+ departmentId.trim(), Boolean.class);
	}

	public void deleteEmployee(String id) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		restTemplate.delete(deleteEmployeeUrl, params);
	}

	public SiteModel[] getAllSites() {
		return restTemplate.getForObject(getAllSiteUrl, SiteModel[].class);
	}

	public Boolean saveSite(SiteModel site) {
		return restTemplate.postForObject(saveSiteUrl, site, Boolean.class);
	}

	public Boolean checkSite(SiteModel site) {
		return restTemplate.postForObject(checkSiteUrl, site, Boolean.class);
	}

	public SiteModel getSiteById(String id) {
		return restTemplate.getForObject(getSiteByIdUrl + id.trim(),
				SiteModel.class);
	}

	public void deleteSite(String id) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		restTemplate.delete(delteSiteUrl, params);
	}

	public DepartmentModel[] getAllDepartments() {
		return restTemplate.getForObject(getAllDepartmentUrl,
				DepartmentModel[].class);
	}

	public void saveDepartment(DepartmentModel department) {
		restTemplate
				.postForObject(saveDepartmentUrl, department, Boolean.class);
	}

	public Boolean checkDepartment(DepartmentModel department) {
		return restTemplate.postForObject(checkDepartmentUrl, department,
				Boolean.class);
	}
	
	public DepartmentModel getDepartmentById(String id) {
		return restTemplate.getForObject(getDepartmentByIdUrl + id.trim(),
				DepartmentModel.class);
	}

	public void deleteDepartment(String id) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		restTemplate.delete(deleteDepartmentUrl, params);
	}
}
