/**
 * 
 */
package com.pkg.portal.service.impl.state;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkg.portal.model.hotel.Hotel;
import com.pkg.portal.model.location.State;
import com.pkg.portal.model.room.Room;
import com.pkg.portal.repository.state.StateRepository;
import com.pkg.portal.service.state.StateService;

/**
 * @author Mallareddy Belageri
 *
 */
@Service
public class StateServiceImpl implements StateService{

	@Autowired
	StateRepository stateRepository;
	
	@Override
	public List<State> getStates(String countryName) {
		List<State> states = (List<State>) stateRepository.findAll();
		for (State state: states) {
			Set<Hotel> hotels = (Set<Hotel>) state.getHotels();
			for (Hotel hotel: hotels) {
				Set<Room> rooms = (Set<Room>) hotel.getRooms();
				for (Room room: rooms) {
					room.getRoomCategories();
				}
			}
		}
		return states;
	}

	@Override
	public List<Hotel> getHotels(Long stateId) {
		return stateRepository.findByHotels(stateId);
	}

}
