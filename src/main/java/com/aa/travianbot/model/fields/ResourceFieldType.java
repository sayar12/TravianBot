package com.aa.travianbot.model.fields;

import java.util.Random;

import static com.aa.travianbot.model.buildings.BuildingsUtils.*;

public enum ResourceFieldType {
    LUMBER, CLAY, IRON, CROP;

    public static ResourceFieldType getFieldTypeByFielName(String fieldName) {
        if (fieldName.contains(WOODCUTTER)) {
            return LUMBER;
        } else if (fieldName.contains(CROPLAND)) {
            return CROP;
        } else if (fieldName.contains(CLAY_PIT)) {
            return CLAY;
        } else if (fieldName.contains(IRON_MINE)) {
            return IRON;
        }

        throw new RuntimeException("Field not valid: " + fieldName);
    }

    public static ResourceFieldType randomResourceType() {
        int rand = new Random().nextInt(4);
        switch (rand % 4) {
            case 0: return LUMBER;
            case 1: return CLAY;
            case 2: return IRON;
            case 3: return CROP;
            default: throw new RuntimeException("randomResourceType error: rand=" + rand);
        }
    }
}
