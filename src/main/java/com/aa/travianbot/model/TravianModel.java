package com.aa.travianbot.model;

import com.aa.travianbot.model.fields.ResourceFields;
import com.aa.travianbot.model.progress.BuildingsInProgress;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TravianModel {

    private Resources resources = new Resources();
    private ResourceFields resourceFields = new ResourceFields();
    private BuildingsInProgress buildingsInProgress = new BuildingsInProgress();

}
