package com.learning.feature.defaultmethods;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Default methods enable developer to add functionality to existing interfaces 
 * and ensure binary compatibility with code written for older interface 
 *
 */
public class DefaultAndStaticMethodLearning {
	public static void main(String args[]) {
		DefaultAndStaticMethodLearning defaultAndStaticMethodLearning 
			= new DefaultAndStaticMethodLearning();
		TimeClient timeClient1 = defaultAndStaticMethodLearning.new SimpleTimeClientV1Impl();
		System.out.println("SimpleTimeClientV1Impl "+timeClient1.getZonedDateTime("Asia/Kolkata"));
		TimeClient timeClient2 = defaultAndStaticMethodLearning.new SimpleTimeClientV2Impl();
		System.out.println("SimpleTimeClientV2Impl "+timeClient2.getZonedDateTime("Asia/Kolkata"));
		TimeClient timeClient3 = defaultAndStaticMethodLearning.new SimpleTimeClientV3Impl();
		System.out.println("SimpleTimeClientV3Impl "+timeClient3.getZonedDateTime("Asia/Kolkata"));
	}
	interface TimeClient {
		public void setTime(int hour, int minute, int second);
		public void setDate(int day, int month, int year);
		public void setDateAndTime(int hour, int minute, int second, 
				int day, int month, int year);
		public LocalDateTime getLocalDateAndTime();
		/**
		 * default method defined that provides implementation
		 * @param zoneName
		 * @return
		 */
		public default ZonedDateTime getZonedDateTime(String zoneName) {
			System.out.println("default method TimeClient.getZonedDateTime");
			return ZonedDateTime.of(getLocalDateAndTime(), getZoneId(zoneName));
		}
		/**
		 * 
		 * @param zoneName
		 * @return
		 */
		public static ZoneId getZoneId(String zoneName) {
			try 
			{
				return ZoneId.of(zoneName);
			} catch (Exception e) {
				return ZoneId.systemDefault();
			} 
		}
	}
	
	interface SimpleTimeClientV1 extends TimeClient {
		/** 
		 * this method needs to be implemented and 
		 * default implementation won't be available as redeclaration makes it abstract
		 */
		public ZonedDateTime getZonedDateTime(String zoneName);
	}
	
	interface SimpleTimeClientV2 extends TimeClient {
		// As getZonedDateTime is not redeclared, default implementation will be available
	}
	
	interface SimpleTimeClientV3 extends TimeClient {
		/** 
		 * this method overrides default implementation provided in TimeClient interface
		 */
		public default ZonedDateTime getZonedDateTime(String zoneName) {
			System.out.println("default method SimpleTimeClientV3.getZonedDateTime");
			if(null!=zoneName)
				return ZonedDateTime.of(getLocalDateAndTime(), DefaultAndStaticMethodLearning.TimeClient.getZoneId(zoneName));
			else
				return ZonedDateTime.of(getLocalDateAndTime(), ZoneId.systemDefault());
		} 
	}
	
	class SimpleTimeClientV1Impl implements SimpleTimeClientV1 {
		private LocalDateTime localDateTime;
		
		public SimpleTimeClientV1Impl() {
			localDateTime = LocalDateTime.now();
		}
		
		@Override
		public void setTime(int hour, int minute, int second) {
			LocalTime localTime = LocalTime.of(hour, minute, second);
			LocalDate localDate = LocalDate.from(localDateTime);
			localDateTime = LocalDateTime.of(localDate, localTime);
		}

		@Override
		public void setDate(int day, int month, int year) {
			LocalDate localDate = LocalDate.of(day, month, year);
			LocalTime localTime = LocalTime.from(localDateTime);
			localDateTime = LocalDateTime.of(localDate, localTime);
		}

		@Override
		public void setDateAndTime(int hour, int minute, int second, int day, int month, int year) {
			LocalTime localTime = LocalTime.of(hour, minute, second);
			LocalDate localDate = LocalDate.of(day, month, year);
			localDateTime = LocalDateTime.of(localDate, localTime);
		}

		@Override
		public LocalDateTime getLocalDateAndTime() {
			return localDateTime;
		}
		/**
		 * getZonedDateTime is implemented as it is redeclared in SimpleTimeClientV1
		 */
		@Override
		public ZonedDateTime getZonedDateTime(String zoneName) {
			System.out.println("default method SimpleTimeClientV1Impl.getZonedDateTime");
			return ZonedDateTime.of(getLocalDateAndTime(), DefaultAndStaticMethodLearning.TimeClient.getZoneId(zoneName));
		}
	}
	
	class SimpleTimeClientV2Impl implements SimpleTimeClientV2 {

		private LocalDateTime localDateTime;
		
		public SimpleTimeClientV2Impl() {
			localDateTime = LocalDateTime.now();
		}
		
		@Override
		public void setTime(int hour, int minute, int second) {
			LocalTime localTime = LocalTime.of(hour, minute, second);
			LocalDate localDate = LocalDate.from(localDateTime);
			localDateTime = LocalDateTime.of(localDate, localTime);
		}

		@Override
		public void setDate(int day, int month, int year) {
			LocalDate localDate = LocalDate.of(day, month, year);
			LocalTime localTime = LocalTime.from(localDateTime);
			localDateTime = LocalDateTime.of(localDate, localTime);
		}

		@Override
		public void setDateAndTime(int hour, int minute, int second, int day, int month, int year) {
			LocalTime localTime = LocalTime.of(hour, minute, second);
			LocalDate localDate = LocalDate.of(day, month, year);
			localDateTime = LocalDateTime.of(localDate, localTime);
		}

		@Override
		public LocalDateTime getLocalDateAndTime() {
			return localDateTime;
		}
		//getZonedDateTime is inherited from SimpleTimeClientV2/TimeClient and no additional implementation required
	}
	
	class SimpleTimeClientV3Impl implements SimpleTimeClientV3 {

		private LocalDateTime localDateTime;
		
		public SimpleTimeClientV3Impl() {
			localDateTime = LocalDateTime.now();
		}
		
		@Override
		public void setTime(int hour, int minute, int second) {
			LocalTime localTime = LocalTime.of(hour, minute, second);
			LocalDate localDate = LocalDate.from(localDateTime);
			localDateTime = LocalDateTime.of(localDate, localTime);
		}

		@Override
		public void setDate(int day, int month, int year) {
			LocalDate localDate = LocalDate.of(day, month, year);
			LocalTime localTime = LocalTime.from(localDateTime);
			localDateTime = LocalDateTime.of(localDate, localTime);
		}

		@Override
		public void setDateAndTime(int hour, int minute, int second, int day, int month, int year) {
			LocalTime localTime = LocalTime.of(hour, minute, second);
			LocalDate localDate = LocalDate.of(day, month, year);
			localDateTime = LocalDateTime.of(localDate, localTime);
		}

		@Override
		public LocalDateTime getLocalDateAndTime() {
			return localDateTime;
		}
		//getZonedDateTime is inherited from SimpleTimeClientV3 and no additional implementation required
	}
}
