/**
 * 
 */
package com.pkg.portal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkg.portal.model.Timesheet;
import com.pkg.portal.repository.TimesheetRepository;
import com.pkg.portal.service.timesheet.TimesheetService;

/**
 * @author Mallareddy Belageri
 *
 */
@Service
public class TimesheetServiceImpl implements TimesheetService {

	@Autowired
	TimesheetRepository timesheetRepo;
	
	@Override
	public void createTimesheet(Timesheet timesheet) {
		timesheetRepo.save(timesheet);
	}

}
