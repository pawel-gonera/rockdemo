package org.rockexample.services;

import org.junit.jupiter.api.Test;
import org.rockexample.services.impl.CommaInputTokenizer;
import org.rockexample.services.impl.SimpleDivisorInputProcessor;
import org.rockexample.services.impl.StaticOutputMapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProcessorTest {

    private final Processor processor = new Processor(
            new CommaInputTokenizer(),
            new SimpleDivisorInputProcessor(),
            new StaticOutputMapper()
    );

    @Test
    void testProcessor() {
        List<String> result = processor.processData("1, 2, 4", "Animals");
        assertEquals(result.size(), 3);
        assertEquals("1 -> Mouse", result.get(0));
        assertEquals("2 -> Mouse, Cat", result.get(1));
        assertEquals("4 -> Mouse, Cat, Elephant", result.get(2));

        result = processor.processData("1,2,4", "Furnitures");
        assertEquals(result.size(), 3);
        assertEquals("1 -> Chair", result.get(0));
        assertEquals("2 -> Chair, Table", result.get(1));
        assertEquals("4 -> Chair, Table, Bed", result.get(2));
    }
}