import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<User> userList = FileReaderWriter.readUsersFromFile("file.txt");
        FileReaderWriter.writeUsersToJson(userList, "user.json");
    }
}
