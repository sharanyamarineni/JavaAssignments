package com.zemoso.fourthweek;

import edu.duke.FileResource;

import java.util.Arrays;

public class VigenereCipher {
    CaesarCipher[] ciphers;

    public VigenereCipher(int[] key) {
        //array of CaesarCipher objects.
        ciphers = new CaesarCipher[key.length];
        for (int i = 0; i < key.length; i++) {
            ciphers[i] = new CaesarCipher(key[i]);
        }
    }

    public String encrypt(String input) {
        StringBuilder answer = new StringBuilder();
        int i = 0;
        for (char c : input.toCharArray()) {
            int cipherIndex = i % ciphers.length;
            CaesarCipher thisCipher = ciphers[cipherIndex];
            answer.append(thisCipher.encryptLetter(c));
            i++;
        }
        return answer.toString();
    }

    public String decrypt(String input) {
        StringBuilder answer = new StringBuilder();
        int i = 0;
        for (char c : input.toCharArray()) {
            int cipherIndex = i % ciphers.length;
            CaesarCipher thisCipher = ciphers[cipherIndex];
            answer.append(thisCipher.decryptLetter(c));
            i++;
        }
        return answer.toString();
    }
    static void testencrypt () {
        int[] ROME = {17, 14, 12, 4};
        VigenereCipher vc = new VigenereCipher(ROME);
        String encryptedStart = "Tcmp-pxety mj nikhqv htee mrfhtii tyv";
        String clearText = new FileResource("/home/sharanyam/IdeaProjects/Coursera2/files/titus-small.txt").asString();
        String encrypted = vc.encrypt(clearText);
        System.out.println(encryptedStart.equals(encrypted.substring(0, encryptedStart.length())));
    }
    public String toString() {
        return Arrays.toString(ciphers);
    }

    public static void main(String[] args) {
        testencrypt();
    }
}
