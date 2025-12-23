package review;

import java.util.Scanner;

public class FirstNonRepeatingCharacter {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String");
		String s = sc.next().toLowerCase();
		int[] freq = new int[26];
		for(char c: s.toCharArray()) {
			freq[c-'a']++;
		}
		char ans = ' ';
		for(char c: s.toCharArray()) {
			if(freq[c-'a']==1) {
				ans = c;
				break;
			}
		}
		System.out.println("First non repeating character: "+ans);
	}
}
