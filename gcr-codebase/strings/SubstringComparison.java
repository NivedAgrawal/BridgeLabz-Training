package Strings;

import java.util.Scanner;

public class SubstringComparison {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter two strings");
		String input1 = sc.next();
		String input2 = sc.next();
		System.out.println("Enter start and then end value");
		int start = sc.nextInt();
		int end = sc.nextInt();
		String subInput1 = input1.substring(start,end);
		String subInput2 = input2.substring(start,end);
		  boolean charAtResult = true;

	        // Step 1: Check length of both strings
	        if (subInput1.length() != subInput2.length()) {
	            charAtResult = false;
	        } else {
	            // Step 2: Compare each character using charAt()
	            for (int index = 0; index < subInput1.length(); index++) {
	                if (subInput1.charAt(index) != subInput2.charAt(index)) {
	                    charAtResult = false;
	                    break;
	                }
	            }
	        }

	        // Step 3: Compare using built-in equals() method
	        boolean equalsResult = subInput1.equals(subInput2);

	        // Step 4: Display results
	        System.out.println("\nComparison using charAt(): " + charAtResult);
	        System.out.println("Comparison using equals(): " + equalsResult);

	        // Step 5: Check if both results are same
	        if (charAtResult == equalsResult) {
	            System.out.println("Both comparison results are the SAME.");
	        } else {
	            System.out.println("Both comparison results are DIFFERENT.");
	        }

	}
}
