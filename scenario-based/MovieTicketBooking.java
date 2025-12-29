package scenerio_based;

import java.util.Scanner;

public class MovieTicketBooking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char continueBooking = 'y';

        do {
            System.out.println("--- Movie Ticket Booking ---");

    
            System.out.print("Enter movie type (Action / Comedy / Drama): ");
            String movieType = sc.next();

            System.out.print("Enter seat type (Gold / Silver): ");
            String seatType = sc.next();

            System.out.print("Do you want snacks? (yes/no): ");
            String snacksChoice = sc.next();

            int ticketPrice = 0;
            int snacksPrice = 0;

            switch (movieType.toLowerCase()) {
                case "action":
                    ticketPrice = 250;
                    break;
                case "comedy":
                    ticketPrice = 200;
                    break;
                case "drama":
                    ticketPrice = 180;
                    break;
                default:
                    System.out.println("Invalid movie type!");
                    continue;
            }
            if (seatType.equalsIgnoreCase("gold")) {
                ticketPrice += 100;
            } else if (seatType.equalsIgnoreCase("silver")) {
                ticketPrice += 50;
            } else {
                System.out.println("Invalid seat type!");
                continue;
            }
            if (snacksChoice.equalsIgnoreCase("yes")) {
                snacksPrice = 80;
            }

            int totalAmount = ticketPrice + snacksPrice;

            System.out.println("--- Booking Summary ---");
            System.out.println("Movie Type   : " + movieType);
            System.out.println("Seat Type    : " + seatType);
            System.out.println("Snacks Added : " + snacksChoice);
            System.out.println("Total Amount : ₹" + totalAmount);

            System.out.print("Book ticket for another customer? (y/n): ");
            continueBooking = sc.next().charAt(0);

        } while (continueBooking == 'y' || continueBooking == 'Y');

        System.out.println("Thank you for using Movie Ticket Booking App");
    }
}

