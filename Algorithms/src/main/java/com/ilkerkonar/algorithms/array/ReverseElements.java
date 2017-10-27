
package com.ilkerkonar.algorithms.array;

import java.util.function.Consumer;

import com.ilkerkonar.algorithms.util.Printing;

/**
 * @author ilker
 * 
 * Reverse the elements within an array
 */
public class ReverseElements {

	private static final Double data[] = { 1.5, 4.0, 9.5, 6.5, 8.7, 0.2 };

	public static void main( final String[] args ) {

		final Printing printingUtil = new Printing();
		final Consumer< Object[] > printDoubleArray = printingUtil.getArrayPrintingImplementation();

		printDoubleArray.accept( data );

		final int N = data.length;

		for ( int i = 0; i < N / 2; i++ ) {
			final double temp = data[ i ];
			data[ i ] = data[ N - 1 - i ];
			data[ N - i - 1 ] = temp;
		}

		printDoubleArray.accept( data );
	}
}
