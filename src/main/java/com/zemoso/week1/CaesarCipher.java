package com.zemoso.week1;
import edu.duke.*;
import org.apache.commons.csv.*;

import java.io.File;
public class CaesarCipher {
    public String encrypt(String input,int key){
        StringBuilder sb = new StringBuilder (input);

        String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabets2 = "abcdefghijklmnopqrstuvwxyz";

        String shift = alphabets.substring(key)+ alphabets.substring(0,key);
        String shift2 = alphabets2.substring(key)+ alphabets2.substring(0,key);
        int i;
        for (i = 0;i < sb.length();i++){
            char curr = sb.charAt(i);

            if (alphabets.indexOf(curr)!=-1){
                int in = alphabets.indexOf(curr);
                char shiftChar = shift.charAt(in);
                sb.setCharAt(i,shiftChar);
            }
            if (alphabets2.indexOf(curr)!=-1){
                int in = alphabets2.indexOf(curr);
                char shiftChar = shift2.charAt(in);
                sb.setCharAt(i,shiftChar);
            }
        }
        return sb.toString();
    }
    public String encryptTwoKeys(String input, int key1, int key2){
        StringBuilder sb = new StringBuilder (input);

        String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabets2 = "abcdefghijklmnopqrstuvwxyz";
        String shiftu1 = alphabets.substring(key1)+ alphabets.substring(0,key1);
        String shiftu2 = alphabets.substring(key2)+ alphabets.substring(0,key2);
        String shiftl1 = alphabets2.substring(key1)+ alphabets2.substring(0,key1);
        String shiftl2 = alphabets2.substring(key2)+ alphabets2.substring(0,key2);

        int i;
        for (i = 0;i < sb.length();i++) {
            char curr = sb.charAt(i);
            if (i % 2 == 0) {
                if (alphabets.indexOf(curr) != -1) {
                    int in = alphabets.indexOf(curr);
                    char shiftChar = shiftu1.charAt(in);
                    sb.setCharAt(i, shiftChar);
                } else if (alphabets2.indexOf(curr) != -1) {
                    int in = alphabets2.indexOf(curr);
                    char shiftChar = shiftl1.charAt(in);
                    sb.setCharAt(i, shiftChar);
                }
            }
            else {
                if (alphabets.indexOf(curr) != -1) {
                    int in = alphabets.indexOf(curr);
                    char shiftChar = shiftu2.charAt(in);
                    sb.setCharAt(i, shiftChar);
                }
                if (alphabets2.indexOf(curr) != -1) {
                    int in = alphabets2.indexOf(curr);
                    char shiftChar = shiftl2.charAt(in);
                    sb.setCharAt(i, shiftChar);
                }
            }

        }
        return sb.toString();
    }

    public void testCaesar(){
//        FileResource fr = new FileResource();
//        String message = fr.asString();
        String encrypted = encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 15);
        System.out.println("key is " + 23 + "\n" + encrypted);
        //System.out.println(encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 8, 21));
    }

    public static void main(String[] args) {
        CaesarCipher c =new CaesarCipher();
        c.testCaesar();
    }
}
