package Strings;

import java.util.Scanner;

public class GenerateIndexOutOfBoundsException {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int index = sc.nextInt();
		try {
			char c = s.charAt(index);
			System.out.println("Char at given Index"+c);
		}
		catch(IndexOutOfBoundsException e) {
			System.err.println("Index provides is out of length");
		}
	}
}
