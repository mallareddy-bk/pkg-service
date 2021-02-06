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
	public String selectedCountry;
    public Date selectedDate;
    public State selectedState;
    public Hotel selectedHotel;
    public Room selectedRoom;
    public RoomCategory selectedService;
	/**
	 * @return the selectedCountry
	 */
	public String getSelectedCountry() {
		return selectedCountry;
	}
	/**
	 * @param selectedCountry the selectedCountry to set
	 */
	public void setSelectedCountry(String selectedCountry) {
		this.selectedCountry = selectedCountry;
	}
	/**
	 * @return the selectedDate
	 */
	public Date getSelectedDate() {
		return selectedDate;
	}
	/**
	 * @param selectedDate the selectedDate to set
	 */
	public void setSelectedDate(Date selectedDate) {
		this.selectedDate = selectedDate;
	}
	/**
	 * @return the selectedState
	 */
	public State getSelectedState() {
		return selectedState;
	}
	/**
	 * @param selectedState the selectedState to set
	 */
	public void setSelectedState(State selectedState) {
		this.selectedState = selectedState;
	}
	/**
	 * @return the selectedHotel
	 */
	public Hotel getSelectedHotel() {
		return selectedHotel;
	}
	/**
	 * @param selectedHotel the selectedHotel to set
	 */
	public void setSelectedHotel(Hotel selectedHotel) {
		this.selectedHotel = selectedHotel;
	}
	/**
	 * @return the selectedRoom
	 */
	public Room getSelectedRoom() {
		return selectedRoom;
	}
	/**
	 * @param selectedRoom the selectedRoom to set
	 */
	public void setSelectedRoom(Room selectedRoom) {
		this.selectedRoom = selectedRoom;
	}
	/**
	 * @return the selectedService
	 */
	public RoomCategory getSelectedService() {
		return selectedService;
	}
	/**
	 * @param selectedService the selectedService to set
	 */
	public void setSelectedService(RoomCategory selectedService) {
		this.selectedService = selectedService;
	}
    
    
}
