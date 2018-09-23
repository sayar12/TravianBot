package com.aa.travianbot.bot.scheduler.executors;

import com.aa.travianbot.bot.browser.TravianBrowser;
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
            ResourceField minimumResourceField = travianModel.getResourceFields().getMinimumResourceField(ResourceFieldType.randomResourceType());
            travianBrowser.getDorf1Browser().upgradeField(minimumResourceField);
        }
    }

}
