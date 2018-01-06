
package com.ilkerkonar.sideproject.usermanagement.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * User model data class
 *
 * @author ilker konar
 * @version 1.0
 * @since Dec 30, 2017
 *
 */
@Document
public class User {

	@Id
	private String id;

	private String firstName;

	private String lastName;

	public User() {

	}

	public User( final String firstName, final String lastName ) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getId() {
		return id;
	}

	public void setId( final String id ) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName( final String firstName ) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName( final String lastName ) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "[User, id : " + getId() + ", name : " + getFirstName() + ", lastName : " + getLastName() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ( firstName == null ? 0 : firstName.hashCode() );
		result = prime * result + ( lastName == null ? 0 : lastName.hashCode() );
		return result;
	}

	@Override
	public boolean equals( final Object obj ) {

		if ( obj == null ) {
			return false;
		}

		final User other = ( User ) obj;

		if ( firstName == null ) {
			if ( other.firstName != null ) {
				return false;
			}
		} else if ( !firstName.equals( other.firstName ) ) {
			return false;
		}
		if ( lastName == null ) {
			if ( other.lastName != null ) {
				return false;
			}
		} else if ( !lastName.equals( other.lastName ) ) {
			return false;
		}

		return true;
	}

}
