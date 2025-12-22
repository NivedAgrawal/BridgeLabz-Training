package string;

import java.util.Scanner;

public class ArrayIndexBoundDemonstration {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = new String[3];
		for (int i = 0; i < 3; i++) {
			str[i] = sc.next();
		}
		try {
			String last = str[4];
			System.out.print(last);
		} catch (Exception e) {
			System.out.print(e);
		}
		sc.close();
	}

}
