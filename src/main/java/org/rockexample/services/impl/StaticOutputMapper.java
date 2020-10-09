package org.rockexample.services.impl;

import org.rockexample.services.OutputMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

@Component
public class StaticOutputMapper implements OutputMapper {
    private HashMap<String, HashMap<Integer, String>> mapTable;

    @Override
    public String getMapping(String category, int key) {
        if (mapTable == null) {
            init();
        }

        HashMap<Integer, String> categoryMap = mapTable.get(category);
        if (categoryMap == null)
            return "";
        String result = categoryMap.get(key);
        if (result == null)
            return "";
        return result;
    }

    @Override
    public List<String> getCategories() {
        List<String> result = new ArrayList<>();
        result.add("Animals");
        result.add("Furnitures");
        return result;
    }

    private void init() {
        mapTable = new HashMap<>();
        HashMap<Integer, String> animals = new HashMap<>();
        animals.put(1, "Mouse");
        animals.put(2, "Cat");
        animals.put(3, "Dog");
        animals.put(4, "Elephant");

        HashMap<Integer, String> furnitures = new HashMap<>();
        furnitures.put(1, "Chair");
        furnitures.put(2, "Table");
        furnitures.put(3, "Cabinet");
        furnitures.put(4, "Bed");

        mapTable.put("Animals", animals);
        mapTable.put("Furnitures", furnitures);
    }
}
