package railroad.spell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
        import org.springframework.context.ApplicationListener;
        import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Component
public class DictionaryService {

    private Map<String,List<String>> dictionary = new HashMap<String,List<String>>();

    public List<String> getWords(String firstLetter) {
        List<String> words = dictionary.get(firstLetter);
        if (words == null) {
            return new ArrayList<>();
        } else {
            return words;
        }
    }

    public DictionaryService() {
        // Load dictionary up on boot
        String curLine;
        String dictFile = ClassLoader.getSystemResource("US.dic").getFile();
        try (BufferedReader br = new BufferedReader(new FileReader(new File(dictFile)))) {
            while ((curLine = br.readLine()) != null) {
                String startLetter = curLine.substring(0,1);
                if (dictionary.containsKey(startLetter)) {
                    dictionary.get(startLetter).add(curLine);
                } else {
                    List<String> wordArray = new ArrayList<>();
                    wordArray.add(curLine);
                    dictionary.put(startLetter,wordArray);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading dictionary file!");
        }
    }

    public Boolean isInWordList(String testWord) {
        if (testWord.isEmpty()) {
            return false;
        } else {
            List<String> words = dictionary.get(testWord.substring(0, 1));
            for (String word : words) {
                if (testWord.equals(word)) {
                    return true;
                }
            }
            return false;
        }
    }

    public String spellingSuggestion(String testWord) {
        // TODO implement this!
        // Use proximity mapping like first word near or scoring in Hamming distance on all letters in
        // first letter array
        return "";
    }
}