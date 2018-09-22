package com.aa.travianbot.model.fields;

public enum ResourceFieldType {
    LUMBER, CLAY, IRON, CROP;

    public static ResourceFieldType getFieldTypeByFielName(String fieldName) {
        if (fieldName.contains("Woodcutter")) {
            return LUMBER;
        } else if (fieldName.contains("Cropland")) {
            return CROP;
        } else if (fieldName.contains("Clay Pit")) {
            return CLAY;
        } else if (fieldName.contains("Iron Mine")) {
            return IRON;
        }

        throw new RuntimeException("Field not valid: " + fieldName);
    }
}
