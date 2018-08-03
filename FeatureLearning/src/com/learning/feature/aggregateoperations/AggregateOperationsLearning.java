package com.learning.feature.aggregateoperations;

import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;

import com.learning.util.Person;
import com.learning.util.SampleTypeUtil;

public class AggregateOperationsLearning {
	public static void main(String args[]) 
	{
		List<Person> persons = SampleTypeUtil.getPersonList();
		System.out.println("Average of persons whose age is less than 9 "+ calculateAverageAge(persons, 9));
		System.out.println("Sum of ages of all persons in list "+calculateSumOfAge(persons));
		System.out.println("Average of male persons in list"+calculateAverageMaleAge(persons));
		Map<Person.Sex, List<Person>> genderPersonsMap = retrieveGenderList(persons);
		System.out.println("Male gender person list");
		genderPersonsMap.get(Person.Sex.MALE).stream().forEach(System.out::println);
		System.out.println("Female gender person list");
		genderPersonsMap.get(Person.Sex.FEMALE).stream().forEach(System.out::println);

		Map<Person.Sex, Integer> totalAgeGroupedBySex = retrieveTotalAgeOfPersonsGroupedByGender(persons);
		System.out.println("Total age of male persons "+totalAgeGroupedBySex.get(Person.Sex.MALE));
		System.out.println("Total age of female persons "+totalAgeGroupedBySex.get(Person.Sex.FEMALE));
		Map<Person.Sex, Double> avgAgeGroupedBySex = retrieveAverageAgeOfPersonsGroupedByGender(persons);
		System.out.println("Average age of male persons "+avgAgeGroupedBySex.get(Person.Sex.MALE));
		System.out.println("Average age of female persons "+avgAgeGroupedBySex.get(Person.Sex.FEMALE));
		
		Map<Person.Sex, List<String>> genderPersonsNames = retrievePersonNamesByGenderGrouping(persons);
		System.out.println("Male gender person name list");
		genderPersonsNames.get(Person.Sex.MALE).stream().forEach(System.out::println);
		System.out.println("Female gender person name list");
		genderPersonsNames.get(Person.Sex.FEMALE).stream().forEach(System.out::println);
	}

	/**
	 * this method uses reduce(identity, accumulator) method
	 * @param persons
	 * @return
	 */
	public static int calculateSumOfAge(List<Person> persons)
	{
		return persons.stream().map(Person::getAge).reduce(0, (a,b) -> a+b);
	}
	
	
	public static double calculateAverageMaleAge(List<Person> persons)
	{
		Averager averagerContainer = 
				persons.stream().filter(person -> person.getGender() == Person.Sex.MALE)
				.map(Person::getAge)
				.collect(Averager::new,	Averager::accept, Averager::combine);
		return averagerContainer.average();
	}
	
	public static Map<Person.Sex, List<Person>> retrieveGenderList(List<Person> persons)
	{
		Map<Person.Sex, List<Person>> personsListByGender = persons.stream().collect(Collectors.groupingBy(Person::getGender));
		return personsListByGender;
	}
	
	public static Map<Person.Sex, List<String>> retrievePersonNamesByGenderGrouping(List<Person> persons)
	{
		Map<Person.Sex, List<String>> personNamesGroupedByGender 
			= persons.stream().collect(Collectors.groupingBy(Person::getGender, Collectors.mapping(Person::getName, Collectors.toList())));
		return personNamesGroupedByGender;
	}
	
	public static Map<Person.Sex, Integer> retrieveTotalAgeOfPersonsGroupedByGender(List<Person> persons)
	{
		Map<Person.Sex, Integer> totalAgeOfPersonsGroupedByGender 
			= persons.stream().collect(Collectors.groupingBy(Person::getGender, Collectors.reducing(0, Person::getAge, Integer::sum)));
		return totalAgeOfPersonsGroupedByGender;
	}
	
	public static Map<Person.Sex, Double> retrieveAverageAgeOfPersonsGroupedByGender(List<Person> persons)
	{
		Map<Person.Sex, Double> avgAgeOfPersonsGroupedByGender 
			= persons.stream().collect(Collectors.groupingBy(Person::getGender, Collectors.averagingDouble(Person::getAge)));
		return avgAgeOfPersonsGroupedByGender;
	}
	
	/**
	 * uses pipeline, streams
	 * @param persons
	 * @param ageLimit
	 * @return
	 */
	public static Double calculateAverageAge(List<Person> persons, int ageLimit)
	{
		OptionalDouble averageAge = persons.stream().filter(person -> person.getAge()<ageLimit).mapToInt(Person::getAge).average();
		//pipeline is made of source(persons), intermediate operations(stream,filter,mapToInt) and terminator(average) aka reducers
		return averageAge.getAsDouble();
	}	
	
	static class Averager implements IntConsumer
	{
		Averager(){
			super();
		}
		int sum = 0;
		int count = 0;

		@Override
		public void accept(int currentValue) {
			sum += currentValue;
			count++;
		}
		
		public void combine(Averager other) {
			this.sum += other.sum;
			this.count += other.count;
		}
		
		public double average() {
			return count > 0 ? ((double)sum)/count : 0;
		}
	}
}
