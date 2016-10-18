package com.metasoft.em.utils;

import com.metasoft.em.entities.Address;
import com.metasoft.em.entities.Department;
import com.metasoft.em.entities.Employee;
import com.metasoft.em.entities.Site;
import com.metasoft.em.model.AddressModel;
import com.metasoft.em.model.DepartmentModel;
import com.metasoft.em.model.EmployeeModel;
import com.metasoft.em.model.SiteModel;

/**
 * Convert the entity to model and model to entity
 * 
 * @author Tran C Thang
 *
 */
public class ConverterModelEntity {

	/**
	 * Address : model to entity
	 * @param model
	 * @return
	 */
	public static Address addressModelToEntity(AddressModel model) {
		if (model != null) {
			return new Address(model.getHouseNumber(), model.getStreet(),
					model.getPostCode(), model.getCity());
		}
		return null;
	}

	/**
	 * Address: entity to model
	 * @param entity
	 * @return
	 */
	public static AddressModel adressEntityToModel(Address entity) {
		if (entity != null) {
			return new AddressModel(entity.getAddressId(),
					entity.getHouseNumber(), entity.getStreet(),
					entity.getPostCode(), entity.getCity());
		}
		return new AddressModel();
	}

	/**
	 * Site : entity to model
	 * @param entity
	 * @return
	 */
	public static SiteModel siteEntityToModel(Site entity) {
		if (entity != null) {
			return new SiteModel(entity.getSiteId(),entity.getName(),
					adressEntityToModel(entity.getAddress()),
					entity.getLongitude(), entity.getLattitude(),
					entity.isExternal());
		}
		return new SiteModel();
	}

	/**
	 * Site : model to entity
	 * @param model
	 * @return
	 */
	public static Site siteModelToEntity(SiteModel model) {
		if (model != null) {
			return new Site(model.getName(),
					addressModelToEntity(model.getAddress()),
					model.getLongitude(), model.getLattitude(),
					model.isExternal());
		}
		return null;
	}

	/**
	 * Department entity to model
	 * @param entity
	 * @return
	 */
	public static DepartmentModel departmentEntityToModel(Department entity) {
		if (entity != null) {
			return new DepartmentModel(entity.getDepartmentId(),entity.getName(), entity.getManager(),
					entity.getAdditionalEmployee(), entity.isRoot(),
					entity.getParent());
		}
		return new DepartmentModel();
	}

	/**
	 * Department model to entity
	 * @param model
	 * @return
	 */
	public static Department departmentModelToEntity(DepartmentModel model) {
		if (model != null) {
			return new Department(model.getName(), model.getManager(),
					model.getAdditionalEmployee(), model.isRoot(),
					model.getParent());
		}
		return null;
	}

	/**
	 * Employee : entity to model
	 * @param entity
	 * @return
	 */
	public static EmployeeModel employeeEntityToModel(Employee entity) {
		if (entity != null) {
			return new EmployeeModel(entity.getEmployeeId(),
					entity.getFirstName(), entity.getLastName(),
					adressEntityToModel(entity.getAddress()),
					entity.getGender(), entity.getDob(), entity.getEmail(),
					entity.getFax(), entity.getMobileNumber(),
					entity.getBusinessPhone(), entity.isExternal(),
					entity.getEntryDate(), entity.getLeaveDate());
		}
		return new EmployeeModel();
	}

	/**
	 * Employee : model to entity
	 * @param model
	 * @return
	 */
	public static Employee employeeModelToEntity(EmployeeModel model) {
		if (model != null) {
			return new Employee(model.getFirstName(), model.getLastName(),
					addressModelToEntity(model.getAddress()),
					model.getGender(), model.getDob(), model.getEmail(),
					model.getFax(), model.getMobileNumber(),
					model.getBusinessPhone(), model.isExternal(),
					model.getEntryDate(), model.getLeaveDate());
		}
		return null;
	}
}
