package com.aa.travianbot.model.progress;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BuildingsInProgress {

    private List<BuildingInProgress> buildingsInProgress = new ArrayList();
}
