/**
 * 
 */
package com.pkg.portal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pkg.portal.model.Timesheet;

/**
 * @author Mallareddy Belageri
 *
 */
public interface TimesheetRepository extends CrudRepository<Timesheet, Long>{

	List<Timesheet> findByEmployeeId(String empId);

	List<Timesheet> findByStatus(String status);

}
