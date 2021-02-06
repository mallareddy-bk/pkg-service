/**
 * 
 */
package com.pkg.portal.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Mallareddy Belageri
 *
 */
@Entity
@Table(name = "TIMESHEET")
public class Timesheet {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name="TIMESHEET_ID")
    private Long id;
	
	@Column (name="EMP_ID")
	private String employeeId;
	
	@Column (name="COUNTRY_ID")
    private Long countryId;
	
	@Column (name="STATE_ID")
    private Long stateId;
	
	@Column (name="HOTEL_ID")
    private Long hotelId;
	
	@Column (name="ROOM_ID")
    private Long roomId;
	
	@Column (name="ROOM_CATEGORY_ID")
    private Long roomCatId;
	
	@Column (name="STATUS")
	private String status;
	
	@Column (name="REMARKS")
	private String remarks;
	
	@Column (name="TIMESHEET_DATE")
	private Date timesheetDate;
	
	@Column (name="SUBMITTED_DATE")
	private Date submittedDate;
	
	@Column (name="APPROVE_REJECT_DATE")
	private Date approveOrRejectDate;
	
	public Timesheet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the employeeId
	 */
	public String getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the countryId
	 */
	public Long getCountryId() {
		return countryId;
	}

	/**
	 * @param countryId the countryId to set
	 */
	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	/**
	 * @return the stateId
	 */
	public Long getStateId() {
		return stateId;
	}

	/**
	 * @param stateId the stateId to set
	 */
	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	/**
	 * @return the hotelId
	 */
	public Long getHotelId() {
		return hotelId;
	}

	/**
	 * @param hotelId the hotelId to set
	 */
	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	/**
	 * @return the roomId
	 */
	public Long getRoomId() {
		return roomId;
	}

	/**
	 * @param roomId the roomId to set
	 */
	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	/**
	 * @return the roomCatId
	 */
	public Long getRoomCatId() {
		return roomCatId;
	}

	/**
	 * @param roomCatId the roomCatId to set
	 */
	public void setRoomCatId(Long roomCatId) {
		this.roomCatId = roomCatId;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * @return the timesheetDate
	 */
	public Date getTimesheetDate() {
		return timesheetDate;
	}

	/**
	 * @param timesheetDate the timesheetDate to set
	 */
	public void setTimesheetDate(Date timesheetDate) {
		this.timesheetDate = timesheetDate;
	}

	/**
	 * @return the submittedDate
	 */
	public Date getSubmittedDate() {
		return submittedDate;
	}

	/**
	 * @param submittedDate the submittedDate to set
	 */
	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}

	/**
	 * @return the approveOrRejectDate
	 */
	public Date getApproveOrRejectDate() {
		return approveOrRejectDate;
	}

	/**
	 * @param approveOrRejectDate the approveOrRejectDate to set
	 */
	public void setApproveOrRejectDate(Date approveOrRejectDate) {
		this.approveOrRejectDate = approveOrRejectDate;
	}

}
