
package com.ilkerkonar.algorithms.numbers;

import java.util.Scanner;

/**
 * @author ilker
 * 
 * Test for if the number is prime
 */
public class PrimeTesting {

	public static void main( final String[] args ) {

		System.out.println( "Please input the number : " );

		final Scanner takeInput = new Scanner( System.in );
		final int number = takeInput.nextInt();
		takeInput.close();

		System.out.printf( "The number %d is %s a prime number", number, isPrime( number ) ? "" : "not" );
	}

	private static boolean isPrime( final Integer number ) {

		if ( number < 2 ) {
			return false;
		}

		for ( int i = 2; i * i <= number; i++ ) {
			if ( number % i == 0 ) {
				return false;
			}
		}

		return true;
	}
}
