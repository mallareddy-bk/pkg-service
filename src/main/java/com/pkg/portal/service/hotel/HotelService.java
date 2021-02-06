/**
 * 
 */
package com.pkg.portal.service.hotel;

import java.util.List;

import com.pkg.portal.model.hotel.Hotel;

/**
 * @author Mallareddy Belageri
 *
 */
public interface HotelService {
	
	List<Hotel> getHotels(Long stateId);

}
