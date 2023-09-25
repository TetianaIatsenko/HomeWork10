import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberParser {
    public enum PatternPhoneNumber{
        //    (xxx) xxx-xxxx
        PATTERN1("\\(\\d{3}\\)\\s\\d{3}\\-\\d{4}"),
        //    xxx-xxx-xxxx
        PATTERN2("\\d{3}\\-\\d{3}\\-\\d{4}");

        private final String pattern;
        PatternPhoneNumber(String pattern) {
            this.pattern = pattern;
        }

        public String getPattern() {
            return pattern;
        }
    }
    public void printPhoneNumber(String fileName){
        List<String> rows = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String s = br.readLine();
            while (s != null){
                if(isStringPhoneNumber(s))
                    rows.add(s);
                s = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        printCorrectPhoneNumber(rows);
    }
    private boolean isStringPhoneNumber(String str){
        for (PatternPhoneNumber patternPhoneNumber:
                PatternPhoneNumber.values()) {
            Pattern pattern1 = Pattern.compile(patternPhoneNumber.getPattern());
            Matcher matcher = pattern1.matcher(str);
            if (matcher.matches()) {
                return true;
            }
        }
        return false;
    }
    private void printCorrectPhoneNumber(List<String> list){
        for (String str :
                list) {
            System.out.println(str);
        }
    }

}
