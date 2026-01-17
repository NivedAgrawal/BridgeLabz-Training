package LinearAndBinarySearch;
import java.io.*;

public class WordCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("sample.txt"));
        String target = "Java";
        int count = 0;
        String line;
        while ((line = reader.readLine()) != null) {
            for (String word : line.split("\\s+")) {
                if (word.equalsIgnoreCase(target)) {
                    count++;
                }
            }
        }
        reader.close();
        System.out.println("Count: " + count);
    }
}
