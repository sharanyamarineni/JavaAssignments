package com.zemoso.week2three;

import edu.duke.FileResource;
import edu.duke.StorageResource;

public class Three {
    public static int findStopCodon(String dna, int startCodon, String stopCodon) {
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

    public static String findGene(String dna, int where) {
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

    public static StorageResource getAllGenes(String dna){

        int start = 0;
        StorageResource data = new StorageResource();
        dna = dna.toUpperCase();
        while ( true ) {
            String gene = findGene(dna, start);
            if (gene.isEmpty()) { break; }
            data.add(gene);
            start = dna.indexOf(gene, start) + gene.length();
        }
        return data;
    }

    public static void testgetAllGenes(){
        String dna = "ATGxxxyyyTAAyyyTGAxxx";
        StorageResource genes = getAllGenes(dna);
        for(String s: genes.data()){
            System.out.println(s);
        }
    }

    public static float cgRatio(String dna){

        int count = 0;
        String str = "CG";

        for(int i=0; i<dna.length(); i++){
            if(dna.charAt(i) == str.charAt(0) || dna.charAt(i) == str.charAt(1)){
                count++;
            }
        }
        return (float)count/dna.length();
    }

    public static int countCTG(String dna){

        int count = 0, start = 0;

        while(true){
            int startIndex = dna.indexOf("CTG", start);
            if(startIndex == -1){
                break;
            }
            count++;
            start = startIndex + 2;
        }
        return count;
    }

    public static void testCTG(){
        System.out.println("count of ctg: " + countCTG("CTGabcCTGtyuCTGiopCTGfCTG"));
    }

    public static void processGenes(StorageResource sr){

        int greaternine = 0;
        int countcg = 0;
        int longest = 0;
        int total = 0;

        for(String s: sr.data()){


            if(!findGene(s, 0).isEmpty()){
                total++;

                if(findGene(s,0).length() > 60){
                    System.out.println("Genes more than 9 chars " + s);
                    greaternine++;
                }

                if(cgRatio(s) > 0.35){
                    System.out.println("cg ratio greater than 0.35" + s);
                    countcg++;
                }

                if(s.length() > longest){
                    longest = s.length();
                }
            }
        }


        System.out.println("number of genes that are 60+ chars: " + greaternine);
        System.out.println("count of CG Ratio: " + countcg);
        System.out.println("The length of the longest gene: " + longest);
        System.out.println("Total Genes: " + total);
    }

    public static void testProcessGenes(){

        String s1 = "ATGghjTAAjkiATGyuiTAG";
        StorageResource geneList = getAllGenes(s1);
        processGenes(geneList);

        String s2 = "ATGwdftyuTAAyyyATGcvbfghghjrtyxxxTAG";
        geneList = getAllGenes(s2);
        processGenes(geneList);

        String s3 = "ATGCGCCyyTAAtyuATGxfghrtyCGGGGCxxxTAG";
        geneList = getAllGenes(s3);
        processGenes(geneList);

        String s4 = "ATGfghtyuasdertTAG";
        geneList = getAllGenes(s4);
        processGenes(geneList);

    }


    public static void testProcesswithRealDNA(){

        FileResource fr = new FileResource("GRch38dnapart.fa");
        String dna = fr.asString();
        System.out.println("DNA: " + dna.toUpperCase());
        System.out.println("Total CTGs: " + countCTG(dna));

        StorageResource geneList = getAllGenes(dna);
        processGenes(geneList);

    }
    public static void main(String[] args) {

        testgetAllGenes();
//        System.out.println(cgRatio("ATGCCATAG"));
 //      testProcessGenes();
     //  testProcesswithRealDNA();
//        testCTG();

    }

}
