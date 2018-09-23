package com.aa.travianbot.bot.scheduler.executors;

import com.aa.travianbot.bot.browser.TravianBrowser;
import com.aa.travianbot.model.BuildingsUtils;
import com.aa.travianbot.model.TravianModel;
import com.aa.travianbot.model.fields.ResourceField;
import com.aa.travianbot.model.fields.ResourceFieldType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConstructionExecutor {

    private final TravianBrowser travianBrowser;
    private final TravianModel travianModel;

    @Autowired
    public ConstructionExecutor(TravianBrowser travianBrowser, TravianModel travianModel) {
        this.travianBrowser = travianBrowser;
        this.travianModel = travianModel;
    }

    public void execute() {
        log.info("ConstructionExecutor - execute()");

        if (travianModel.getBuildingsInProgress().isEmpty()) {

            if (travianModel.getBuildings().findByName(BuildingsUtils.WAREHOUSE).isEmpty()) {
                travianBrowser.getDorf2Browser().buildNew(BuildingsUtils.WAREHOUSE);
                return;
            }

            if (travianModel.getBuildings().findByName(BuildingsUtils.GRANARY).isEmpty()) {
                travianBrowser.getDorf2Browser().buildNew(BuildingsUtils.GRANARY);
                return;
            }

            ResourceField minimumResourceField = travianModel.getResourceFields().getMinimumResourceField(ResourceFieldType.randomResourceType());
            travianBrowser.getDorf1Browser().upgradeField(minimumResourceField);
        }
    }

}
