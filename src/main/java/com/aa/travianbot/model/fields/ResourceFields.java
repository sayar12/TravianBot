package com.aa.travianbot.model.fields;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ResourceFields {

    private Map<Integer, ResourceField> resourceFields = new HashMap<>();

    public void update(ResourceField resourceField) {
        resourceFields.put(resourceField.getId(), resourceField);
    }

    public ResourceField getMinimumResourceField() {
        return getMinimumResourceField(null);
    }

    public ResourceField getMinimumResourceField(ResourceFieldType type) {
        return resourceFields.entrySet().stream()
                .map(Map.Entry::getValue)
                .filter(resourceField -> type == null || resourceField.getType().equals(type))
                .reduce((left, right) -> left.getLevel() < right.getLevel() ? left : right)
                .orElseThrow(() -> new RuntimeException("Exception resourceFields is empty"));
    }
}
