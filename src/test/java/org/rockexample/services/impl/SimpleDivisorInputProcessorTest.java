package org.rockexample.services.impl;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimpleDivisorInputProcessorTest {

    private final SimpleDivisorInputProcessor processor = new SimpleDivisorInputProcessor();

    @Test
    void testInputProcessor() {
        List<Integer> tokenList = processor.processToken(4);
        assertEquals(3, tokenList.size());
        assertEquals(1, tokenList.get(0));
        assertEquals(2, tokenList.get(1));
        assertEquals(4, tokenList.get(2));
    }

    @Test
    void testInputProcessorEmpty() {
        List<Integer> tokenList = processor.processToken(0);
        assertEquals(0, tokenList.size());
    }

    @Test
    void testInputProcessorNegative() {
        List<Integer> tokenList = processor.processToken(-1);
        assertEquals(0, tokenList.size());
    }
}