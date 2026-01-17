package LinearAndBinarySearch;
import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader reader = new BufferedReader(isr);

            FileWriter writer = new FileWriter("output.txt");

            System.out.println("Enter text (type 'exit' to finish):");

            String line;
            while (true) {
                line = reader.readLine();
                if (line.equalsIgnoreCase("exit")) {
                    break;
                }
                writer.write(line + "\n");
            }

            writer.close();
            reader.close();
            isr.close();

            System.out.println("User input written to 'output.txt'.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
