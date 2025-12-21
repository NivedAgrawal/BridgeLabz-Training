import java.util.Scanner;

public class OddEvenArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int number = sc.nextInt();

        if (number <= 0) {
            System.out.println("Invalid input");
            return;
        }

        int[] even = new int[number / 2 + 1];
        int[] odd = new int[number / 2 + 1];
        int e = 0, o = 0;

        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) even[e++] = i;
            else odd[o++] = i;
        }

        System.out.println("Even Numbers:");
        for (int i = 0; i < e; i++) System.out.print(even[i] + " ");
        System.out.println("\nOdd Numbers:");
        for (int i = 0; i < o; i++) System.out.print(odd[i] + " ");

        sc.close();
    }
}