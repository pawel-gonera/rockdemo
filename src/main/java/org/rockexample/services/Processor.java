package org.rockexample.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Processor {

    private InputTokenizer inputTokenizer;
    private InputProcessor inputProcessor;
    private OutputMapper outputMapper;

    Logger logger = LoggerFactory.getLogger(Processor.class);

    public Processor(
            @Autowired InputTokenizer inputTokenizer,
            @Autowired InputProcessor inputProcessor,
            @Autowired OutputMapper outputMapper) {
        this.inputTokenizer = inputTokenizer;
        this.inputProcessor = inputProcessor;
        this.outputMapper = outputMapper;
    }

    public List<String> processData(String input, String category) {
        ArrayList<String> result = new ArrayList<>();
        try {
            List<Integer> tokenList = inputTokenizer.processInputTokens(input);
            for (Integer token : tokenList) {
                List<Integer> processedTokens = inputProcessor.processToken(token);
                String mappedString = processedTokens.stream().map(t -> outputMapper.getMapping(category, t))
                        .collect(Collectors.joining(", "));
                result.add(String.format("%d -> %s", token, mappedString));
            }
        } catch (NumberFormatException ex) {
            logger.error("Invalid input string: " + input);
            return null;
        }
        return result;
    }
}
