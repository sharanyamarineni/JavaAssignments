package com.zemoso.week2one;

import com.zemoso.week2one.Part1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Part1Test {
    Part1 p =new Part1();
    @Test
    void testGene() {
        assertEquals("",p.findSimpleGene("AAATCCCCTAACTAGATTAAGAAACC"));
    }
    @Test
    void testGene2() {
        assertEquals("ATGCBAGCCAGCTAA",p.findSimpleGene("BBAGCATGCBAGCCAGCTAACAG"));
    }
}