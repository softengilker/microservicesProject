/**
 * 
 */

package com.ilkerkonar.algorithms.java8lambdas;

/**
 * Definition
 *
 * @author ilker konar
 * @version 1.0
 * @since Feb 17, 2018
 *
 */
public class Person {

	private final String	name;

	private final Integer	age;

	private final Gender	gender;

	public Person( final String name, final Integer age, final Gender gender ) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public Gender getGender() {
		return gender;
	}
}
