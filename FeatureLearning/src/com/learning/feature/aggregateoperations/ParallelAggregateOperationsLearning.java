package com.learning.feature.aggregateoperations;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import com.learning.util.Person;
import com.learning.util.SampleTypeUtil;

public class ParallelAggregateOperationsLearning {

	public static void main(String args[]) {
		List<Person> persons = SampleTypeUtil.getPersonList();
		System.out.println("Average age :: "+calculateAverageAgeOfAllMaleMembers(persons));
		parallelStreamOperations(persons);
	}
	
	public static double calculateAverageAgeOfAllMaleMembers(List<Person> persons)
	{
		return persons.parallelStream().filter(person -> person.getGender() == Person.Sex.MALE).mapToInt(Person::getAge).average().getAsDouble();
	}
	
	public static ConcurrentMap<Person.Sex, List<Person>> retrievePersonListGroupedByGender(List<Person> persons)
	{
		return persons.parallelStream().collect(Collectors.groupingByConcurrent(Person::getGender));
	}
	
	public static void parallelStreamOperations(List<Person> persons)
	{
		Comparator<Person> personComparator = Person::compareByAge;
		System.out.println("Printing elements of stream in serial");
		persons.stream().forEach(System.out::println);
		persons.sort(personComparator);
		System.out.println("*************");
		System.out.println("Printing elements of stream in serial after sorting");
		persons.stream().forEach(System.out::println);
		System.out.println("*************");
		System.out.println("Printing elements of stream in parallel which are in sorted order");
		persons.parallelStream().forEach(System.out::println);
		System.out.println("*************");
		System.out.println("Printing again elements of stream in parallel which are in sorted order");
		persons.parallelStream().forEach(System.out::println);
		System.out.println("*************");
		System.out.println("Printing elements of stream in parallel using forEachOrdered.. which is not a right combination");
		persons.parallelStream().forEachOrdered(System.out::println);
	}
}
