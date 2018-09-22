package com.aa.travianbot.scheduler;

import com.aa.travianbot.browser.TravianBrowser;
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

    @Autowired
    public TravianBotScheduler(TravianBotSchedulerDao travianBotSchedulerDao, TravianBrowser travianBrowser) {
        this.travianBotSchedulerDao = travianBotSchedulerDao;
        this.travianBrowser = travianBrowser;
    }

    @Scheduled(fixedRate = 60000)
    public void execute() {
        log.info("TravianBotScheduler - execute()");
        travianBotSchedulerDao.increaseCount();
        travianBrowser.getDorf1Browser().load();

        travianBrowser.getDorf1Browser().upgradeField(travianBrowser.getDorf1Browser().getMinimumResourceField(ResourceFieldType.LUMBER));
    }

}
