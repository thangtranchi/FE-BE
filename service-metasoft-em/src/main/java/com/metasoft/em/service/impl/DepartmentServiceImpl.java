package com.metasoft.em.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metasoft.em.dao.DepartmentRepository;
import com.metasoft.em.entities.Department;
import com.metasoft.em.model.DepartmentModel;
import com.metasoft.em.service.DepartmentService;
import com.metasoft.em.utils.ConverterModelEntity;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;


	public DepartmentModel getDepartmentByName(String name) {
		return ConverterModelEntity
				.departmentEntityToModel(departmentRepository.findByName(name));
	}

	public List<DepartmentModel> getDepartmentsByKeyword(String keyword) {
		List<Department> departmentList = departmentRepository
				.findByNameContaining(keyword);
		List<DepartmentModel> modelList = new ArrayList<DepartmentModel>();
		for (Department entity : departmentList) {
			modelList.add(ConverterModelEntity.departmentEntityToModel(entity));
		}
		return modelList;
	}

	public List<DepartmentModel> getDepartmentByManager(String managerNo) {
		List<Department> departmentList = departmentRepository
				.findByManager(managerNo);
		List<DepartmentModel> modelList = new ArrayList<DepartmentModel>();
		for (Department entity : departmentList) {
			modelList.add(ConverterModelEntity.departmentEntityToModel(entity));
		}
		return modelList;
	}

	public boolean saveDepartment(DepartmentModel model) {
		// Add new Site
		if (model.getDepartmentId() == -1) {
			departmentRepository.save(ConverterModelEntity
					.departmentModelToEntity(model));
			return true;
		}
		// Update site
		else {
			Department department = departmentRepository.findOne(model
					.getDepartmentId());
			department.setName(model.getName());
			department.setRoot(model.isRoot());
			department.setParent(model.getParent());
			department.setManager(model.getManager());
			department.setAdditionalEmployee(model.getAdditionalEmployee());
			departmentRepository.save(department);
			return true;
		}
	}

	public boolean deleteDepartment(Long id) {
		Department department = departmentRepository.findOne(id);
		if (department == null) {
			return false;
		} else {
			departmentRepository.delete(department);
			return true;
		}
	}

	public List<DepartmentModel> getAllDepartment() {
		List<Department> departmentList = departmentRepository.findAll();
		List<DepartmentModel> modelList = new ArrayList<DepartmentModel>();
		for (Department entity : departmentList) {
			modelList.add(ConverterModelEntity.departmentEntityToModel(entity));
		}
		return modelList;
	}

	public DepartmentModel getDepartmentById(long id) {
		return ConverterModelEntity
				.departmentEntityToModel(departmentRepository.findOne(id));
	}

	public Boolean checkDepartmentNameIsExisted(DepartmentModel model) {
		Department departments = departmentRepository.findByName(model
				.getName());

		// Add new Department
		if (model.getDepartmentId() == -1) {
			if (departments != null && departments.getName() != null
					&& departments.getName().equalsIgnoreCase(model.getName())) {
				// Site name is already existed!!!
				return false;
			}
		}
		// Update site
		else {
			if (departments != null
					&& departments.getDepartmentId() != model.getDepartmentId()) {
				// Site name is already existed on another site!!!
				return false;
			}
		}
		return true;
	}

}
