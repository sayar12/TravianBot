package com.aa.travianbot.model.fields;

import lombok.Data;

@Data
public class ResourceField {

    private int id;
    private int level;
    private ResourceFieldType type;

    public void setType(ResourceFieldType type) {
        this.type = type;
    }

    public ResourceFieldType getType() {
        return type;
    }
}
