package assignment6;

import java.util.Arrays;

public class Vampire {
    final static int START = 10, END = 10000;
    public static void main(String[] args) {
        int c=0;
        for (int i = START; i < END; i++) {
            if(c==100){
                break;
            }
            String sFangA = String.valueOf(i);
            boolean trailingZeros = sFangA.endsWith("0");
            int max = (int) Math.min(END, Math.pow(10, sFangA.length()));

            for (long j = i; j < max; j++) {
                long candidate = i * j;
                if (candidate % 9 == (i + j) % 9) {
                    String sCandidate = String.valueOf(candidate);
                    String sFangB = String.valueOf(j);
                    if ((trailingZeros && sFangB.endsWith("0")) == false) {
                        char[] cVampire = sCandidate.toCharArray();
                        Arrays.sort(cVampire);

                        char[] cFangs = (sFangA + sFangB).toCharArray();
                        Arrays.sort(cFangs);
                        if (Arrays.equals(cVampire, cFangs)) {
                            c++;
                            System.out.println(sCandidate);
                        }

                    }
                }
            }

        }
    }
}


