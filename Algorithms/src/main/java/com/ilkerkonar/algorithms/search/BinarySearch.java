
package com.ilkerkonar.algorithms.search;

import java.util.Arrays;

public class BinarySearch {

	private static final int[]	numbers			= { 15, 2, 26, 98, 78, 145, 28, 90, 34, 712, 85 };

	private static final int	searchingNumber	= 145;

	public static void main( final String[] args ) {

		System.out.println(
			"The number { " + searchingNumber + " } is " + ( binarySearch() ? "" : "not " ) + "found in the array." );
	}

	private static boolean binarySearch() {

		Arrays.sort( numbers );

		int lowestIndex = 0;
		int highestIndex = numbers.length - 1;

		while ( lowestIndex <= highestIndex ) {
			final int middleIndex = lowestIndex + ( highestIndex - lowestIndex ) / 2;

			if ( searchingNumber < numbers[ middleIndex ] ) {
				highestIndex = middleIndex - 1;
			} else if ( searchingNumber > numbers[ middleIndex ] ) {
				lowestIndex = middleIndex + 1;
			} else {
				return true;
			}
		}

		return false;
	}
}
