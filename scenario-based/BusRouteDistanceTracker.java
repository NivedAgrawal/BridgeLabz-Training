package scenerio_based;

import java.util.Scanner;

public class BusRouteDistanceTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double totalDistance = 0;

        while (true) {
            System.out.print("Enter distance to next stop (in km): ");
            
            if (!sc.hasNextDouble()) {
                System.out.println("Invalid distance. Please enter a number.");
                sc.next();
                continue;
            }

            double distance = sc.nextDouble();
            totalDistance += distance;

            System.out.println("Total distance traveled: " + totalDistance + " km");

            System.out.print("Do you want to get off at this stop? (yes/no): ");
            String choice = sc.next();

            if (choice.equalsIgnoreCase("yes")) {
                System.out.println("Passenger got off.");
                break;
            }
        }
    }
}
