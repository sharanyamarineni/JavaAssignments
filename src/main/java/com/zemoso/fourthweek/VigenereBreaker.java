package com.zemoso.fourthweek;

import edu.duke.FileResource;

import java.util.*;

public class VigenereBreaker {

    public String sliceString(String message, int whichSlice, int totalSlices) {
        //REPLACE WITH YOUR CODE
        StringBuilder sb = new StringBuilder();
        for (int i = whichSlice; i < message.length(); i += totalSlices) {
            sb.append(message.charAt(i));
        }
        return sb.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        CaesarCracker CaesarCracker = new CaesarCracker('e');
        int aKey;
        int[] key = new int[klength];
        for(int k =0;k<klength;k++){
            aKey = CaesarCracker.getKey(sliceString(encrypted,k,klength));
            key[k] = aKey;
        }
        return key;
    }
    public HashSet<String> readDictionary(FileResource fr) {
        HashSet<String> h = new HashSet<String>();
        //Iterator<String> itr = h.iterator();
        for (String line : fr.lines()) {
            h.add(line.toLowerCase());//
        }

        for (String s : h)
        {
            System.out.println("Hashset output "+ s +"\t");
        }
        return h;
    }
    public int countWords(String message, HashSet<String> dict) {
        int counts = 0;
        ArrayList<String> MessageInWords = new ArrayList<String>(Arrays.asList(message.split("\\W")));
        for(int i = 0 ; i < MessageInWords.size(); i++ ) {
            if (dict.contains(MessageInWords.get(i).toLowerCase())) {
                // If not put ip in with a value of 1
                counts+=1;
            }
        }
        return counts;
    }
    public void breakVigenere () {
        FileResource fr = new FileResource("/home/sharanyam/IdeaProjects/Coursera2/files/secretmessage1.txt");
        String encrypted = fr.asString();
        int[] key = tryKeyLength(encrypted, 4, 'e');
        System.out.println(key);
        VigenereCipher cipher = new VigenereCipher(key);
        String decrypted = cipher.decrypt(encrypted);
        System.out.println("Decrypted Message: " + decrypted);
    }

    public static void main(String[] args) {
        VigenereBreaker vb = new VigenereBreaker();
       // System.out.println(vb.sliceString("abcdefghijklm", 0, 3));
        vb.breakVigenere();
    }
}
