package org.rockexample.services.impl;

import org.rockexample.services.InputProcessor;
import org.rockexample.services.InputTokenizer;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommaInputTokenizer implements InputTokenizer {
    @Override
    public List<Integer> processInputTokens(String input) {
        return Arrays.asList(input.split(",")).stream()
                .mapToInt(num -> Integer.parseInt(num.strip()))
                .boxed()
                .collect(Collectors.toList());
    }
}
