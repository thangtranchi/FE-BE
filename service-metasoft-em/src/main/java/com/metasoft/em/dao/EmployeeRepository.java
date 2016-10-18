package com.metasoft.em.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.metasoft.em.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


	  @Query("select count(e) from Employee e where e.leaveDate is null or e.leaveDate > :currentDate")
	  long countEmployeeEmployed(@Param("currentDate")Date currentDate);
	  
	  @Query("select count(e) from Employee e where e.leaveDate < :end or e.leaveDate > :start")
	  long countLeftEmployeeInDuration(@Param("start")Date start,@Param("end") Date end);
	  
	  @Query("select count(e) from Employee e where e.gender = 'true'")
	  long countMaleEmployee();
	  
}
