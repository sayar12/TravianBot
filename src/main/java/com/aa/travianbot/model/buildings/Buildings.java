package com.aa.travianbot.model.buildings;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Buildings {

    private Map<Integer, Building> buildings = new HashMap<>();

    public void update(Building building) {
        buildings.put(building.getId(), building);
    }

}
