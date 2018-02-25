package com.ilkerkonar.sideproject.usermanagement.api;

import java.util.List;

import com.ilkerkonar.sideproject.usermanagement.model.User;

/**
 * API Main Interface including the Restful Api Methods.
 * 
 * @author ilker konar
 * @version 1.0
 * @since Dec 30, 2017
 */
public interface IUserManagementApi {

	/**
	 * GET Restful Method <br>
	 * Searches for the users in the database ( configured Mongo DB) based on the
	 * parameters and returns the list of the found users. If the parameters are
	 * blank, it retrieves the whole users in the database.
	 * 
	 * @param firstName
	 *           {@link String } The first name parameter. Leave it blank if you
	 *           want to serach by the last name only.
	 * @param lastName
	 *           {@link String } The last name parameter. Leave it blank if you
	 *           want to serach by the last name only.
	 * 
	 * @return The found User list.
	 */
	List< User > getUserByFirstNameAndLastName( final String firstName, final String lastName );

	/**
	 * POST Restful Method <br>
	 * Saves the users into the database ( configured Mongo DB)
	 * 
	 * @param userList
	 *           The User list to be saved into the database.
	 * @return The saved instances list.
	 */
	List< User > saveUsers( final List< User > userList );
}
