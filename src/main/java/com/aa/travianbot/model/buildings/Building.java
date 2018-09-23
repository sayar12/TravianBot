package com.aa.travianbot.model.buildings;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Building {

    private int id;
    private String code;
    private String name;
    private int level;

}
