import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    public static void readValidPhoneNumbers(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String phoneNumber = scanner.nextLine();
                if (PhoneValidator.validate(phoneNumber)) {
                    System.out.println(phoneNumber);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
        }
    }
}
