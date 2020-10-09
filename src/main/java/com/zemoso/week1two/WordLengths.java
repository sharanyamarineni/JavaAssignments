package com.zemoso.week1two;

import edu.duke.FileResource;

public class WordLengths {
    public void countWordLengths(FileResource resource, int counts[]){
        for(String word : resource.words()){
            int len = word.length();
            if (!Character.isLetter(word.charAt(0))){
                len--;
            }
            if (!Character.isLetter(word.charAt(word.length()-1)) && word.length()!=1){
                len--;
            }
            counts[len]++;
        }
        int max=0;
        int index=0;
        for (int i=1;i<counts.length;i++){
            if(counts[i]>max){
                max=counts[i];
                index=i;
            }

        }
        System.out.println("word len which has high freq: " + index);
    }

    public int indexOfMax(int[] values){
        int in = 0;
        int max = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i]>max){
                max = values[i];
                in = i;
            }

        }
        return in;
    }

    public void testCountWordLengths(){
        int[] counts = new int[31];
        FileResource resource = new FileResource();
        countWordLengths(resource,counts);
    }

    public static void main(String[] args) {
        WordLengths w = new WordLengths();
        w.testCountWordLengths();
    }
}
