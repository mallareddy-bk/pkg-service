/**
 * 
 */
package com.pkg.portal.repository;

import org.springframework.data.repository.CrudRepository;

import com.pkg.portal.model.employee.Employee;

/**
 * @author Mallareddy Belageri
 *
 */
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	Employee findByEmpId(String empId);

	Employee findByEmailId(String emailId);

}