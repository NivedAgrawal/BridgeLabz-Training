package scenerio_based;

import java.util.Scanner;

public class FestivalLuckyDraw {
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input;

        System.out.println("🎉 Diwali Mela Lucky Draw 🎉");
        System.out.println("Enter numbers for visitors (type 'q' to quit)");

        while (true) {
            System.out.print("Enter lucky number: ");
            input = sc.next();

            if (input.equalsIgnoreCase("q")) {
                System.out.println("Lucky draw ended.");
                break;
            }

            if (!input.matches("\\d+")) {
                System.out.println("Invalid input! Please enter a valid number.");
                continue;
            }

            int number = Integer.parseInt(input);

            if (number % 3 == 0 && number % 5 == 0) {
                System.out.println("🎁 Congratulations! You won a gift!");
            } else {
                System.out.println("Sorry, better luck next time.");
            }
        }
}
}
