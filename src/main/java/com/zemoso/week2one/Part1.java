package com.zemoso.week2one;

public class Part1 {
    public String findSimpleGene(String dna) {
        String output = "";
        int start = dna.indexOf("ATG");
        if(start == -1) {
            return "";
        }
        int stop = dna.indexOf("TAA", start);
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
        String a = "AAATCCCCTAACTAGATTAAGAAACC"; // no ATG
        String ap = "CBAATGCAGCGATAC"; // no TAA
        String apa = "ATGATAAGGATCCGA"; // no ATG or no TAA
        String app = "BBAGCATGCBAGCCAGCTAACAG"; // correct gene
        String appa = "ACBGCATGCCAGCABCTAACAG"; // diff is not multiple of 3

        System.out.println("gene = " + findSimpleGene(a));
        System.out.println("gene = " + findSimpleGene(ap));
        System.out.println("gene = " + findSimpleGene(apa));
        System.out.println("gene = " + findSimpleGene(app));
        System.out.println("gene = " + findSimpleGene(appa));
    }

    public static void main (String[] args) {
        Part1 gene = new Part1();
        gene.testSimpleGene();
   }
}
