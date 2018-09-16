package com.aa.travianbot.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TravianBotScheduler {

    private final TravianBotSchedulerDao travianBotSchedulerDao;

    @Autowired
    public TravianBotScheduler(TravianBotSchedulerDao travianBotSchedulerDao) {
        this.travianBotSchedulerDao = travianBotSchedulerDao;
    }

    @Scheduled(fixedRate = 60000)
    public void execute() {
        log.info("TravianBotScheduler - execute()");
        travianBotSchedulerDao.increaseCount();
    }

}
