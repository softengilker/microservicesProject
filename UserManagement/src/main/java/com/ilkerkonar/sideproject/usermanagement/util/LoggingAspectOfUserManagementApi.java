package com.ilkerkonar.sideproject.usermanagement.util;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ilkerkonar.sideproject.usermanagement.api.IUserManagementApi;
import com.ilkerkonar.sideproject.usermanagement.model.User;

@Aspect
@Component
public class LoggingAspectOfUserManagementApi {

	private final static Logger LOGGER = LoggerFactory.getLogger( IUserManagementApi.class );

	@SuppressWarnings( "unchecked" )
	@AfterReturning( pointcut = "execution(* com.ilkerkonar.sideproject.usermanagement.api.IUserManagementApi.getUserByFirstNameAndLastName(..))", returning = "result" )
	public void logAfterGetUserByFirstNameAndLastNameReturning( final JoinPoint joinPoint, final Object result ) {

		LOGGER.info(
				"Invoking 'getUserByFirstNameAndLastName' restful method. Returning the user list based on the first name : {}, and last name : {}, The list : {}",
				new Object[] { joinPoint.getArgs()[0], joinPoint.getArgs()[1], printUserListContent( ( List< User > ) result ) } );
	}

	@SuppressWarnings( "unchecked" )
	@AfterReturning( pointcut = "execution(* com.ilkerkonar.sideproject.usermanagement.api.IUserManagementApi.saveUser(..))", returning = "result" )
	public void logAfterSaveUserReturning( final JoinPoint joinPoint, final Object result ) {

		LOGGER.info( "Invoking 'saveUser' restful method. The parameter list: {}",
				new Object[] { printUserListContent( ( List< User > ) joinPoint.getArgs()[0] ) } );
	}

	private String printUserListContent( final List< User > theList ) {

		final StringBuffer sb = new StringBuffer();

		theList.forEach( a -> sb.append( a ) );

		return sb.toString();
	}
}
