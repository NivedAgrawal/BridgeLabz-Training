package Strings;
import java.util.Scanner;

public class CompareStrings {

    public static void main(String[] args) {

       
        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter first string: ");
        String firstString = sc.next();

        System.out.print("Enter second string: ");
        String secondString = sc.next();

        // Variable to store charAt() comparison result
        boolean charAtResult = true;

        // Step 1: Check length of both strings
        if (firstString.length() != secondString.length()) {
            charAtResult = false;
        } else {
            // Step 2: Compare each character using charAt()
            for (int index = 0; index < firstString.length(); index++) {
                if (firstString.charAt(index) != secondString.charAt(index)) {
                    charAtResult = false;
                    break;
                }
            }
        }

        // Step 3: Compare using built-in equals() method
        boolean equalsResult = firstString.equals(secondString);

        // Step 4: Display results
        System.out.println("\nComparison using charAt(): " + charAtResult);
        System.out.println("Comparison using equals(): " + equalsResult);

        // Step 5: Check if both results are same
        if (charAtResult == equalsResult) {
            System.out.println("Both comparison results are the SAME.");
        } else {
            System.out.println("Both comparison results are DIFFERENT.");
        }

        // Closing scanner
        sc.close();
    }
}
