package com.metasoft.em.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metasoft.em.dao.DepartmentRepository;
import com.metasoft.em.dao.EmployeeRepository;
import com.metasoft.em.dao.SiteRepository;
import com.metasoft.em.entities.Department;
import com.metasoft.em.entities.Employee;
import com.metasoft.em.entities.Site;
import com.metasoft.em.model.EmployeeModel;
import com.metasoft.em.service.EmployeeService;
import com.metasoft.em.utils.ConverterModelEntity;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	SiteRepository siteRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	public boolean saveEmployee(EmployeeModel model) {
		Employee employee = null;
		if (model.getEmployeeId() == -1) {
			employee = employeeRepository.save(ConverterModelEntity
					.employeeModelToEntity(model));
		} else {
			employee = employeeRepository.findOne(model.getEmployeeId());
			employee.setFirstName(model.getFirstName());
			employee.setLastName(model.getLastName());
			employee.getAddress().setHouseNumber(
					model.getAddress().getHouseNumber());
			employee.getAddress().setStreet(model.getAddress().getStreet());
			employee.getAddress().setPostCode(model.getAddress().getPostCode());
			employee.getAddress().setCity(model.getAddress().getCity());
			employee.setEmail(model.getEmail());
			employee.setExternal(model.isExternal());
			employee.setDob(model.getDob());
			employee.setGender(model.getGender());
			employee.setMobileNumber(model.getMobileNumber());
			employee.setBusinessPhone(model.getBusinessPhone());
			employee.setEntryDate(model.getEntryDate());
			employee.setLeaveDate(model.getLeaveDate());
			employeeRepository.save(employee);
		}
		return employee != null;
	}

	public boolean deleteEmployee(Long employeeNo) {
		Employee employee = employeeRepository.findOne(employeeNo);
		if (employee == null) {
			return false;
		} else {
			employeeRepository.delete(employee);
			return true;
		}
	}

	public boolean assignToDepartment(Long employeeNo, Long departmentId) {
		Department department = departmentRepository.findOne(departmentId);
		Employee employee = employeeRepository.findOne(employeeNo);
		if (department != null && employee != null) {
			List<Department> departmentList = new ArrayList<Department>();
			if (employee.getDepartmentList() != null
					&& employee.getDepartmentList().size() > 0) {
				employee.getDepartmentList().add(department);
			} else {
				departmentList.add(department);
				employee.setDepartmentList(departmentList);
			}
			employeeRepository.save(employee);
			return true;
		}
		return false;
	}

	public boolean assignToSite(Long employeeNo, Long siteId) {
		Site site = siteRepository.findOne(siteId);
		Employee employee = employeeRepository.findOne(employeeNo);
		if (site != null && employee != null) {
			List<Site> siteList = new ArrayList<Site>();
			if (employee.getSiteList() != null
					&& employee.getSiteList().size() > 0) {
				employee.getSiteList().add(site);
			} else {
				siteList.add(site);
				employee.setSiteList(siteList);
			}
			employeeRepository.save(employee);
			return true;
		}
		return false;
	}

	public long countAllEmployees() {
		return employeeRepository.count();
	}

	public long countEmployeeEmployed() {
		return employeeRepository.countEmployeeEmployed(new Date());
	}

	public long countLeftEmployeeInDuration(Date startDate, Date endDate) {
		return employeeRepository.countLeftEmployeeInDuration(startDate,
				endDate);
	}

	public long countEmployeeByDepartment(Long departmentId) {
		Department d = departmentRepository.findOne(departmentId);
		if (d != null) {
			if (d.getEmployeeList() != null) {
				return d.getEmployeeList().size();
			}
			return 0;
		}
		return 0;
	}

	public long countEmployeeBySite(Long siteId) {
		Site s = siteRepository.findOne(siteId);
		if (s != null) {
			if (s.getEmployeeList() != null) {
				return s.getEmployeeList().size();
			}
			return 0;
		}
		return 0;
	}

	public String rateMaleAndFemale() {
		Long maleCount = employeeRepository.countMaleEmployee();
		Long total = employeeRepository.count();
		long x = maleCount.longValue();
		long y = total.longValue();
		double z = ((double)x/y)*100;
		return String.valueOf(z);
	}

	public List<EmployeeModel> getAll() {
		List<Employee> entityList = employeeRepository.findAll();
		List<EmployeeModel> modelList = new ArrayList<EmployeeModel>();
		for (Employee site : entityList) {
			modelList.add(ConverterModelEntity.employeeEntityToModel(site));
		}
		return modelList;
	}

	public EmployeeModel getEmployeeById(String employeeId) {
		Employee employee = employeeRepository.findOne(Long
				.parseLong(employeeId));
		EmployeeModel model = ConverterModelEntity
				.employeeEntityToModel(employee);
		List<String> departmentNames = new ArrayList<String>();
		List<String> siteNames = new ArrayList<String>();
		List<Department> departmentList = employee.getDepartmentList();
		List<Site> siteList = employee.getSiteList();
		if (departmentList != null) {
			for (Department item : departmentList) {
				departmentNames.add(item.getName());
			}
		}
		if (siteList != null) {
			for (Site item : siteList) {
				siteNames.add(item.getName());
			}
		}
		model.setDepartmentList(departmentNames);
		model.setSiteList(siteNames);
		return model;
	}

}
