package com.aa.travianbot.bot.scheduler.executors;

import com.aa.travianbot.bot.browser.TravianBrowser;
import com.aa.travianbot.bot.scheduler.TravianBotSchedulerDao;
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

    private final TravianBotSchedulerDao travianBotSchedulerDao;
    private final TravianBrowser travianBrowser;
    private final TravianModel travianModel;

    @Autowired
    public ConstructionExecutor(TravianBotSchedulerDao travianBotSchedulerDao, TravianBrowser travianBrowser, TravianModel travianModel) {
        this.travianBotSchedulerDao = travianBotSchedulerDao;
        this.travianBrowser = travianBrowser;
        this.travianModel = travianModel;
    }

    public void execute() {
        log.info("ConstructionExecutor - execute()");

        if (travianModel.getBuildingsInProgress().isEmpty()) {

            // Upgrade fields as first thing if they are still level 0
            ResourceField minimumResourceField = travianModel.getResourceFields().getMinimumResourceField(ResourceFieldType.randomResourceType());
            if (minimumResourceField.getLevel() == 0) {
                travianBrowser.getDorf1Browser().upgradeField(minimumResourceField);
                logUpgradeFieldAction(minimumResourceField);
                return;
            }

            // Build Warehouse if not already there
            if (travianModel.getBuildings().findByName(BuildingsUtils.WAREHOUSE).isEmpty()) {
                travianBrowser.getDorf2Browser().buildNew(BuildingsUtils.WAREHOUSE);
                logBuiltBuilding(BuildingsUtils.WAREHOUSE);
                return;
            }

            // Build Warehouse if not already there
            if (travianModel.getBuildings().findByName(BuildingsUtils.GRANARY).isEmpty()) {
                travianBrowser.getDorf2Browser().buildNew(BuildingsUtils.GRANARY);
                return;
            }

            // Upgrade fields
            travianBrowser.getDorf1Browser().upgradeField(minimumResourceField);
            logUpgradeFieldAction(minimumResourceField);
        }
    }

    private void logUpgradeFieldAction(ResourceField resourceField) {
        travianBotSchedulerDao.getActions().add(ExecutedAction.builder().action(
                "Upgraded " + resourceField.getType() + " to " + (resourceField.getLevel() + 1) + " [id=" + resourceField.getId() + "]").build()
        );
    }

    private void logBuiltBuilding(String buildingName) {
        travianBotSchedulerDao.getActions().add(ExecutedAction.builder().action(
                "Build " + buildingName + " level 1"
        ).build());
    }


}
