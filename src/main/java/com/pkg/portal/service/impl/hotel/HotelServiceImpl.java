/**
 * 
 */
package com.pkg.portal.service.impl.hotel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkg.portal.model.hotel.Hotel;
import com.pkg.portal.repository.hotel.HotelRepository;
import com.pkg.portal.service.hotel.HotelService;

/**
 * @author Mallareddy Belageri
 *
 */
@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	HotelRepository hotelRepository;
	
	@Override
	public List<Hotel> getHotels(Long stateId) {
		return null;
	}

}
