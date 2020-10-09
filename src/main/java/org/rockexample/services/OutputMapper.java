package org.rockexample.services;

import java.util.List;

public interface OutputMapper {
    String getMapping(String category, int key);

    List<String> getCategories();
}
