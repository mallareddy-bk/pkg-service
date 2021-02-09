/**
 * 
 */
package com.pkg.portal.service.timesheet;

import java.util.List;
import java.util.Optional;

import com.pkg.portal.model.Timesheet;

/**
 * @author Mallareddy Belageri
 *
 */
public interface TimesheetService {
	
	void createTimesheet(Timesheet timesheet);

	List<Timesheet> getPendingApprovalTimesheets(String empId);
	
	Optional<Timesheet> getTimesheetById(long timesheetId);

	void updateTimesheet(Timesheet timesheet);

}
