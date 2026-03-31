package scenerio_based;

import java.util.Scanner;

public class FitnessTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] pushUps = new int[7];

        System.out.println("Enter push-ups done for 7 days (Enter 0 for rest day):");

        for (int i = 0; i < pushUps.length; i++) {
            System.out.print("Day " + (i + 1) + ": ");
            pushUps[i] = sc.nextInt();
        }

        int totalPushUps = 0;
        int workoutDays = 0;

        for (int count : pushUps) {

 
            if (count == 0) {
                continue;
            }

            totalPushUps += count;
            workoutDays++;
        }

        double averagePushUps = (workoutDays > 0)? (double) totalPushUps / workoutDays : 0;

        System.out.println("Total Push-ups (excluding rest days): " + totalPushUps);
        System.out.println("Workout Days: " + workoutDays);
        System.out.println("Average Push-ups per workout day: " + averagePushUps);

    }
}
