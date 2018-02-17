/**
 *
 */

package com.ilkerkonar.algorithms.java8lambdas;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Definition
 *
 * @author ilker konar
 * @version 1.0
 * @since Feb 17, 2018
 *
 */
public class Execution {

	/**
	 * @param args
	 */
	public static void main( final String[] args ) {

		final DataBucket dataBucket = new DataBucket();

		final List< Person > personList = dataBucket.getPersonList();

		final Execution execution = new Execution();

		execution.executeListStreamMethods( personList );
	}

	private void executeListStreamMethods( final List< Person > personList ) {

		System.out.println( "Stream filter ->" );
		System.out.println( "Female individuals: " );
		personList.stream().filter( p -> p.getGender() == Gender.FEMALE ).forEach( System.out::println );

		System.out.println( "Stream toArray ->" );
		System.out.println( "Person ages array: " );
		final Integer[] personAgesArray = personList.stream().map( p -> p.getAge() ).toArray( Integer[]::new );
		System.out.println( "Array element count: " + personAgesArray.length );

		System.out.print( "Sum of the person ages in the list:" );
		System.out.println( personList.stream().collect( Collectors.summingInt( p -> p.getAge() ) ).toString() );

		System.out.print( "Average of the person ages in the list:" );
		System.out.println( personList.stream().collect( Collectors.averagingInt( p -> p.getAge() ) ).toString() );

		System.out.println( "Convert person list to person map with person name key:" );
		final Map< String, Person > personMapByName = personList.stream()
			.collect( Collectors.toMap( Person::getName, p -> p ) );
		personMapByName.forEach( ( a, b ) -> System.out.println( a + " : " + b ) );

		System.out.print( "Joining the person names:" );
		System.out.println( personList.stream().map( Person::getName ).collect( Collectors.joining( " " ) ) );

		System.out.print( "Male person count:" );
		System.out.println( personList.stream().filter( a -> a.getGender() == Gender.MALE )
			.collect( Collectors.counting() ).toString() );

		System.out.println( "Person age statistics:" );
		final IntSummaryStatistics ageStatistics = personList.stream()
			.collect( Collectors.summarizingInt( Person::getAge ) );
		System.out
			.println( "Average : " + ageStatistics.getAverage() + ", Count : " + ageStatistics.getCount() + ", Max : "
				+ ageStatistics.getMax() + ", Min : " + ageStatistics.getMin() + ", Sum : " + ageStatistics.getSum() );

		System.out.println( "Convert person list to map with gender key" );
		final Map< Gender, List< Person > > personSetByGender = personList.stream()
			.collect( Collectors.groupingBy( Person::getGender, Collectors.toList() ) );
		printPersonListByName( "Female list : ", personSetByGender.get( Gender.FEMALE ) );
		printPersonListByName( "Male list : ", personSetByGender.get( Gender.MALE ) );
	}

	private void printPersonListByName( final String title, final List< Person > personList ) {
		System.out.print(
			title + personList.stream().map( Person::getName ).collect( Collectors.joining( ", ", "", "\n" ) ) );
	}

}
