package ProblemSet;

public class ValidPallindrome {

	public static void main(String[] args) {

		System.out.print(isPalindrome("Hello"));
		
	}

	public static  boolean isPalindrome(String s) {
		StringBuilder sb = new StringBuilder();
		s = s.toLowerCase();
		int l = s.length();
		for (int i = 0; i < l; i++) {
			char ch = s.charAt(i);
			if (ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9')
				sb.append(ch + "");
		}
		int st = 0;
		int last = sb.length() - 1;
		while (st <= last) {
			if (sb.charAt(st) != sb.charAt(last))
				return false;
			st++;
			last--;

		}
		return true;
	}
}
