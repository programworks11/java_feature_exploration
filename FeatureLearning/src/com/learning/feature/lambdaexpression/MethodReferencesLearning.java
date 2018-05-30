package com.learning.feature.lambdaexpression;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.function.Supplier;

import com.learning.util.SampleTypeUtil;

/**
 * This class is used for demonstrating lambda/method references using Arrays.sort(T[], Comparator<T>) 
 *
 */
public class MethodReferencesLearning {
	
	public static void main(String args[])
	{
		lambdaCompareAgeUsingLocalTime(SampleTypeUtil.getPersonArray());
		lambdaCompareAgeUsingInternalMethod(SampleTypeUtil.getPersonArray());
		lambdaCompareAgeUsingStaticMethodReference(SampleTypeUtil.getPersonArray());
		lambdaCompareAgeUsingInstanceMethodReference();
		lambdaCompareAgeUsingParticularInstanceMethodReference(SampleTypeUtil.getPersonArray());
		trasferElements(SampleTypeUtil.getPersonList(), HashSet::new);
	}
	/**
	 * Comparator instance passed using lambda expression
	 * @param persons
	 */
	private static void lambdaCompareAgeUsingLocalTime(Person[] persons)
	{
		Arrays.sort(persons, (Person a, Person b) -> {
			return a.getBirthDay().compareTo(b.getBirthDay());
		});
	}
	/**
	 * Same as above, difference is using different method 
	 * @param persons
	 */
	private static void lambdaCompareAgeUsingInternalMethod(Person[] persons)
	{
		Arrays.sort(persons, (a,b) -> Person.compareByAge(a, b));
	}
	/**
	 * static method reference
	 * @param persons
	 */
	private static void lambdaCompareAgeUsingStaticMethodReference(Person[] persons)
	{
		Arrays.sort(persons, Person::compareByAge);
	}
	
	/**
	 * instance method reference
	 * @param persons
	 */
	private static void lambdaCompareAgeUsingInstanceMethodReference()
	{
		String[] stringArray = {"zebra","apple","dog"};
		Arrays.sort(stringArray, String::compareToIgnoreCase);
	}
	
	/**
	 * particular instance's method reference
	 * @param persons
	 */
	private static void lambdaCompareAgeUsingParticularInstanceMethodReference(Person[] persons)
	{
		MethodReferencesLearning methodReferencesLearning = new MethodReferencesLearning();
		ComparisonProvider comparisonProvider = methodReferencesLearning.new ComparisonProvider();
		Arrays.sort(persons, comparisonProvider::compareByAge);
	}
	
	public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>> DEST 
	trasferElements(SOURCE sourceCollection, Supplier<DEST> collectionFactory) {
		DEST dest = collectionFactory.get();
		for(T t: sourceCollection)
		{
			dest.add(t);
		}
		return dest;
	}
	
	private class ComparisonProvider {
		public int compareByAge(Person a, Person b) {
			return a.getBirthDay().compareTo(b.getBirthDay());
		}
	}
}
