package org.rockexample.services.impl;

import org.rockexample.services.InputProcessor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleDivisorInputProcessor implements InputProcessor {
    @Override
    public List<Integer> processToken(Integer input) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i=1; i<=input; i++) {
            if (input%i == 0) {
                result.add(i);
            }
        }
        return result;
    }
}
