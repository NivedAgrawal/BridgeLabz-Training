package string;

import java.util.Scanner;

public class StringComparisonUsingToCharArray {

	public static char[] charArray(String str) {
		int l = str.length();
		char[] ch = new char[l];
		for (int i = 0; i < l; i++) {
			ch[i] = str.charAt(i);
		}
		return ch;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char[] chArray1 = charArray(str);
		char[] chArray2 = str.toCharArray();
		boolean isEqual = true;
		for (int i = 0; i < chArray1.length; i++) {
			if (chArray1[i] != chArray2[i]) {
				isEqual = false;
			}
		}
		System.out.print(isEqual);
		sc.close();
	}

}
