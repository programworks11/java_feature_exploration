package com.learning.feature.functionalinterfaces;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import com.learning.util.SampleTypeUtil;

public class FunctionalIntefacesLearning {
	
	public static void main(String[] args) throws Exception{
		demoFunctionInterfaceUsage();
		demoBiFunctionInterfaceUsage();
		demoSupplierFunctionInterfaceUsage();
		demoConsumerFunctionInterfaceUsage();
		demoPredicateFunctionInterfaceUsage();
		demoOperatorsFunctionInterfaceUsage();
	}

	public static void demoFunctionInterfaceUsage() {
		Function<Integer, String> intToString = Object::toString;
		Function<String, String> quote = s -> "'"+ s +"'";
		//compose is default method from Function interface that can be used to chain functions as shown below
		System.out.println("Function interface apply and compose usage" +quote.compose(intToString).apply(5));
		Map<String, Integer> stringLengthMap = new HashMap<String, Integer>();
		//Map.computeIfAbsent uses Function interface as one of the parameter
		System.out.println("Function interface - map.computeIfAbsent key:: "+
				stringLengthMap.computeIfAbsent("Hello..!!!", String::length));
		System.out.println("Function interface - map.computeIfAbsent value:: "+ 
				stringLengthMap.get("Hello..!!!"));
	}
	
	public static void demoBiFunctionInterfaceUsage() {
		BiFunction<Integer, Integer, String> integerToString = (a,b) -> a+""+b;
		System.out.println("BiFunction interface - "+integerToString.apply(5, 8));
		//Map.replaceAll uses BiFunction interface
		Map<Integer, Integer> employees = new HashMap<>();
		employees.put(1, 40000);
		employees.put(2, 20000);
		employees.put(3, 35000);
		employees.put(4, 25000);
		employees.put(5, 15000);
		System.out.println("Before applying BiFunction");
		employees.forEach((t,u) -> System.out.println("employee id "+t+" salary "+u));
		employees.replaceAll((t,u) -> t<4 && u<35000?40000:u );
		System.out.println("After applying BiFunction");
		employees.forEach((t,u) -> System.out.println("employee id "+t+" salary "+u));
	}
	
	public static void demoSupplierFunctionInterfaceUsage() throws Exception {
		int[] lastGeneratedNumberArray = {0};
		System.out.println("Generate odd number using Supplier functional interface");
		Stream<Integer> oddNumberStream = Stream.generate(()-> {
			int lastGeneratedNumber = lastGeneratedNumberArray[0];
			while(lastGeneratedNumber%2 ==0)
			{
				++lastGeneratedNumber;
			}
			lastGeneratedNumberArray[0] = lastGeneratedNumber+1;
			return lastGeneratedNumber;
		}).limit(10);
		oddNumberStream.forEach(System.out::println);
		oddNumberStream.close();
		Supplier<LocalTime> supplierFunction = LocalTime::now;
		System.out.println("LocalTime after initializing Supplier "+LocalTime.now());
		Thread.sleep(1000L);
		System.out.println("Supplier LocalTime after sleep 1 sec - demo of lazy generation");
		System.out.println(supplierFunction.get());
	}
	
	public static void demoConsumerFunctionInterfaceUsage() throws Exception {
		System.out.println("Consumer interface");
		Consumer<Object> objConsumer = System.out::println;
		objConsumer.accept(SampleTypeUtil.getPersonList());
		SampleTypeUtil.getSampleMap().forEach((k, l)-> System.out.println("key "+k+" value"+l));
	}
	
	public static void demoPredicateFunctionInterfaceUsage() {
		Predicate<Integer> intPredicate = x -> x<10;
		System.out.println("Predicate usage, number 5 less than 10 :: "+ intPredicate.test(5));
		Predicate<Integer> evenPredicate = x -> x%2==0;
		System.out.println("Predicate usage, number 5 is even :: "+evenPredicate.test(5));
		Predicate<Integer> intAndEvenPredicate = intPredicate.and(evenPredicate);
		System.out.println("Predicate usage, number 5 less than 10 and even :: "+intAndEvenPredicate.test(5));
		Predicate<Integer> intOrEvenPredicate = intPredicate.or(evenPredicate);
		System.out.println("Predicate usage, number 5 less than 10 or even :: "+intOrEvenPredicate.test(5));
	}
	
	public static void demoOperatorsFunctionInterfaceUsage() {
		System.out.println("Unary operator");
		UnaryOperator<Integer> intUnaryOperator = x -> x+10;
		System.out.println(intUnaryOperator.apply(5));
		List<String> names = Arrays.asList("bob","alan","charles");
		names.replaceAll(String::toUpperCase);
		names.forEach(System.out::println);
		List<Integer> scores = Arrays.asList(10, 99, 55, 77);
		System.out.println("Binary operator - sum of scores");
		System.out.println(scores.stream().reduce(0, (s1,n)-> s1+n));
		
	}
}