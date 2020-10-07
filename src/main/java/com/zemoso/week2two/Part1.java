package com.zemoso.week2two;

public class Part1 {
    public int findStopCodon(String dna, int startCodon, String stopCodon) {
        int curr = dna.indexOf(stopCodon, startCodon + 3);
        while(curr != -1) {
            int diff = curr - startCodon;
            if(diff % 3 == 0) {
                return curr;
            } else {
                curr = dna.indexOf(stopCodon, curr + 1);
            }
        }
        return dna.length();
    }


    public String findGene(String dna, int where) {
        int startIndex = dna.indexOf("ATG", where);
        if(startIndex == -1) {
            return "";
        }
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        int minIndex = Math.min(taaIndex, Math.min(tagIndex, tgaIndex));
        if(minIndex == dna.length()) {
            return "";
        }
        return dna.substring(startIndex, minIndex + 3);
    }



    public void printAllGenes(String dna) {
        int start = 0;
        while(true) {
            String gene = findGene(dna, start);
            if(gene.isEmpty()) {
                break;
            }
            System.out.println(gene);
            start = dna.indexOf(gene, start) + gene.length();
        }
    }
    public void test() {
        printAllGenes("AATGGCTTGAAATGATTTAGATGTCGTAAATGTGG");
    }

    public void testFindStopCodon() {
        String dna = "ATGTCGTGA";
        System.out.println(findStopCodon(dna, 0, "TGA"));
        dna = "ATGTCGTGTAA";
        System.out.println(findStopCodon(dna, 0, "TAA"));
        dna = "ATGTCGTGCTAA";
        System.out.println(findStopCodon(dna, 0, "TAA"));
    }

    public void testFindGene() {
        String dna = "ATGTCGTGA";
        System.out.println(findGene(dna, 0));
    }

    public static void main(String args[]) {
        Part1 find = new Part1();
        find.printAllGenes("ATGxxxyyyTAAyyyTGAxxx");
    }
}
