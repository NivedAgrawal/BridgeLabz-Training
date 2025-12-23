import java.util.*;
public class ShortestLongestWord {

    public static int getLength(String s) {
        int len = 0;
        try {
            while (true) s.charAt(len++);
        } catch (Exception e) {}
        return len;
    }

    public static String[] splitWords(String text) {
        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getLength(text); i++) {
            char ch = text.charAt(i);
            if (ch != ' ') sb.append(ch);
            else if (sb.length() > 0) {
                list.add(sb.toString());
                sb.setLength(0);
            }
        }
        if (sb.length() > 0) list.add(sb.toString());
        return list.toArray(new String[0]);
    }

    public static String[] findShortestAndLongest(String[] words) {
        String shortest = words[0], longest = words[0];
        for (String word : words) {
            if (getLength(word) < getLength(shortest)) shortest = word;
            if (getLength(word) > getLength(longest)) longest = word;
        }
        return new String[]{shortest, longest};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] words = splitWords(text);
        String[] result = findShortestAndLongest(words);
        System.out.println("Shortest Word: " + result[0]);
        System.out.println("Longest Word: " + result[1]);
    }
}
