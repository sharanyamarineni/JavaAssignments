package com.zemoso.week2one;

public class Part2 {
    public String findSimpleGene(String dna, String startCodon, String stopCodon) {
        String output = "";

        if( Character.isUpperCase(dna.charAt(0)) ) {
            startCodon = startCodon.toUpperCase();
            stopCodon = stopCodon.toUpperCase();
        } else {
            startCodon = startCodon.toLowerCase();
            stopCodon = stopCodon.toLowerCase();
        }

        int start = dna.indexOf(startCodon);
        if(start == -1) {
            return "";
        }
        int stop = dna.indexOf(stopCodon, start);
        if(stop == -1) {
            return "";
        }

        if((stop - start) % 3 == 0) {
            return dna.substring(start, stop+3);
        }
        else {
            return "";
        }
    }

    public void testSimpleGene() {
        String s1 = "AAATCCCCTAACTAGATTAAGAAACC"; // no ATG
        String s2 = "CBAATGCAGCGATAC"; // no TAA
        String s3 = "ATGATAAGGATCCGA"; // no ATG or no TAA
        String s4 = "bcgcatgabagtbacctaacag"; // correct gene
        String s5 = "ACBGCATGCCAGCABCTAACAG"; // diff is not multiple of 3

        System.out.println("gene = " + findSimpleGene(s1,"ATG", "TAA"));
        System.out.println("gene = " + findSimpleGene(s2,"ATG", "TAA"));
        System.out.println("gene = " + findSimpleGene(s3,"ATG", "TAA"));
        System.out.println("gene = " + findSimpleGene(s4,"ATG", "TAA"));
        System.out.println("gene = " + findSimpleGene(s5,"ATG", "TAA"));
    }

    public static void main (String[] args) {
        Part2 gene = new Part2();
        gene.testSimpleGene();
    }
}
