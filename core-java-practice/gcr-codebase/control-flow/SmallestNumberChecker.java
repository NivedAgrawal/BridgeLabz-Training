package ControlFlows;

import java.util.Scanner;

class SmallestNumberChecker {

 public static void main(String[] args) {
     // Create Scanner object
     Scanner sc = new Scanner(System.in);

     // Get three numbers from user
     int number1 = sc.nextInt();
     int number2 = sc.nextInt();
     int number3 = sc.nextInt();

     // Check if first number is smallest
     boolean isFirstSmallest = (number1 < number2 && number1 < number3);

     // Print result
     System.out.println("Is the first number the smallest? " + isFirstSmallest);

 }
}

