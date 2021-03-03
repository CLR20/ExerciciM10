package com.lambdas.project;

import com.lambdas.interfaces.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
	
		// Searching for the names that start with "A" and have three letters.
		List <String> names = Arrays.asList("Pau", "Ana", "Marc", "Berta", "Arnau",
				"Ari", "Joan", "Jordi", "Ali", "Ona", "Oriol", "Ava");
		System.out.println("ORIGINAL NAMES LIST: " + names);
		List<String> a3Names = names.stream().filter(name -> name.startsWith("A") 
				&& name.length() == 3).collect(Collectors.toList());
		System.out.println("\nNames starting with \"A\" and 3 letters: " + a3Names);
		
		// Converting list of numbers to string of numbers indicating if odds or evens.
		List <Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		System.out.println("\nORIGINAL NUMBERS LIST: " + numbers);
		List<String> modifiedNumbers = numbers.stream().map(number -> number % 2 == 0 ? 
				("e" + number) : ("o" + number)).collect(Collectors.toList());
		String modifiedToString = modifiedNumbers.stream().map(mN -> mN.toString())
				.collect(Collectors.joining(", "));		
		System.out.println("\nNumbers indicating odds and evens: " + modifiedToString);
		
		// Creating new list from names containing "o".
		List <String> oNames = names.stream().filter(name -> name.contains("o") 
				|| name.contains("o")).collect(Collectors.toList());
		System.out.println("\nNames with \"o\": " + oNames);		
		
		// Creating new list from names with the elements with five or more letters.
		List <String> fiveLetters = names.stream().filter(name -> name.length() >= 5)
				.collect(Collectors.toList());
		System.out.println("\nNames with 5 or more letters: " + fiveLetters);
		
		// Printing months of year with lambda.
		List <String> months = Arrays.asList("January", "February", "March", "April", "May", 
				"June", "July", "August", "September", "October", "November", "December")
				;
		System.out.println("\nMonths: ");
		months.forEach(month -> System.out.println(month));
		
		// Printing months of year with method reference.
		System.out.println("\nMonths with method reference: ");
		months.forEach(System.out::println);
		
		// Getting pi number;
		System.out.println("\nPi number: " + getPi());
		
		// Getting reverse;		
		System.out.println("\nReverse of \"esrever teg ot gniyrt\": " 
		+ getReverse("esrever teg ot gniyrt"));
	}	

	public static double getPi() {		
		PiNumber pi = () -> 3.1415;
		return pi.getPiValue();	
	};	
	
	public static String getReverse(String s) {
		Reversing rev = () -> new StringBuilder(s).reverse().toString();
		return rev.reverse();
	};
}

			
		

