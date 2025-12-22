package string;

import java.util.Scanner;

public class ConvertToLowerCase {

	public static String toLower(String str) {
		String s = "";
		for (char ch : str.toCharArray()) {
			if (Character.isLowerCase(ch)) {
				s += ch;
			} else {
				s += (char) (ch + 32);
			}
		}
		return s;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.print(toLower(str));
		sc.close();
	}

}
