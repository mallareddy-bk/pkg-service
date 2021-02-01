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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Mallareddy Belageri
 *
 */
@Entity
@Table(name = "COUNTRY")
public class Country {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name="COUNTRY_ID")
    private Long countryId;
	
	@Column (name="COUNTRY_NAME")
	private String countryName;
	
	@OneToMany(mappedBy="country")
    private Set<State> states;
	
	public Country() {
		// TODO Auto-generated constructor stub
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
	 * @return the countryName
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * @param countryName the countryName to set
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	/**
	 * @return the states
	 */
	public Set<State> getStates() {
		return states;
	}

	/**
	 * @param states the states to set
	 */
	public void setStates(Set<State> states) {
		this.states = states;
	}

}
