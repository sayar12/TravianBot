package com.aa.travianbot.model;

import com.aa.travianbot.model.fields.ResourceFields;
import com.aa.travianbot.model.hero.Hero;
import com.aa.travianbot.model.progress.BuildingInProgress;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class TravianModel {

    private Resources resources = new Resources();
    private ResourceFields resourceFields = new ResourceFields();
    private List<BuildingInProgress> buildingsInProgress = new ArrayList<>();
    private Hero hero = new Hero();

}
