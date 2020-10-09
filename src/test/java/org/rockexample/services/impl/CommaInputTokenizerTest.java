package org.rockexample.services.impl;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommaInputTokenizerTest {
    private final CommaInputTokenizer tokenizer = new CommaInputTokenizer();

    @Test
    void testCommaInputTokenizer() {
        List<Integer> tokens = tokenizer.processInputTokens("1,2,3,4");
        assertEquals(4, tokens.size());
        assertEquals(1, tokens.get(0));
        assertEquals(2, tokens.get(1));
        assertEquals(3, tokens.get(2));
        assertEquals(4, tokens.get(3));
    }

    @Test
    void testCommaInputTokenizerSyntax() {
        assertThrows(NumberFormatException.class, () -> {
            tokenizer.processInputTokens("1;2");
        });
    }
}