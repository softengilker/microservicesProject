package com.ilkerkonar.sideproject.usermanagement.api;

import java.util.List;

import com.ilkerkonar.sideproject.usermanagement.model.User;

public interface IUserManagementApi {

	List< User > getUserByFirstNameAndLastName( final String firstName, final String lastName );

	void saveUser( final List< User > userList );
}
