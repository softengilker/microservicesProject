/**
 * 
 */
package com.ilkerkonar.sideproject.usermanagement.api;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.ilkerkonar.sideproject.usermanagement.data.UserRepository;
import com.ilkerkonar.sideproject.usermanagement.model.User;

/**
 * UserManagementApi Test Class
 *
 * @author ilker konar
 * @version 1.0
 * @since Dec 30, 2017
 *
 */
@RunWith( MockitoJUnitRunner.class )
public class UserManagementApiTest {

	@Mock
	private UserRepository userRepository;

	private final static String DUMMY_USER1_FIRST_NAME = "fn1";

	private final static String DUMMY_USER1_LAST_NAME = "ln1";

	private final static String DUMMY_USER1_ID = "1";

	private final static String DUMMY_USER2_FIRST_NAME = "fn2";

	private final static String DUMMY_USER2_LAST_NAME = "ln2";

	private final static String DUMMY_USER2_ID = "2";

	private List< User > getDummyUserList1() {

		final User user1 = new User( DUMMY_USER1_FIRST_NAME, DUMMY_USER1_LAST_NAME );
		user1.setId( DUMMY_USER1_ID );

		final User user2 = new User( DUMMY_USER2_FIRST_NAME, DUMMY_USER2_LAST_NAME );
		user1.setId( DUMMY_USER2_ID );

		return Arrays.asList( user1, user2 );
	}

	private List< User > getDummyUserList2() {

		final User user1 = new User( DUMMY_USER1_FIRST_NAME, DUMMY_USER1_LAST_NAME );
		user1.setId( DUMMY_USER1_ID );

		return Arrays.asList( user1 );
	}

	private List< User > getDummyUserList3() {

		final User user1 = new User( DUMMY_USER2_FIRST_NAME, DUMMY_USER2_LAST_NAME );
		user1.setId( DUMMY_USER2_ID );

		return Arrays.asList( user1 );
	}

	@Test
	public void testGetUserByFirstNameAndLastName() {

		when( userRepository.findByFirstNameAndLastName( DUMMY_USER1_FIRST_NAME, DUMMY_USER1_LAST_NAME ) ).thenReturn( getDummyUserList2() );

		final IUserManagementApi userManagement = new UserManagementApi( userRepository );
		final List< User > returnList = userManagement.getUserByFirstNameAndLastName( DUMMY_USER1_FIRST_NAME, DUMMY_USER1_LAST_NAME );

		Assert.assertEquals( returnList.size(), 1 );
		Assert.assertEquals( returnList.get( 0 ).getFirstName(), DUMMY_USER1_FIRST_NAME );
		Assert.assertEquals( returnList.get( 0 ).getLastName(), DUMMY_USER1_LAST_NAME );

		verify( userRepository ).findByFirstNameAndLastName( DUMMY_USER1_FIRST_NAME, DUMMY_USER1_LAST_NAME );
	}

	@Test
	public void testGetUserByFirstName() {

		when( userRepository.findByFirstName( DUMMY_USER2_FIRST_NAME ) ).thenReturn( getDummyUserList3() );

		final IUserManagementApi userManagement = new UserManagementApi( userRepository );
		final List< User > returnList = userManagement.getUserByFirstNameAndLastName( DUMMY_USER2_FIRST_NAME, null );

		Assert.assertEquals( returnList.size(), 1 );
		Assert.assertEquals( returnList.get( 0 ).getFirstName(), DUMMY_USER2_FIRST_NAME );
		Assert.assertEquals( returnList.get( 0 ).getLastName(), DUMMY_USER2_LAST_NAME );

		final List< User > returnList2 = userManagement.getUserByFirstNameAndLastName( DUMMY_USER2_FIRST_NAME, "" );

		Assert.assertEquals( returnList2.size(), 1 );
		Assert.assertEquals( returnList2.get( 0 ).getFirstName(), DUMMY_USER2_FIRST_NAME );
		Assert.assertEquals( returnList2.get( 0 ).getLastName(), DUMMY_USER2_LAST_NAME );

		verify( userRepository, times( 2 ) ).findByFirstName( DUMMY_USER2_FIRST_NAME );
	}

	@Test
	public void testGetUserByLastName() {

		when( userRepository.findByLastName( DUMMY_USER2_LAST_NAME ) ).thenReturn( getDummyUserList3() );

		final IUserManagementApi userManagement = new UserManagementApi( userRepository );
		final List< User > returnList = userManagement.getUserByFirstNameAndLastName( "", DUMMY_USER2_LAST_NAME );

		Assert.assertEquals( returnList.size(), 1 );
		Assert.assertEquals( returnList.get( 0 ).getFirstName(), DUMMY_USER2_FIRST_NAME );
		Assert.assertEquals( returnList.get( 0 ).getLastName(), DUMMY_USER2_LAST_NAME );

		final List< User > returnList2 = userManagement.getUserByFirstNameAndLastName( null, DUMMY_USER2_LAST_NAME );

		Assert.assertEquals( returnList2.size(), 1 );
		Assert.assertEquals( returnList2.get( 0 ).getFirstName(), DUMMY_USER2_FIRST_NAME );
		Assert.assertEquals( returnList2.get( 0 ).getLastName(), DUMMY_USER2_LAST_NAME );

		verify( userRepository, times( 2 ) ).findByLastName( DUMMY_USER2_LAST_NAME );
	}

	@Test
	public void testGetAllUsers() {

		when( userRepository.findAll() ).thenReturn( getDummyUserList1() );

		final IUserManagementApi userManagement = new UserManagementApi( userRepository );
		final List< User > returnList = userManagement.getUserByFirstNameAndLastName( "", null );

		Assert.assertEquals( returnList.size(), 2 );

		verify( userRepository ).findAll();
	}

	@Test
	public void testSaveUsers() {

		when( userRepository.save( getDummyUserList1() ) ).thenReturn( getDummyUserList1() );

		final IUserManagementApi userManagement = new UserManagementApi( userRepository );
		final List< User > returnList = userManagement.saveUsers( getDummyUserList1() );

		Assert.assertEquals( returnList.size(), 2 );

		verify( userRepository ).save( getDummyUserList1() );
	}
}
