package com.zemoso.week2one;

public class Part3 {
    public boolean twoOccurrences(String stringa, String stringb) {
        int temp = stringb.indexOf(stringa);
        if(temp != -1) {
            int temp2 = stringb.indexOf(stringa, temp+1);
            if( temp2 != -1) {
                return true;
            }
        } else {
            return false;
        }
        return false;
    }

    public void testing() {
        System.out.println(twoOccurrences("by", "A story by Abby Long"));
        System.out.println(twoOccurrences("a", "banana"));
        System.out.println(twoOccurrences("atg", "ctgtatgta"));

        System.out.println(lastPart("an", "banana"));
        System.out.println(lastPart("zoo", "forest"));
        System.out.println(lastPart("zoo", "hiizoohello"));
    }

    public String lastPart(String stringa, String stringb) {
        if(stringb.indexOf(stringa) != -1) {
            int index = stringb.indexOf(stringa);
            return stringb.substring(index+stringa.length(), stringb.length());
        } else {
            return stringb;
        }
    }

    public static void main(String[] args) {
        Part3 part = new Part3();
        part.testing();
    }
}
