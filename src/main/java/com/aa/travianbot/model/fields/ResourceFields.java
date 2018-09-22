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
}
