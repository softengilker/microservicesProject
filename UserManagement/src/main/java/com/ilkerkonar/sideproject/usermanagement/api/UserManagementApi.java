
package com.ilkerkonar.sideproject.usermanagement.api;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ilkerkonar.sideproject.usermanagement.data.UserRepository;
import com.ilkerkonar.sideproject.usermanagement.model.User;

@RestController
public class UserManagementApi implements IUserManagementApi {

	private final static Logger LOGGER = LoggerFactory.getLogger( UserManagementApi.class );

	@Autowired
	private UserRepository userRepository;

	@RequestMapping( method = RequestMethod.GET, value = "/user" )
	@Override
	public List< User > getUserByFirstNameAndLastName( @RequestParam( value = "firstName" ) final String firstName,
			@RequestParam( value = "lastName" ) final String lastName ) {

		List< User > returnValue = null;
		final String loggerPrefix = "Invoking 'getUserByFirstNameAndLastName' restful method. Returning the";

		if ( !StringUtils.isEmpty( firstName ) && !StringUtils.isEmpty( lastName ) ) {

			returnValue = userRepository.findByFirstNameAndLastName( firstName, lastName );
			LOGGER.info( "{} user list based on the first name : {}, and last name : {}, The list : {}",
					new Object[] { loggerPrefix, firstName, lastName, printUserListContent( returnValue ) } );

		} else if ( !StringUtils.isEmpty( firstName ) && StringUtils.isEmpty( lastName ) ) {

			returnValue = userRepository.findByFirstName( firstName );
			LOGGER.info( "{} user list based on the first name : {}, The list : {}",
					new Object[] { loggerPrefix, firstName, printUserListContent( returnValue ) } );

		} else if ( StringUtils.isEmpty( firstName ) && !StringUtils.isEmpty( lastName ) ) {

			returnValue = userRepository.findByLastName( lastName );
			LOGGER.info( "{} user list based on the last name : {}, The list : {}",
					new Object[] { loggerPrefix, lastName, printUserListContent( returnValue ) } );

		} else {

			returnValue = new ArrayList< User >();
			LOGGER.info( "{} empty user list. No first name of last name has been specified", loggerPrefix );

		}

		return returnValue;
	}

	private String printUserListContent( final List< User > theList ) {

		final StringBuffer sb = new StringBuffer();

		theList.forEach( a -> sb.append( "[ firstName: " + a.getFirstName() + ", lastName: " + a.getLastName() + " ]; " ) );

		return sb.toString();
	}

}
