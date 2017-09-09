package com.ilkerkonar.sideproject.usermanagement.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ilkerkonar.sideproject.usermanagement.data.UserRepository;
import com.ilkerkonar.sideproject.usermanagement.model.User;

@RestController
public class UserManagementApi {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/user")
	public List<User> getUserByFirstName( @RequestParam( value="firstName" ) final String firstName ) {
		return userRepository.findByFirstName( firstName );
	}
}
