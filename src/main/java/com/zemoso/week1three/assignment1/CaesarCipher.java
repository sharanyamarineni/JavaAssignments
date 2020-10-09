package com.zemoso.week1three.assignment1;

public class CaesarCipher {
    private String alphabet;
    private String shift;
    private int mainKey;


    public CaesarCipher(int key) {
        this.alphabet = "abcdefghijklmnopqrstuvwxyz";
        this.shift = this.alphabet.substring(key)+
                this.alphabet.substring(0,key);
        this.mainKey = key;
    }
    public String encrypt(String input) {
        StringBuilder sb = new StringBuilder(input);
        for(int i = 0; i < sb.length(); i++) {
            char curr = sb.charAt(i);
            if(this.alphabet.indexOf(curr) != -1){
                int idx = this.alphabet.indexOf(curr);
                char newChar = this.shift.charAt(idx);
                sb.setCharAt(i, newChar);
            }
        }
        return sb.toString();
    }

    public String decrypt(String input) {
        CaesarCipher cc = new CaesarCipher(26 - mainKey);
        return cc.encrypt(input);
    }

}
