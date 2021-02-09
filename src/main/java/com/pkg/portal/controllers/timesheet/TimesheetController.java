/**
 * 
 */
package com.pkg.portal.controllers.timesheet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pkg.portal.bean.TimesheetData;
import com.pkg.portal.model.Timesheet;
import com.pkg.portal.model.hotel.Hotel;
import com.pkg.portal.model.room.Room;
import com.pkg.portal.model.room.RoomCategory;
import com.pkg.portal.service.hotel.HotelService;
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
	
	@Autowired
	HotelService hotelService;

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
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(timesheetDate);
				calendar.add(Calendar.DAY_OF_MONTH, 1); 
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
				timesheet.setTimesheetDate(calendar.getTime());
				timesheet.setSubmittedDate(new Date());
				
				timesheetService.createTimesheet(timesheet);
			}
		} else {
			throw new Exception("Please enter all the required fields.");
		}
		System.out.println("Completed Timesheet Submission");
	}
	
	@GetMapping ("/tasklist")
	public List<TimesheetData> getPendingTaskList() throws Exception {
		System.out.println("getPendingTaskList(): Started");
		List<Timesheet> timesheetList = timesheetService.getPendingApprovalTimesheets("SUBMITTED");
		//timesheetList = timesheetService.getPendingApprovalTimesheets("SUBMITTED");
		List<TimesheetData> timesheetDatas = null;
		if (!CollectionUtils.isEmpty(timesheetList)) {
			int count =1;
			timesheetDatas = new ArrayList<TimesheetData>();
			for (Timesheet timesheet: timesheetList) {
				Hotel hotel = hotelService.getHotel(timesheet.getHotelId());
				String hotelName = "";
				String roomNo = "";
				String serviceName = "";
				if (null != hotel) {
					hotelName = hotel.getHotelName();
					if (!CollectionUtils.isEmpty(hotel.getRooms())) {
						for (Room room: hotel.getRooms()) {
							if (timesheet.getRoomId().longValue() == room.getRoomId().longValue()) {
								roomNo = room.getRoomNo();
								Set<RoomCategory> roomCategories = room.getRoomCategories();
								if (!CollectionUtils.isEmpty(roomCategories)) {
									for (RoomCategory roomCategory: roomCategories) {
										if (timesheet.getRoomCatId().longValue() == roomCategory.getRoomCatId().longValue()) {
											serviceName = roomCategory.getRoomCatName();
											break;
										}
									}
								}
								break;
							}
						}
					}
				}
				TimesheetData timesheetData = new TimesheetData(count, timesheet.getId(), timesheet.getEmployeeId(),
						hotelName, roomNo, serviceName, timesheet.getTimesheetDate().toString().substring(0, 10));
				timesheetDatas.add(timesheetData);
				count++;
			}
		}
		return timesheetDatas;
	}
	
	@PostMapping("/approve")
	public List<TimesheetData> approveTimesheet(@RequestBody TimesheetData timesheetData) throws Exception {
		return updateTimesheet(timesheetData, "APPROVED");
	}
	
	@PostMapping("/reject")
	public List<TimesheetData> rejectTimesheet(@RequestBody TimesheetData timesheetData) throws Exception {
		return updateTimesheet(timesheetData, "REJECTED");
	}

	/**
	 * @param timesheetData
	 * @return 
	 * @throws Exception 
	 */
	private List<TimesheetData> updateTimesheet(TimesheetData timesheetData, String status) throws Exception {
		Optional<Timesheet> optTimesheet = timesheetService.getTimesheetById(timesheetData.getTimesheetId());
		if (null != optTimesheet) {
			Timesheet timesheet = optTimesheet.get();
			timesheet.setStatus(status);
			timesheetService.updateTimesheet(timesheet);
		}
		return getPendingTaskList();
	}
}
