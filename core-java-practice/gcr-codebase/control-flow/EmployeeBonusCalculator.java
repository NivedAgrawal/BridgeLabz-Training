package ControlFlows;

//Create class EmployeeBonusCalculator
import java.util.Scanner;

class EmployeeBonusCalculator {

 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     
     //input of salary and exp.
     double salary = sc.nextDouble();
     int yearsOfService = sc.nextInt();

     if (yearsOfService > 5) {
         double bonus = salary * 0.05;
         System.out.println("Bonus amount is " + bonus);
     } else {
         System.out.println("No bonus applicable");
     }

     sc.close();
 }
}

