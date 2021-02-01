/**
 * 
 */
package com.pkg.portal.model.hotel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.pkg.portal.model.location.State;

/**
 * @author Mallareddy Belageri
 *
 */
@Entity
@Table(name = "HOTEL")
public class Hotel {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name="HOTEL_ID")
    private Long hotelId;
	
	@Column (name="HOTEL_CODE")
	private String hotelCode;
	
	@Column (name="HOTEL_NAME")
	private String hotelName;
	
	@ManyToOne
    @JoinColumn(name="STATE_ID", nullable=false)
    private State state;

	public Hotel() {
		// TODO Auto-generated constructor stub
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
	 * @return the hotelCode
	 */
	public String getHotelCode() {
		return hotelCode;
	}

	/**
	 * @param hotelCode the hotelCode to set
	 */
	public void setHotelCode(String hotelCode) {
		this.hotelCode = hotelCode;
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
	 * @return the state
	 */
	public State getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(State state) {
		this.state = state;
	}
	
	
}
