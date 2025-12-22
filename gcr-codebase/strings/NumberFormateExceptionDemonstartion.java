package string;

import java.util.Scanner;

public class NumberFormateExceptionDemonstartion {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		try {
			int num = Integer.parseInt(str);
			System.out.print(num);
		} catch (Exception e) {
			System.out.print(e);
		}
		sc.close();
	}

}
