/**
 * 
 */
package com.pkg.portal.controllers.state;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pkg.portal.model.location.State;
import com.pkg.portal.service.state.StateService;

/**
 * @author Mallareddy Belageri
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({ "/timesheet" })
public class StateController {
	
	@Autowired
	StateService stateService;
	
	@PostMapping ("/states")
	public List<State> getStates(@RequestBody String countryName) throws Exception {
		List<State> stateList = stateService.getStates(countryName);
		if (!CollectionUtils.isEmpty(stateList)) {
			return stateList;
		} else {
			throw new Exception("Invalid State Name.");
		}
	}
}
