package com.zemoso.fourthweek;

import edu.duke.FileResource;

public class CaesarCracker {
    char mostCommon;

    public CaesarCracker() {
        mostCommon = 'e';
    }

    public CaesarCracker(char c) {
        mostCommon = c;
    }

    public int[] countLetters(String message){
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for(int k=0; k < message.length(); k++){
            int dex = alph.indexOf(Character.toLowerCase(message.charAt(k)));
            if (dex != -1){
                counts[dex] += 1;
            }
        }
        return counts;
    }

    public int maxIndex(int[] vals){
        int maxDex = 0;
        for(int k=0; k < vals.length; k++){
            if (vals[k] > vals[maxDex]){
                maxDex = k;
            }
        }
        return maxDex;
    }

    public int getKey(String encrypted){
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int mostCommonPos = mostCommon - 'a';
        int dkey = maxDex - mostCommonPos;
        if (maxDex < mostCommonPos) {
            dkey = 26 - (mostCommonPos-maxDex);
        }
        return dkey;
    }

    public String decrypt(String encrypted){
        int key = getKey(encrypted);
        CaesarCipher cc = new CaesarCipher(key);
        return cc.decrypt(encrypted);

    }
   static void testdecrypt () {
        CaesarCracker cc = new CaesarCracker();
        String titusClear = new FileResource("/home/sharanyam/IdeaProjects/Coursera2/files/titus-small.txt").asString();
        String titusEncrypted = new FileResource("/home/sharanyam/IdeaProjects/Coursera2/files/titus-small_key5.txt").asString();
        System.out.println(titusClear.equals(cc.decrypt(titusEncrypted)));
    }

    public static void main(String[] args) {
        testdecrypt();
    }
    }
