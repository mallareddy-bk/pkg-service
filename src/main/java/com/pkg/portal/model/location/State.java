/**
 * 
 */
package com.pkg.portal.model.location;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.pkg.portal.model.hotel.Hotel;

/**
 * @author Mallareddy Belageri
 *
 */
@Entity
@Table(name = "STATE")
public class State {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name="STATE_ID")
    private Long stateId;
	
	@Column (name="STATE_NAME")
	private String stateName;
	
	@ManyToOne
    @JoinColumn(name="COUNTRY_ID", nullable=false)
    private Country country;
	
	@OneToMany(mappedBy="state")
    private Set<Hotel> hotels;
	
	public State() {
		// TODO Auto-generated constructor stub
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
	 * @return the stateName
	 */
	public String getStateName() {
		return stateName;
	}

	/**
	 * @param stateName the stateName to set
	 */
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	/**
	 * @return the country
	 */
	public Country getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(Country country) {
		this.country = country;
	}

	/**
	 * @return the hotels
	 */
	public Set<Hotel> getHotels() {
		return hotels;
	}

	/**
	 * @param hotels the hotels to set
	 */
	public void setHotels(Set<Hotel> hotels) {
		this.hotels = hotels;
	}
	
}
