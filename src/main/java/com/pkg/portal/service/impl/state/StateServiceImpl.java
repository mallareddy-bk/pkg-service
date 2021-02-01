/**
 * 
 */
package com.pkg.portal.service.impl.state;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkg.portal.model.location.State;
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
		return (List<State>) stateRepository.findAll();
	}

}
