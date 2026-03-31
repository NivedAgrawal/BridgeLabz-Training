package string;

import java.util.Scanner;

public class IllegalArgumentExceptionDemonstration {

	public static String exceptionMethod(String str) {
		if (str.length() < 3) {
			throw new IllegalArgumentException("String length must be at least 3");
		}
		return str.substring(0, 2);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		try {
			String subString = exceptionMethod(str);
			System.out.print(subString);
		} catch (Exception e) {
			System.out.print("Exception " + e);
		}
		sc.close();
	}

}
