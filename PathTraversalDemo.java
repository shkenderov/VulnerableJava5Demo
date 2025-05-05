import java.io.*;

public class PathTraversalDemo {
    public static void main(String[] args) {
        String userInput = "../../etc/passwd"; // simulate input
        File file = new File("data/" + userInput); // ⚠️ path traversal

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
