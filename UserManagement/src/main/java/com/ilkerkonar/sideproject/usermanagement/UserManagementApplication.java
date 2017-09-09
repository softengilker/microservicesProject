
package com.ilkerkonar.sideproject.usermanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ilkerkonar.sideproject.usermanagement.data.UserRepository;
import com.ilkerkonar.sideproject.usermanagement.model.User;

@SpringBootApplication
public class UserManagementApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main( final String[] args ) {
		SpringApplication.run( UserManagementApplication.class, args );
	}

	@Override
	public void run( final String... args ) throws Exception {

		System.out.println( "Starting data code" );

		// userRepository.save( new User( "ilker", "konar" ) );
	}
}
