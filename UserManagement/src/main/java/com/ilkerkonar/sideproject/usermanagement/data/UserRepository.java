
package com.ilkerkonar.sideproject.usermanagement.data;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ilkerkonar.sideproject.usermanagement.model.User;

public interface UserRepository extends MongoRepository< User, Integer > {

}
