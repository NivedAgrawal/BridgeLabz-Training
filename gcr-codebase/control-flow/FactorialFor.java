package ControlFlows;

//Create class FactorialFor
import java.util.Scanner;

class FactorialFor {

 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

     int number = sc.nextInt();

     if (number >= 0) {
         int factorial = 1;

         for (int i = 1; i <= number; i++) {
             factorial *= i;
         }

         System.out.println("Factorial of " + number + " is " + factorial);
     } else {
         System.out.println("Not a natural number");
     }

     sc.close();
 }
}

