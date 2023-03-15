import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReaderWriter {
    public static List<User> readUsersFromFile(String filename) throws IOException {
        List<User> userList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));

        // Skip header line
        br.readLine();

        String line;
        while ((line = br.readLine()) != null) {
            String[] columns = line.split(" ");
            String name = columns[0];
            int age = Integer.parseInt(columns[1]);
            User user = new User(name, age);
            userList.add(user);
        }

        br.close();
        return userList;
    }

    public static void writeUsersToJson(List<User> userList, String filename) throws IOException {
        FileWriter fw = new FileWriter(filename);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("[\n");
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            bw.write("    {\n");
            bw.write("        \"name\": \"" + user.getName() + "\",\n");
            bw.write("        \"age\": " + user.getAge() + "\n");
            if (i == userList.size() - 1) {
                bw.write("    }\n");
            } else {
                bw.write("    },\n");
            }
        }
        bw.write("]\n");
        bw.close();
        fw.close();
    }
}
