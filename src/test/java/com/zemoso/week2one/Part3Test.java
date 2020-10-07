package com.zemoso.week2one;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Part3Test {
    Part3 p =new Part3();
    @Test
    void testOccurrences() {
        assertTrue(p.twoOccurrences("by", "A story by Abby Long"));
    }
    @Test
    void testOccurrences2() {
        assertFalse(p.twoOccurrences("b", "banana"));
    }
    @Test
    void testlastpart() {
        assertEquals("ana",p.lastPart("an", "banana"));
    }
    @Test
    void testlastpart2() {
        assertEquals("forest",p.lastPart("zoo", "forest"));
    }
}