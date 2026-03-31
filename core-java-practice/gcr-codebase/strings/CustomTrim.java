import java.util.Scanner;
public class CustomTrim {

    public static int[] trimIndex(String text) {
        int start = 0, end = text.length() - 1;
        while (start <= end && text.charAt(start) == ' ') start++;
        while (end >= start && text.charAt(end) == ' ') end--;
        return new int[]{start, end};
    }

    public static String customSubstring(String text, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) sb.append(text.charAt(i));
        return sb.toString();
    }

    public static boolean compare(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        int[] index = trimIndex(text);
        String trimmedCustom = customSubstring(text, index[0], index[1]);
        String trimmedBuiltIn = text.trim();

        System.out.println("Custom Trimmed: [" + trimmedCustom + "]");
        System.out.println("Built-in Trimmed: [" + trimmedBuiltIn + "]");
        System.out.println("Are equal? " + compare(trimmedCustom, trimmedBuiltIn));
    }
}
