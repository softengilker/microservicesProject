
package com.ilkerkonar.algorithms.util;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * @author ilker
 * 
 * Includes some util methods and lambdas.
 */
public class Printing {

	private final Consumer< Object[] > printTheArray = ( arrayInput ) -> {

		System.out.println( "Array Printing : " );
		Arrays.asList( arrayInput )
			.forEach( ( item ) -> System.out
				.print( item + ", " ) );
		System.out.println( "" );
	};

	public Consumer< Object[] > getArrayPrintingImplementation() {
		return printTheArray;
	}
}
