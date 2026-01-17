package LinearAndBinarySearch;
import java.io.*;

public class ByteToCharStream {
    public static void main(String[] args) {
        try {
            // Step 1: Create a file with sample text
            FileOutputStream fos = new FileOutputStream("input.txt");
            fos.write("This is a test file with UTF-8 encoded text.\nSecond line here.".getBytes("UTF-8"));
            fos.close();

            // Step 2: Read using InputStreamReader
            FileInputStream fis = new FileInputStream("input.txt");
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            String line;
            System.out.println("Reading file using InputStreamReader:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
            isr.close();
            fis.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
