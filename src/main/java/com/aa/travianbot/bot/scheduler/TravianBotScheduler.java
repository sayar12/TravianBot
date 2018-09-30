package com.aa.travianbot.bot.scheduler;

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
    private final List<TravianExecutor> travianExecutors;

    @Autowired
    public TravianBotScheduler(TravianBotSchedulerDao travianBotSchedulerDao, List<TravianExecutor> travianExecutors) {
        this.travianBotSchedulerDao = travianBotSchedulerDao;
        this.travianExecutors = travianExecutors;
    }

    @Scheduled(fixedRate = 300_000)
    public void run() {
        travianBotSchedulerDao.increaseCount();
        log.info("TravianBotScheduler - run() - " + travianBotSchedulerDao.getCount());

        for (TravianExecutor travianExecutor : travianExecutors) {
            travianExecutor.execute();
        }
    }

}
