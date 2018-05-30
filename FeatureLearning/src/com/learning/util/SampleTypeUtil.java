package com.learning.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.learning.feature.lambdaexpression.Person;

public class SampleTypeUtil {

	public static Person[] getPersonArray() {
		Person[] persons = new Person[2];
		Person person1 = new Person();
		person1.birthDay = LocalDate.now();
		person1.name = "Jack";
		person1.age = 15;
		Person person2 = new Person();
		person2.birthDay = LocalDate.now().minusDays(2);
		person2.name = "Elon";
		person2.age = 10;
		persons[0] = person1;
		persons[1] = person2;
		return persons;
	}
	
	public static List<Person> getPersonList() {
		List<Person> persons = new ArrayList<>();
		Person person1 = new Person();
		person1.birthDay = LocalDate.now();
		person1.name = "Jack";
		person1.age = 10;
		person1.emailAddress = "jack_ma@alibaba.com";
		Person person2 = new Person();
		person2.birthDay = LocalDate.now().minusDays(2);
		person2.name = "Elon";	
		person2.age = 8;
		person2.emailAddress = "elon_musk@tesla.com";
		Person person3 = new Person();
		person3.birthDay = LocalDate.now().minusDays(3);
		person3.name = "Warren";	
		person3.age = 8;
		person3.emailAddress = "warren_buffet@bhathaway.com";
		persons.add(person1);
		persons.add(person2);
		persons.add(person3);
		return persons;
	}
	
	public static Map<Integer, String> getSampleMap() {
		Map<Integer, String> sampleMap= new HashMap<>();
		sampleMap.put(1, "RED");
		sampleMap.put(2, "GREEN");
		sampleMap.put(3, "BLUE");
		return sampleMap;
	}
}
