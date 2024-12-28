package com.abcshopapp.main;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class DateTimeDemo {

	public static void main(String[] args) {
		
		LocalDate today=LocalDate.now();
		System.out.println(today);
		
		
		//LocalDate dob=LocalDate.of(2001, 10, 30);
		//System.out.println("Dob:"+dob);
		
		LocalDate dob1=LocalDate.of(1999, 11, 04);
		System.out.println("Dob:"+dob1);
		
		//LocalDateTime dateTime=LocalDateTime.now();
		//System.out.println(dateTime);
		
		LocalDate todaysDate=LocalDate.now();
		
		int age =calculateAge(dob1,todaysDate);
		
		System.out.println("Present Age : "+age);
		
		
		//LocalDate afterDays=todaysDate.plusDays(35);
		//System.out.println("After days : "+afterDays);
        
		
	}

	public static int calculateAge(LocalDate dob1, LocalDate todaysDate) {
		
		Period period=Period.between(dob1, todaysDate);
		return period.getYears();
	}

}
