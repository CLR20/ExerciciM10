package com.lambdas.project;

import com.lambdas.interfaces.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		
// Milestone 1 below, Milestone 2 at line 61, Milestone 3 at line .
	
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
		
		
///////// Milestone 2
		System.out.println("\n\n******\nMILESTONE 2\n");
		
		List <String> mix = Arrays.asList("Pau", "Ana", "Marc", "Berta", "Arnau",
				"Ari", "Joan", "Jordi", "Ali", "Ona", "Oriol", "Ava", "1", "2", "34", "5", "678", "9", "end0", "January", "February", "March", "April", "May", 
				"June", "July", "August", "September", "October", "November", "December", "one1", "e2", "3and4", "5for", "6s7s8e", "ni9ne", "end0");
		System.out.println("\nORIGINAL MIX LIST: " + mix);
		
		// Getting mix ordered by length.
		List <String> lengthUp = mix.stream().sorted(Comparator.comparing(l -> l.length()))
				.collect(Collectors.toList());
		System.out.println("\nMix ordered by length: " + lengthUp);		
		
		// Getting mix ordered by reversed length.
		List <String> lengthDown = getReverseList(lengthUp);
///Com aconseguir aquest amb lambdas???
		System.out.println("\nMix ordered by reversed length: " + lengthDown);
		
		// Getting mix ordered by first character value.
		List <String> firstChar = mix.stream().sorted(Comparator.comparingInt(i -> i.charAt(0)))
				.collect(Collectors.toList());
		System.out.println("\nMix ordered by first character: " + firstChar);	

		// Getting strings with "e" first.
		List<String> firstE = mix.stream().sorted(Comparator.comparing(w -> w.length()))
				.sorted(Comparator.comparing(w -> !w.contains("e")))
				.collect(Collectors.toList());
		System.out.println("\nMix ordered with strings containing e first: " + firstE);
		
		//Changing "a" for "4".
		List<String> aFor4 = mix.stream().map(w -> w.replaceAll("(?i)a", "4"))
				.collect(Collectors.toList());
		System.out.println("\nChanging \"a\" for 4: " + aFor4);
		
		// Showing only numeric strings.
		List <String> justNumbers = mix.stream().filter(w -> w.matches("[0-9]+"))
				.collect(Collectors.toList());
		System.out.println("\nStrings with just numbers: " + justNumbers);
		
		// Getting math operation with functional interface.
		System.out.println("\nSum of 1.1 and 1.2: " + maths("sum", 1.1f, 1.2f));
		System.out.println("\nRest of 1.1 and 1.2: " + maths("rest", 1.1f, 1.2f));
		System.out.println("\nDivision of 1.1 and 1.2: " + maths("multiply", 1.1f, 1.2f));
		System.out.println("\nRest of 1.1 and 1.2: " + maths("divide", 1.1f, 1.2f));		
	}	

	public static double getPi() {		
		PiNumber pi = () -> 3.1415;
		return pi.getPiValue();	
	};	
	
	public static String getReverse(String s) {
		Reversing rev = () -> new StringBuilder(s).reverse().toString();
		return rev.reverse();
	};
	
	public static List<String> getReverseList(List<String> initial) {
		List <String> reversed = initial;
		Collections.reverse(reversed);		
		return reversed;
	};	
	
	public static float maths (String s, float a, float b) {
		Operations operate;
		if (s.equals("sum")) {
			operate = () -> a + b;
		}
		else if (s.equals("rest")) {
			operate = () -> a - b;
		}
		else if (s.equals("multiply")) {
			operate = () -> a * b;
		}
		else {
			operate = () -> a / b;
		}
		////Doesn't work still on Java 8.
		/*Operations operate = () -> switch (s);
		switch (s) {
		case "sum" -> result = a + b;
		case "rest" -> result = a - b;
		case "multiply" -> result = a * b;
		case "divide" -> result = a - b;		
		default -> result = null;
		}	*/	
		return operate.operation();
		//return 1.1f;
	};
	
}		
		

