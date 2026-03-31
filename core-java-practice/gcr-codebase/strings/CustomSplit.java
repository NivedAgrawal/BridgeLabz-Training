import java.util.*;

public class CustomSplit {

    public static int getLength(String s) {
        int i = 0;
        try {
            while (true) {
                s.charAt(i++);
            }
        } catch (Exception e) {
        }
        return i;
    }

    public static String[] customSplit(String text) {
        ArrayList<String> words = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        int len = getLength(text);
        for (int i = 0; i < len; i++) {
            char ch = text.charAt(i);
            if (ch != ' ') {
                word.append(ch);
            } else {
                if (word.length() > 0) {
                    words.add(word.toString());
                    word.setLength(0);
                }
            }
        }
        if (word.length() > 0) {
            words.add(word.toString());
        }
        return words.toArray(new String[0]);
    }

    public static boolean compareArrays(String[] a, String[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String text = sc.nextLine();

        String[] builtIn = text.split(" ");
        String[] custom = customSplit(text);

        System.out.println("Built-in split: " + Arrays.toString(builtIn));
        System.out.println("Custom split: " + Arrays.toString(custom));
        System.out.println("Are both equal? " + compareArrays(builtIn, custom));
    }
}
