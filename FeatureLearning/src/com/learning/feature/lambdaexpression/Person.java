package com.learning.feature.lambdaexpression;

import java.time.LocalDate;

public class Person {

	public enum Sex {
		MALE, FEMALE
	}
	public String name;
	public int age;
	public LocalDate birthDay;
	public String emailAddress;
	
	public static int compareByAge(Person a, Person b) {
		return a.birthDay.compareTo(b.birthDay);
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}
	
	public String toString()
	{
		return "Name "+name;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
}
