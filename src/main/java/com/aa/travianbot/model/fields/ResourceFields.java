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

    public ResourceField getMinimumResourceField(ResourceFieldType type) {
        ResourceField minimumResourceField = null;

        for (int resourceFieldId : resourceFields.keySet()) {
            ResourceField currentResourceField = resourceFields.get(resourceFieldId);
            if (currentResourceField.getType().equals(type)) {
                if (minimumResourceField == null) {
                    minimumResourceField = currentResourceField;
                    continue;
                }

                if (minimumResourceField.getLevel() > currentResourceField.getLevel()) {
                    minimumResourceField = currentResourceField;
                }
            }
        }

        return minimumResourceField;
    }
}
