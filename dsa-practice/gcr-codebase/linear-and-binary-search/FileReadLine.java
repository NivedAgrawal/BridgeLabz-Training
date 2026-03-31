package LinearAndBinarySearch;
import java.io.*;

public class FileReadLine {
    public static void main(String[] args) {
        try {
            // Step 1: Create sample.txt file with some content
            File file = new File("sample.txt");
            FileWriter writer = new FileWriter(file);
            writer.write("Hello World\n");
            writer.write("This is a test file\n");
            writer.write("Java FileReader example\n");
            writer.close();

            // Step 2: Read the file line by line using FileReader
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            System.out.println("Reading from file:\n");

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}


