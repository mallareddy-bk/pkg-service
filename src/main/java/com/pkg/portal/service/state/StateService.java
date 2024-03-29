/**
 * 
 */
package com.pkg.portal.service.state;

import java.util.List;

import com.pkg.portal.model.hotel.Hotel;
import com.pkg.portal.model.location.State;

/**
 * @author Mallareddy Belageri
 *
 */
public interface StateService {
	
	List<State> getStates(String stateName);

	List<Hotel> getHotels(Long stateId);

}
