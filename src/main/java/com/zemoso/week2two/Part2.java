package com.zemoso.week2two;

public class Part2 {
    public int howMany(String stringa, String stringb){
        int count = 0;
        int found = stringb.indexOf(stringa);
        if (found > -1) {
            count++;
            while (stringb.indexOf(stringa, found) != -1 && found != -1) {
                count = count +1;
                found = stringb.indexOf(stringa, found+stringa.length());
            }
            count--;
        }
        else {
            count=0;
        }
        return count;
    }
    public void testHowMany() {
            System.out.println(howMany("GAA", "ATGAACGAATTGAATC") );
            System.out.println(howMany("AA", "ATAAAA"));
            System.out.println(howMany("abc", "cadyuih"));

        }

    public static void main (String[] args) {
        Part2 gene = new Part2();
        gene.testHowMany();
    }
}
