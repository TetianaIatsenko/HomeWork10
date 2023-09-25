import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class UserSerialization {
    public String getUsersListJSON(String fileName){
        ArrayList<User> newUser = new ArrayList();
        List<String> rows = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String s = br.readLine();
            while (s != null){
                rows.add(s);
                s = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 1; i < rows.size(); i ++){
            List<String> parameters = Arrays.asList(rows.get(i).split(" "));
            newUser.add(new User(parameters.get(0), Integer.valueOf(parameters.get(1))));
        }
        return getJsonFromList(newUser);
    }
    private String getJsonFromList(List<User> newUsers){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(newUsers);
    }
    public void writeJSONFile(String json, String fileName){

        try (FileWriter file = new FileWriter(fileName)){
            file.write(json);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
