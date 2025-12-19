package ControlFlows;


import java.util.Scanner;

class MultiplicationTable {

 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     
     System.out.println("Enter number between 6 to 9");
     int number = sc.nextInt();

     for (int i = 1; i <= 10; i++) {
         System.out.println(number + " * " + i + " = " + (number * i));
     }

     sc.close();
 }
}

