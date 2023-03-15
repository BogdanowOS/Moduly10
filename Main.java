import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String fileName = "file.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (isValidPhoneNumber(line)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        // Перевіряємо чи відповідає номер одному з форматів
        boolean isFormat1 = phoneNumber.matches("\\(\\d{3}\\) \\d{3}-\\d{4}");
        boolean isFormat2 = phoneNumber.matches("\\d{3}-\\d{3}-\\d{4}");

        return isFormat1 || isFormat2;
    }
}
