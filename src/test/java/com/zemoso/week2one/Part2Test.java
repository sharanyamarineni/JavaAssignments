package com.zemoso.week2one;

import com.zemoso.week2one.Part1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Part2Test {
    Part2 p =new Part2();
    @Test
    void testGene() {
        assertEquals("atgabagtbacctaa",p.findSimpleGene("bcgcatgabagtbacctaacag","ATG","TAA"));
    }
    @Test
    void testGene2() {
        assertEquals("",p.findSimpleGene("AAATCCCCTAACTAGATTAAGAAACC","ATG","TAA"));
    }
}