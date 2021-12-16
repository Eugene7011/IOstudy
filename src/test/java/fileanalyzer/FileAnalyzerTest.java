package fileanalyzer;

import com.podzirey.iostudy.fileanalyzer.FileAnalyzer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FileAnalyzerTest {

    @Test
    public void returnAllSentencesWithWordPublic(){
        FileAnalyzer fileAnalyzer = new FileAnalyzer();

        String content = "Hi! Friends.!? 2345^%#@,. Привет! _WWSSdd...";

        String[] sentences = fileAnalyzer.returnDividedSentences(content);
        String result = "";
        for (int i = 0 ;i < sentences.length; i++){
            result += sentences[i] + "\n";
        }
        assertEquals("Hi\n Friends\n\n\n 2345^%#@,\n Привет\n _WWSSdd\n", result);

    }
}