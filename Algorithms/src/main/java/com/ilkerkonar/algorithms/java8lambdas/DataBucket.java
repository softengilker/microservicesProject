/**
 * 
 */

package com.ilkerkonar.algorithms.java8lambdas;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition
 *
 * @author ilker konar
 * @version 1.0
 * @since Feb 17, 2018
 *
 */
public class DataBucket {

	protected List< Person > getPersonList() {

		final List< Person > personList = new ArrayList<>();

		personList.add( new Person( "lila", 9, Gender.FEMALE ) );
		personList.add( new Person( "lily", 30, Gender.FEMALE ) );
		personList.add( new Person( "robert", 18, Gender.MALE ) );
		personList.add( new Person( "wendy", 43, Gender.FEMALE ) );
		personList.add( new Person( "michael", 37, Gender.MALE ) );
		personList.add( new Person( "arthur", 6, Gender.MALE ) );
		personList.add( new Person( "lucas", 15, Gender.MALE ) );
		personList.add( new Person( "madison", 29, Gender.FEMALE ) );
		personList.add( new Person( "venessa", 82, Gender.FEMALE ) );
		personList.add( new Person( "taylor", 58, Gender.MALE ) );
		personList.add( new Person( "lee", 42, Gender.MALE ) );
		personList.add( new Person( "mariah", 21, Gender.FEMALE ) );

		return personList;
	}
}
