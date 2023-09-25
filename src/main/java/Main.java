import java.io.*;

public class Main {
    public static String FILE_NAME = "src\\main\\resources\\file.txt";
    public static String FILE_NAME2 = "src\\main\\resources\\User.txt";
    public static String FILE_NAME3 = "src\\main\\resources\\user.json";
    public static String FILE_NAME4 = "src\\main\\resources\\word.txt";
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        PhoneNumberParser phoneNumberParser = new PhoneNumberParser();
        phoneNumberParser.printPhoneNumber(FILE_NAME);

        UserSerialization userSerialization = new UserSerialization();
        userSerialization.writeJSONFile(userSerialization.getUsersListJSON(FILE_NAME2), FILE_NAME3);

        FileParser parser = new FileParser();
        parser.printFrequencyWords(FILE_NAME4);
    }
}
