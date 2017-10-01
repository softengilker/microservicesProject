
package com.ilkerkonar.sideproject.usermanagement.data;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ilkerkonar.sideproject.usermanagement.model.User;

public interface UserRepository extends MongoRepository< User, String > {

	List< User > findByFirstName( final String firstName );

	List< User > findByLastName( final String lastName );

	List< User > findByFirstNameAndLastName( final String firstName, final String lastName );
}
