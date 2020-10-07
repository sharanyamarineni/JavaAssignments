package com.zemoso.week2one;

import edu.duke.*;
public class Part4 {
    public void printUrls(String url) {
        URLResource ur = new URLResource(url);
        for(String word : ur.words()) {
            if(word.toLowerCase().indexOf("youtube.com") != -1) {
                int start = word.indexOf("\"");
                int end = word.indexOf("\"", start+1);
                System.out.println(word.substring(start+1, end));

            }
        }
    }

    public void testUrl() {
        printUrls("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
    }

    public static void main(String[] args) {
        Part4 part = new Part4();
        part.testUrl();
    }
}
