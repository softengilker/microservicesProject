
package com.ilkerkonar.sideproject.usermanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.ilkerkonar.sideproject.usermanagement.data.UserRepository;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableAspectJAutoProxy( proxyTargetClass = true )
public class UserManagementApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main( final String[] args ) {
		SpringApplication.run( UserManagementApplication.class, args );
	}

	@Override
	public void run( final String... args ) throws Exception {

		System.out.println( "Starting data code" );

		// userRepository.save( new User( "ozge", "konar" ) );
		// userRepository.save( new User( "nehir ilge", "konar" ) );
	}
}
