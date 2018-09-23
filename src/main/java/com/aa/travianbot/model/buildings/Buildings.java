package com.aa.travianbot.model.buildings;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class Buildings {

    private Map<Integer, Building> buildings = new HashMap<>();

    public void update(Building building) {
        buildings.put(building.getId(), building);
    }

    public List<Building> findByName(String buildingName) {
        return buildings.entrySet().stream()
                .map(Map.Entry::getValue)
                .filter(building -> building.getName().equals(buildingName))
                .collect(Collectors.toList());
    }
}
