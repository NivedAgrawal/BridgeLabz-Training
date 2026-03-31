package scenerio_based;

import java.util.*;

public class EmployeeWageCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.println("   EMPLOYEE WAGE COMPUTATION PROGRAM");
        // User Inputs
        System.out.print("Enter Employee Name: ");
        String empName = sc.nextLine();

        System.out.print("Enter Wage Per Hour (₹): ");
        int wagePerHour = sc.nextInt();

        System.out.print("Enter Full Day Working Hours: ");
        int fullDayHour = sc.nextInt();

        System.out.print("Enter Part Time Working Hours: ");
        int partTimeHour = sc.nextInt();

        System.out.print("Enter Maximum Working Days in a Month: ");
        int maxWorkingDays = sc.nextInt();

        System.out.print("Enter Maximum Working Hours in a Month: ");
        int maxWorkingHours = sc.nextInt();

        int totalWorkingDays = 0;
        int totalEmpHours = 0;
        int totalWage = 0;

        System.out.println("Monthly Attendance & Wage Details");

        while (totalWorkingDays < maxWorkingDays &&
               totalEmpHours < maxWorkingHours) {

            totalWorkingDays++;
            int empCheck = random.nextInt(3); // 0-Absent, 1-Full, 2-Part
            int empHours = 0;

            if (empCheck == 1) {
                empHours = fullDayHour;
                System.out.println("Day " + totalWorkingDays + ": Full Time");
            }
            else if (empCheck == 2) {
                empHours = partTimeHour;
                System.out.println("Day " + totalWorkingDays + ": Part Time");
            }
            else {
                empHours = 0;
                System.out.println("Day " + totalWorkingDays + ": Absent");
            }

            if (totalEmpHours + empHours > maxWorkingHours) {
                empHours = maxWorkingHours - totalEmpHours;
            }

            totalEmpHours += empHours;
            int dailyWage = empHours * wagePerHour;
            totalWage += dailyWage;

            System.out.println("   Worked Hours: " + empHours +
                               " | Daily Wage: ₹" + dailyWage + "\n");
        }

        System.out.println("           MONTHLY SUMMARY");
        System.out.println("Employee Name       : " + empName);
        System.out.println("Total Working Days  : " + totalWorkingDays);
        System.out.println("Total Working Hours : " + totalEmpHours);
        System.out.println("Total Monthly Wage  : ₹" + totalWage);
        System.out.println("Thank You!");
    }
}

