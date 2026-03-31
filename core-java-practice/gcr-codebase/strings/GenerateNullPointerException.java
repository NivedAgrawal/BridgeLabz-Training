package Strings;

public class GenerateNullPointerException {
	public static void main(String args[]){
		String s = null;
		try {
			int k = findLen(s);
			System.out.println("Length of string"+ k);
		}
		catch(NullPointerException e) {
			System.out.println("String is null");
		}
	}

	private static int findLen(String s) {
		// TODO Auto-generated method stub
		return s.length();
	}
}
