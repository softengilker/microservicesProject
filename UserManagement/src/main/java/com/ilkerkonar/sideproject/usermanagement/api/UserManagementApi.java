
package com.ilkerkonar.sideproject.usermanagement.api;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ilkerkonar.sideproject.usermanagement.data.UserRepository;
import com.ilkerkonar.sideproject.usermanagement.model.User;

/**
 * API Main Class including the Restful Api Method implementations.
 * 
 * @author ilker konar
 * @version 1.0
 * @since Dec 30, 2017
 *
 */
@RestController
public class UserManagementApi implements IUserManagementApi {

	private final UserRepository userRepository;

	@Autowired
	public UserManagementApi( final UserRepository userRepository ) {
		this.userRepository = userRepository;
	}

	@RequestMapping( method = RequestMethod.GET, value = "/user" )
	@Override
	public List< User > getUserByFirstNameAndLastName( @RequestParam( value = "firstName" ) final String firstName,
			@RequestParam( value = "lastName" ) final String lastName ) {

		List< User > returnValue = null;

		if ( !StringUtils.isEmpty( firstName ) && !StringUtils.isEmpty( lastName ) ) {

			returnValue = userRepository.findByFirstNameAndLastName( firstName, lastName );

		} else if ( !StringUtils.isEmpty( firstName ) && StringUtils.isEmpty( lastName ) ) {

			returnValue = userRepository.findByFirstName( firstName );

		} else if ( StringUtils.isEmpty( firstName ) && !StringUtils.isEmpty( lastName ) ) {

			returnValue = userRepository.findByLastName( lastName );

		} else {

			returnValue = userRepository.findAll();
		}

		return returnValue;
	}

	@Override
	@RequestMapping( method = RequestMethod.POST, value = "/userSave" )
	public List< User > saveUsers( @RequestBody final List< User > userList ) {
		return userRepository.save( userList );
	}

}
