import java.util.Scanner;
public class CharTypeTable {

    public static String charType(char ch) {
        if (ch >= 'A' && ch <= 'Z') ch += 32;
        if (ch >= 'a' && ch <= 'z') {
            return "aeiou".indexOf(ch) != -1 ? "Vowel" : "Consonant";
        }
        return "Not a Letter";
    }

    public static String[][] classifyChars(String text) {
        String[][] arr = new String[text.length()][2];
        for (int i = 0; i < text.length(); i++) {
            arr[i][0] = String.valueOf(text.charAt(i));
            arr[i][1] = charType(text.charAt(i));
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[][] data = classifyChars(text);

        System.out.println("Char\tType");
        for (String[] row : data) {
            System.out.println(row[0] + "\t" + row[1]);
        }
    }
}
