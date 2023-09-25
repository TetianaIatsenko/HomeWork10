import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FileParser {
    public void printFrequencyWords(String fileName){
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
        Map<String, Integer> mapWords = new HashMap<>();
        for (String row :
                rows) {
            String[] words = row.split(" ");
            for (String word :
                    words) {
                Integer count = mapWords.get(word);
                if(count == null){
                    mapWords.put(word, 1);
                }else{
                    mapWords.put(word, ++count);
                }
            }
        }
        printMap(mapWords);
    }
    private void printMap(Map<String, Integer> mapWords){
        ArrayList<Word> listWords = new ArrayList<>();
        for (String wordName :
                mapWords.keySet()) {
            listWords.add(new Word(wordName, mapWords.get(wordName)));
        }
        Collections.sort(listWords);
        for (Word word :
                listWords) {
            System.out.println(word);
        }
    }
}
