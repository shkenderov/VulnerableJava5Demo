import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
            System.out.print("Enter a system command: ");
            String userInput = reader.readLine();

            // ⚠️ Command injection
            String command = "cmd.exe /c " + userInput;
            Process proc = Runtime.getRuntime().exec(command);

            BufferedReader output = new BufferedReader(
                new InputStreamReader(proc.getInputStream()));
            String line;
            while ((line = output.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
