package com.zemoso.fourthweek;

public class CaesarCipher {
    private String alphabet;
    private String shiftedAlphabet;
    private int theKey;

    public CaesarCipher(int key) {
        theKey = key;
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
        alphabet = alphabet + alphabet.toLowerCase();
        shiftedAlphabet = shiftedAlphabet + shiftedAlphabet.toLowerCase();
    }

    private char transformLetter(char c, String from, String to) {
        int idx = from.indexOf(c);
        if (idx != -1) {
            return to.charAt(idx);
        }
        return c;
    }

    public char encryptLetter(char c) {
        return transformLetter(c, alphabet, shiftedAlphabet);
    }

    public char decryptLetter(char c) {
        return transformLetter(c, shiftedAlphabet, alphabet);
    }

    private String transform(String input, String from, String to){
        StringBuilder sb = new StringBuilder(input);
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            c = transformLetter(c, from, to);
            sb.setCharAt(i, c);
        }
        return sb.toString();
    }

    public String encrypt(String input) {
        return transform(input, alphabet, shiftedAlphabet);
    }

    public String decrypt(String input) {
        return transform(input, shiftedAlphabet, alphabet);
    }

    public String toString() {
        return "" + theKey;
    }
    void testencryptDecryptLetter (CaesarCipher cc) {
        System.out.println(cc.decryptLetter(cc.encryptLetter('d'))=='d');
        System.out.println(cc.decryptLetter(cc.encryptLetter('Q'))=='Q');
    }
    void testencryptDecryptString (CaesarCipher cc) {

        System.out.println(cc.decrypt(cc.encrypt("Hello")).equals("Hello"));
        System.out.println(cc.decrypt(cc.encrypt("A.B$cD")).equals("A.B$cD"));
    }
    public static void main(String[] args) {
        CaesarCipher c = new CaesarCipher(14);
        c.testencryptDecryptLetter(c);
        CaesarCipher cc = new CaesarCipher(12);
        cc.testencryptDecryptString(cc);
    }
}
