/**
 * 
 */
package com.pkg.portal.bean;

import java.util.Date;

import com.pkg.portal.model.hotel.Hotel;
import com.pkg.portal.model.location.State;
import com.pkg.portal.model.room.Room;
import com.pkg.portal.model.room.RoomCategory;

/**
 * @author Mallareddy Belageri
 *
 */
public class TimesheetData {
	
	private int position;
	private long timesheetId;
	private String empId;
	private String hotelName;
	private String roomNo;
	private String serviceName;
	private String date;
	
	/**
	 * @param position
	 * @param timesheetId
	 * @param empId
	 * @param hotelName
	 * @param roomNo
	 * @param serviceName
	 * @param date
	 */
	public TimesheetData(int position, long timesheetId, String empId,
			String hotelName, String roomNo, String serviceName, String date) {
		super();
		this.position = position;
		this.timesheetId = timesheetId;
		this.empId = empId;
		this.hotelName = hotelName;
		this.roomNo = roomNo;
		this.serviceName = serviceName;
		this.date = date;
	}

	/**
	 * @return the position
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(int position) {
		this.position = position;
	}

	/**
	 * @return the timesheetId
	 */
	public long getTimesheetId() {
		return timesheetId;
	}

	/**
	 * @param timesheetId the timesheetId to set
	 */
	public void setTimesheetId(long timesheetId) {
		this.timesheetId = timesheetId;
	}

	/**
	 * @return the empId
	 */
	public String getEmpId() {
		return empId;
	}

	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(String empId) {
		this.empId = empId;
	}

	/**
	 * @return the hotelName
	 */
	public String getHotelName() {
		return hotelName;
	}

	/**
	 * @param hotelName the hotelName to set
	 */
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	/**
	 * @return the roomNo
	 */
	public String getRoomNo() {
		return roomNo;
	}

	/**
	 * @param roomNo the roomNo to set
	 */
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	/**
	 * @return the serviceName
	 */
	public String getServiceName() {
		return serviceName;
	}

	/**
	 * @param serviceName the serviceName to set
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

}
