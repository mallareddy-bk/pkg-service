/**
 * 
 */
package com.pkg.portal.service.impl.hotel;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.pkg.portal.model.hotel.Hotel;
import com.pkg.portal.model.location.State;
import com.pkg.portal.model.room.Room;
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

	@Override
	public Hotel getHotel(Long hotelId) {
		Optional<Hotel> optionalHotel = hotelRepository.findById(hotelId);
		Hotel hotel = optionalHotel.get();
		if (null != optionalHotel) {
			Set<Room> rooms = hotel.getRooms();
			if (!CollectionUtils.isEmpty(rooms)) {
				for (Room room: rooms) {
					room.getRoomCategories();
				}
			}
		}
		return hotel;
	}

}
