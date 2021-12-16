package com.podzirey.iostudy.fileanalyzer;

import java.io.*;
import java.util.Scanner;

public class FileAnalyzer {


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter path to file "); //story.txt
        String path = scanner.nextLine();
        File file = new File(path);
        System.out.println(file.isFile());
        if (!file.isFile()){
            System.out.println("Error! Invalid path!");
        }

        System.out.println("Enter a word for calculating duplicates in file "); // school
        String word = scanner.nextLine();
        if (word == ""){
            System.out.println("Error! You entered nothing!");
        }

        String content = readContent(path);
        int duplicates = calculateWordDuplicates(word, content);
        System.out.println("There are " + duplicates + " duplicates of word " + word + " in path " + path);
        System.out.println();

        String[] words = returnAllSentencesWithWord(word, content);
        System.out.println("There are following sentences with word " + word + " in path " + path);
        for (int i = 0 ;i < words.length;i++){
            System.out.println(words[i]);
        }
    }

    static String readContent(String path) throws IOException {

        File pathToFile = new File(path);
        InputStream inputStream = new FileInputStream(pathToFile);

        int fileLength = (int) pathToFile.length();
        byte[] contentArray = new byte[fileLength];
        inputStream.read(contentArray);

        inputStream.close();

        return new String(contentArray);
    }

    static int calculateWordDuplicates(String word, String content){
        int count = 0;
        String[] words = content.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word)){
                count++;
            }
        }

        return count;
    }

    public static String[] returnAllSentencesWithWord(String word, String content){
        String[] words = content.split("[\\.\\!\\?]");

        return words;
    }

    //для теста
    public String[] returnDividedSentences(String content){
        String[] words = content.split("[\\.\\!\\?]");

        return words;
    }
}
