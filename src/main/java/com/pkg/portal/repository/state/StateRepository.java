/**
 * 
 */
package com.pkg.portal.repository.state;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pkg.portal.model.hotel.Hotel;
import com.pkg.portal.model.location.State;

/**
 * @author Mallareddy Belageri
 *
 */
public interface StateRepository extends CrudRepository<State, Long>{
	
	List<Hotel> findByHotels(Long stateId);

}
