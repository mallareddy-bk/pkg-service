/**
 * 
 */
package com.pkg.portal.repository.hotel;

import org.springframework.data.repository.CrudRepository;

import com.pkg.portal.model.location.State;

/**
 * @author Mallareddy Belageri
 *
 */
public interface HotelRepository extends CrudRepository<State, Long> {
	//List<Hotel> findByEmpId(String empId);
}
