package com.aa.travianbot.bot.scheduler.executors.constructor;

import com.aa.travianbot.bot.browser.TravianBrowser;
import com.aa.travianbot.bot.scheduler.TravianBotSchedulerDao;
import com.aa.travianbot.bot.scheduler.executors.ExecutedAction;
import com.aa.travianbot.model.TravianModel;
import com.aa.travianbot.model.fields.ResourceField;
import com.aa.travianbot.model.fields.ResourceFieldType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.aa.travianbot.model.BuildingsUtils.ALL_RESOURCE;

@Service
@Slf4j
public class ConstructionExecutor {

    private final TravianBotSchedulerDao travianBotSchedulerDao;
    private final TravianBrowser travianBrowser;
    private final TravianModel travianModel;
    private final ConstructionExecutorConfiguration constructionExecutorConfiguration;


    @Autowired
    public ConstructionExecutor(TravianBotSchedulerDao travianBotSchedulerDao, TravianBrowser travianBrowser, TravianModel travianModel, ConstructionExecutorConfiguration constructionExecutorConfiguration) {
        this.travianBotSchedulerDao = travianBotSchedulerDao;
        this.travianBrowser = travianBrowser;
        this.travianModel = travianModel;
        this.constructionExecutorConfiguration = constructionExecutorConfiguration;
    }

    public void execute() {
        log.info("ConstructionExecutor - execute()");

        if (travianModel.getBuildingsInProgress().isEmpty()) {

            List<ConstructionExecutorConfigurationEntry> config = constructionExecutorConfiguration.getConfig();
            for (ConstructionExecutorConfigurationEntry configEntry : config) {
                if (configEntry.getName().equals(ALL_RESOURCE)) {
                    ResourceField minimumResourceField = travianModel.getResourceFields().getMinimumResourceField(ResourceFieldType.randomResourceType());
                    if (minimumResourceField.getLevel() < configEntry.getLevel()) {
                        travianBrowser.getDorf1Browser().upgradeField(minimumResourceField);
                        logBuild(minimumResourceField.getType().name(), minimumResourceField.getLevel() + 1, minimumResourceField.getId());
                    }

                } else {
                    if (travianModel.getBuildings().findByName(configEntry.getName()).isEmpty()) {
                        travianBrowser.getDorf2Browser().buildNew(configEntry.getName());
                        logBuild(configEntry.getName(), 1);

                    } else if (travianModel.getBuildings().findByName(configEntry.getName()).get(0).getLevel() < configEntry.getLevel()) {

                    }
                }
            }
        }
    }

    private void logBuild(String name, int level, int id) {
        String idString = id > 0 ? " [id=" + id + "]" : "";
        travianBotSchedulerDao.getActions().add(ExecutedAction.builder().action(
                "Building " + name + " to " + level + idString).build()
        );
    }

    private void logBuild(String name, int level) {
        logBuild(name, level, -1);
    }

}
