/**
 * 
 */
package com.pkg.portal.controllers.timesheet;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pkg.portal.model.Timesheet;
import com.pkg.portal.service.timesheet.TimesheetService;

/**
 * @author Mallareddy Belageri
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({ "/timesheet" })
public class TimesheetController {
	
	@Autowired
	TimesheetService timesheetService;

	@SuppressWarnings("unchecked")
	@PostMapping ("/submit")
	public void submitTimesheet(@RequestBody Object timesheetData) throws Exception {
		System.out.println("Started Timesheet Submission");
		if (null != timesheetData) {
			Map<String, Object> timesheetMap = (Map<String, Object>)timesheetData;
			if (null != timesheetMap && timesheetMap.get("selectedCountry").toString().isEmpty() 
					|| timesheetMap.get("selectedDate").toString().isEmpty() || timesheetMap.get("empId").toString().isEmpty()
					|| timesheetMap.get("selectedState").toString().isEmpty() || timesheetMap.get("selectedHotel").toString().isEmpty()
					|| timesheetMap.get("selectedRoom").toString().isEmpty() || timesheetMap.get("selectedService").toString().isEmpty()) {
				throw new Exception("Please enter all the required fields.");
			} else {
				String country = (String) timesheetMap.get("selectedCountry");
				String date = (String) timesheetMap.get("selectedDate");
				Map<String, Object> stateMap = (Map<String, Object>) timesheetMap.get("selectedState");
				Map<String, Object> hotelMap = (Map<String, Object>) timesheetMap.get("selectedHotel");
				Map<String, Object> roomMap = (Map<String, Object>) timesheetMap.get("selectedRoom");
				Map<String, Object> roomCategoryMap = (Map<String, Object>) timesheetMap.get("selectedService");
				Date timesheetDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").parse(date); 
				String empId = (String) timesheetMap.get("empId");
				
				Timesheet timesheet = new Timesheet();
				timesheet.setEmployeeId(empId);
				if ("Australia".equals(country)) {
					timesheet.setCountryId(new Long(1));
				}
				timesheet.setStateId(Long.valueOf((Integer) stateMap.get("stateId")));
				timesheet.setHotelId(Long.valueOf((Integer) hotelMap.get("hotelId")));
				timesheet.setRoomId(Long.valueOf((Integer) roomMap.get("roomId")));
				timesheet.setRoomCatId(Long.valueOf((Integer) roomCategoryMap.get("roomCatId")));
				timesheet.setStatus("SUBMITTED");
				timesheet.setTimesheetDate(timesheetDate);
				timesheet.setSubmittedDate(new Date());
				
				timesheetService.createTimesheet(timesheet);
			}
		} else {
			throw new Exception("Please enter all the required fields.");
		}
		System.out.println("Completed Timesheet Submission");
	}
}
