package com.learning.util;

import java.time.LocalDate;

public class Person {

	public enum Sex {
		MALE, FEMALE
	}
	public String name;
	public int age;
	public LocalDate birthDay;
	public String emailAddress;
	public Sex gender;
	
	public static int compareByAge(Person a, Person b) {
		return a.birthDay.compareTo(b.birthDay);
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public Sex getGender() {
		return gender;
	}

	public void setGender(Sex gender) {
		this.gender = gender;
	}

	public String toString()
	{
		return "Name "+name+ " Email "+emailAddress + " Birthday "+birthDay;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
}
