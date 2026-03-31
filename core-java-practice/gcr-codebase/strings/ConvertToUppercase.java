package string;

import java.util.Scanner;

public class ConvertToUppercase {

	public static String toUpper(String str) {
		String s = "";
		for (char ch : str.toCharArray()) {
			if (Character.isUpperCase(ch)) {
				s += ch;
			} else {
				s += (char) (ch - 32);
			}
		}
		return s;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.print(toUpper(str));
		sc.close();
	}

}
