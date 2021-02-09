/**
 * 
 */
package com.pkg.portal.repository.hotel;

import org.springframework.data.repository.CrudRepository;

import com.pkg.portal.model.hotel.Hotel;
import com.pkg.portal.model.location.State;

/**
 * @author Mallareddy Belageri
 *
 */
public interface HotelRepository extends CrudRepository<Hotel, Long> {
	//List<Hotel> findByEmpId(String empId);
}
