package org.rockexample.services.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StaticOutputMapperTest {

    private final StaticOutputMapper mapper = new StaticOutputMapper();

    @Test
    void testMapper() {
        assertEquals("Mouse", mapper.getMapping("Animals", 1));
        assertEquals("Cat", mapper.getMapping("Animals", 2));
        assertEquals("Dog", mapper.getMapping("Animals", 3));
        assertEquals("Elephant", mapper.getMapping("Animals", 4));
    }

    @Test
    void testBadMapping() {
        assertEquals("",  mapper.getMapping("wrong category", 1));
        assertEquals("", mapper.getMapping("Animals", 10));
    }

}