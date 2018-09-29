package com.aa.travianbot.bot.scheduler;

import com.aa.travianbot.bot.browser.TravianBrowser;
import com.aa.travianbot.bot.scheduler.executors.constructor.ConstructionExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TravianBotScheduler {

    private final TravianBotSchedulerDao travianBotSchedulerDao;
    private final TravianBrowser travianBrowser;
    private final ConstructionExecutor constructionExecutor;

    @Autowired
    public TravianBotScheduler(TravianBotSchedulerDao travianBotSchedulerDao, TravianBrowser travianBrowser, ConstructionExecutor constructionExecutor) {
        this.travianBotSchedulerDao = travianBotSchedulerDao;
        this.travianBrowser = travianBrowser;
        this.constructionExecutor = constructionExecutor;
    }

    @Scheduled(fixedRate = 60000)
    public void run() {
        log.info("TravianBotScheduler - run()");
        travianBotSchedulerDao.increaseCount();
        travianBrowser.getDorf1Browser().load();
        travianBrowser.getDorf2Browser().load();

        constructionExecutor.execute();
    }

}
