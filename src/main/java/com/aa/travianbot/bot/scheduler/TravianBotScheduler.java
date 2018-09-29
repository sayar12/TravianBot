package com.aa.travianbot.bot.scheduler;

import com.aa.travianbot.bot.browser.TravianBrowser;
import com.aa.travianbot.bot.scheduler.executors.TravianExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TravianBotScheduler {

    private final TravianBotSchedulerDao travianBotSchedulerDao;
    private final TravianBrowser travianBrowser;
    private final List<TravianExecutor> travianExecutors;

    @Autowired
    public TravianBotScheduler(TravianBotSchedulerDao travianBotSchedulerDao, TravianBrowser travianBrowser, List<TravianExecutor> travianExecutors) {
        this.travianBotSchedulerDao = travianBotSchedulerDao;
        this.travianBrowser = travianBrowser;
        this.travianExecutors = travianExecutors;
    }

    @Scheduled(fixedRate = 60000)
    public void run() {
        log.info("TravianBotScheduler - run()");
        travianBotSchedulerDao.increaseCount();
        travianBrowser.getDorf1Browser().load();
        travianBrowser.getDorf2Browser().load();

        for (TravianExecutor travianExecutor : travianExecutors) {
            travianExecutor.execute();
        }
    }

}
