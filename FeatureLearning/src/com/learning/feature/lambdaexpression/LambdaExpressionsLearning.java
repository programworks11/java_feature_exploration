package com.learning.feature.lambdaexpression;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import com.learning.util.Person;
import com.learning.util.PersonSearchInterface;
import com.learning.util.SampleTypeUtil;

public class LambdaExpressionsLearning {
	
	public static void main(String[] args) {
		Map<Integer, String> sampleMap = SampleTypeUtil.getSampleMap();
		lambdaBiConsumer(sampleMap);
		lambdaBiFunction(sampleMap);
		lambdaFilterPersonsListUsingCustomFunctionalInterface(SampleTypeUtil.getPersonList(), person -> {
			return person.age >9;
		});
		lambdaFilterPersonsListUsingJavaFunctionalInterfaces(SampleTypeUtil.getPersonList(), person -> {
			return person.age >9;
		});
		lambdaFilterPersonsListUsingMultipleJFI(SampleTypeUtil.getPersonList(), person -> person.age<9, 
				emailAddress ->System.out.println(emailAddress),  person -> person.getEmailAddress());
		lambdaFilterUsingMultipleJFI(SampleTypeUtil.getPersonList(), person -> person.age<9, 
				emailAddress ->System.out.println(emailAddress),  person -> person.getEmailAddress());
		SampleTypeUtil.getPersonList().stream().filter(person -> person.age<9).map(person->person.getEmailAddress()).forEach(emailAddress -> System.out.println(emailAddress));
	}
	
	/**
	 * Example of lambda expression for interface BiConsumer<T,U>
	 * @param sampleMap
	 */
	private static void lambdaBiConsumer(Map<Integer, String> sampleMap)
	{
		sampleMap.forEach((key, value) -> {
			System.out.println("Key :: "+key + " Value :: "+value);
		});
	}
	/**
	 * Example of lambda expression for interface BiFunction<T,U>
	 * @param sampleMap
	 */
	private static void lambdaBiFunction(Map<Integer, String> sampleMap)
	{
		String result = sampleMap.computeIfPresent(1, (key, value) -> {
			return key+" :: "+value;
		});
		if(null != result)
		{
			System.out.println("result :: "+result);
		}
	}
	/**
	 * Example of lambda expression for custom interface
	 * @param persons
	 * @param personSearchInterface
	 */
	private static void lambdaFilterPersonsListUsingCustomFunctionalInterface(List<Person> persons, PersonSearchInterface personSearchInterface) 
	{
		for(Person person: persons)
		{
			if(personSearchInterface.filter(person)) {
				System.out.println("Person name :: "+ person.name);
			}
		}
	}
	
	/**
	 * Example of lambda expression for java.lang.functional interface
	 * @param persons
	 * @param personSearchInterface
	 */
	private static void lambdaFilterPersonsListUsingJavaFunctionalInterfaces(List<Person> persons, Predicate<Person> personPredicate) 
	{
		for(Person person: persons)
		{
			if(personPredicate.test(person)) {
				System.out.println("Person name :: "+ person.name);
			}
		}
	}
	
	/**
	 * Example of lambda expression using Functional, Predicate and Consumer
	 * @param persons
	 * @param selectionPredicate
	 * @param printConsumer
	 * @param emailFunction
	 */
	private static void lambdaFilterPersonsListUsingMultipleJFI(List<Person> persons, Predicate<Person> selectionPredicate, 
			Consumer<String> printConsumer, Function<Person, String> emailFunction)
	{
		for(Person person: persons)
		{
			if(selectionPredicate.test(person))
			{
				String emailAddress = emailFunction.apply(person);
				printConsumer.accept(emailAddress);
			}
		}
	}
	
	/**
	 * Example of lambda expression using Functional, Predicate and Consumer with Generics. Same as above function except Generics are used.
	 * @param iterable
	 * @param selectionPredicate
	 * @param consumer
	 * @param function
	 */
	private static <X, Y> void lambdaFilterUsingMultipleJFI(Iterable<X> iterable, Predicate<X> selectionPredicate, 
			Consumer<Y> consumer, Function<X, Y> function)
	{
		for(X x: iterable)
		{
			if(selectionPredicate.test(x))
			{
				Y outputString = function.apply(x);
				consumer.accept(outputString);
			}
		}
	}	
}