package ProgrammingElemrnt;

import java.util.Scanner;

public class FeetConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int feet = sc.nextInt();

        double yards = feet / 3;
        double miles = yards / 1760;

        System.out.println("Distance in yards is " + yards +
                " and in miles is " + miles);
    }
}
