package com.zemoso.secondweek;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordsInFiles {
    private Map<String, List<String>> wordFileMap;

    public WordsInFiles() {
        wordFileMap = new HashMap<>();
    }

    private void addWordsFromFile(File f) {
        FileResource resource = new FileResource(f);
        for (String word : resource.words()) {
            if (wordFileMap.containsKey(word)) {
                List<String> fileList = wordFileMap.get(word);
                if (!fileList.contains(f.getName())) {
                    fileList.add(f.getName());
                }
            } else {
                List<String> fileList = new ArrayList<>();
                fileList.add(f.getName());
                wordFileMap.put(word, fileList);
            }
        }
    }

    public void buildWordFileMap() {
        wordFileMap.clear();
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            addWordsFromFile(f);
        }
    }

    public int maxNumber() {
        int max = 0;
        for (String word : wordFileMap.keySet()) {
            int size = wordFileMap.get(word).size();
            if (size > max) {
                max = size;
            }
        }
        return max;
    }
    // return words which lies in number(5) files.
    public List<String> wordsInNumFiles(int number) {
        ArrayList<String> words = new ArrayList<>();
        for (String word : this.wordFileMap.keySet()) {
            int size = this.wordFileMap.get(word).size();
            if (size == number) {
                words.add(word);
            }
        }
        return words;
    }

    public void printFilesIn(String word) {
        List<String> fileList = wordFileMap.get(word);
        for (String file : fileList) {
            System.out.println(file);
        }
    }

    public void tester() {
        buildWordFileMap();
        int number = maxNumber();
        List<String> words = wordsInNumFiles(number);
        System.out.println("Max num of files: " + number);
        System.out.println("Total of " + words.size() + " words that are in " + number + " files:");
        for (String word : words) {
            System.out.println("\"" + word + "\" appears in the files:");
            for (String file : wordFileMap.get(word)) {
                System.out.println("\t" + file);
            }
        }
    }

    public static void main(String[] args) {
        WordsInFiles wif = new WordsInFiles();
        wif.tester();
    }
}
