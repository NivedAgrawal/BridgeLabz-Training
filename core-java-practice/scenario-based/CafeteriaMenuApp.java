package scenerio_based;

import java.util.Scanner;

public class CafeteriaMenuApp {

    static String[] menu = {
        "Idli", "Dosa", "Vada", "Poha", "Upma",
        "Pasta", "Burger", "Sandwich", "Tea", "Coffee"
    };

    public static void displayMenu() {
        System.out.println("Cafeteria Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + " - " + menu[i]);
        }
    }

    public static String getItemByIndex(int index) {
        if (index < 0 || index >= menu.length) {
            return "Invalid selection";
        }
        return menu[index];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        displayMenu();

        System.out.print("Select item index: ");
        int choice = sc.nextInt();

        System.out.println("You selected: " + getItemByIndex(choice));
        sc.close();
    }
}

