package com.zemoso.firstweek.weekone;

public class WordPlay {
    public boolean isVowel(char ch){
        if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
            return true;
        }
        return false;
    }
    public String replaceVowels(String s, char ch){
        StringBuilder sb =new StringBuilder(s);
        int i;
        for(i=0;i<s.length();i++){
            if(isVowel(s.charAt(i))){
                sb.setCharAt(i,'*');
            }
        }
        return sb.toString();
    }
    public String emphasize(String s,char ch){
        StringBuilder sb =new StringBuilder(s);
        int i;
        for(i=0;i<sb.length();i++){
            char curr= sb.charAt(i);
            if((curr==ch)&&(i%2==0)){
                sb.setCharAt(i,'*');
            }
            else if((curr==ch)&&(i%2!=0)){
                sb.setCharAt(i,'+');
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        WordPlay w = new WordPlay();
        System.out.println(w.isVowel('e'));
        System.out.println(w.isVowel('r'));
        System.out.println(w.replaceVowels("hello world",'*'));
        System.out.println(w.emphasize("dna ctgaaactga",'a'));
        System.out.println(w.emphasize("Mary Bella Abracadabra",'a'));
    }
}
