import java.util.Scanner;

public class VowelConsonantCount {

    public static String charType(char ch) {
        if (ch >= 'A' && ch <= 'Z') ch += 32; // to lowercase
        if (ch >= 'a' && ch <= 'z') {
            return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') ? "Vowel" : "Consonant";
        }
        return "Not a Letter";
    }

    public static int[] countVC(String str) {
        int vowels = 0, consonants = 0;
        for (int i = 0; i < str.length(); i++) {
            String type = charType(str.charAt(i));
            if (type.equals("Vowel")) vowels++;
            else if (type.equals("Consonant")) consonants++;
        }
        return new int[]{vowels, consonants};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        int[] result = countVC(text);
        System.out.println("Vowels: " + result[0] + ", Consonants: " + result[1]);
    }
}
