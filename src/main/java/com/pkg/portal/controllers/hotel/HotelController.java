/**
 * 
 */
package com.pkg.portal.controllers.hotel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pkg.portal.model.hotel.Hotel;
import com.pkg.portal.model.location.State;
import com.pkg.portal.service.hotel.HotelService;
import com.pkg.portal.service.state.StateService;

/**
 * @author Mallareddy Belageri
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({ "/hotel" })
public class HotelController {
	
	@Autowired
	HotelService hotelService;
	
	@Autowired
	StateService stateService;
	
	@PostMapping ("/states")
	public List<Hotel> getHotels(@RequestBody State state) throws Exception {
		List<Hotel> hotelList = stateService.getHotels(state.getStateId());
		List<Hotel> hotelList1 = hotelService.getHotels(state.getStateId());
		if (!CollectionUtils.isEmpty(hotelList)) {
			return hotelList;
		} else {
			throw new Exception("Invalid State.");
		}
	}
}
