import java.util.*;

public class WordsWithLength {

    public static int getLength(String s) {
        int len = 0;
        try {
            while (true) s.charAt(len++);
        } catch (Exception e) {}
        return len;
    }

    public static String[] customSplit(String text) {
        ArrayList<String> list = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < getLength(text); i++) {
            char ch = text.charAt(i);
            if (ch != ' ') word.append(ch);
            else {
                if (word.length() > 0) {
                    list.add(word.toString());
                    word.setLength(0);
                }
            }
        }
        if (word.length() > 0) list.add(word.toString());
        return list.toArray(new String[0]);
    }

    public static String[][] getWordLengthArray(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getLength(words[i]));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        String[] words = customSplit(text);
        String[][] data = getWordLengthArray(words);

        System.out.println("Word\tLength");
        for (String[] row : data) {
            System.out.println(row[0] + "\t" + Integer.parseInt(row[1]));
        }
    }
}
