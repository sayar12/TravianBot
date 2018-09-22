package com.aa.travianbot.scheduler;

import com.aa.travianbot.browser.TravianBrowser;
import com.aa.travianbot.model.TravianModel;
import com.aa.travianbot.model.fields.ResourceField;
import com.aa.travianbot.model.fields.ResourceFieldType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TravianBotScheduler {

    private final TravianBotSchedulerDao travianBotSchedulerDao;
    private final TravianBrowser travianBrowser;
    private final TravianModel travianModel;

    @Autowired
    public TravianBotScheduler(TravianBotSchedulerDao travianBotSchedulerDao, TravianBrowser travianBrowser, TravianModel travianModel) {
        this.travianBotSchedulerDao = travianBotSchedulerDao;
        this.travianBrowser = travianBrowser;
        this.travianModel = travianModel;
    }

    @Scheduled(fixedRate = 60000)
    public void execute() {
        log.info("TravianBotScheduler - execute()");
        travianBotSchedulerDao.increaseCount();
        travianBrowser.getDorf1Browser().load();

        if (travianModel.getBuildingsInProgress().isEmpty()) {
            ResourceField minimumResourceField = travianBrowser.getDorf1Browser().getMinimumResourceField(ResourceFieldType.randomResourceType());
            travianBrowser.getDorf1Browser().upgradeField(minimumResourceField);
        }
    }

}
