package ProblemSet;

public class NextGreater {

	public static void main(String[] args) {
		char[] arr = new char[] { 'a', 'b', 'c', 'd', 'e' };
		System.out.print(nextGreatestLetter(arr, 'g'));
	}

	public static char nextGreatestLetter(char[] letters, char target) {
		int start = 0, end = letters.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (letters[mid] <= target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return start == letters.length ? letters[0] : letters[start];
	}

}
