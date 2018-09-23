package com.aa.travianbot.model.buildings;

import com.aa.travianbot.model.BuildingsUtils;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Building {

    private int id;
    private String code;
    private int level;

    public String getName() {
        return BuildingsUtils.buildingNameFromCode(code);
    }
}
