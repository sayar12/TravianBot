package com.aa.travianbot.bot.scheduler.executors.tasks;

import com.aa.travianbot.bot.browser.TravianBrowser;
import com.aa.travianbot.bot.scheduler.TravianBotSchedulerDao;
import com.aa.travianbot.bot.scheduler.executors.ExecutedAction;
import com.aa.travianbot.bot.scheduler.executors.TravianExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class TaskOverviewExecutor implements TravianExecutor {

    private final TravianBrowser travianBrowser;
    private final TravianBotSchedulerDao travianBotSchedulerDao;

    @Autowired
    public TaskOverviewExecutor(TravianBrowser travianBrowser, TravianBotSchedulerDao travianBotSchedulerDao) {
        this.travianBrowser = travianBrowser;
        this.travianBotSchedulerDao = travianBotSchedulerDao;
    }

    @Override
    public void execute() {
        log.info("TaskOverviewExecutor - execute()");
        Optional reward = travianBrowser.getAdvisorBrowser().getReward();

        if (reward.isPresent()) {
            travianBotSchedulerDao.getActions().add(ExecutedAction.builder().action(
                    reward.get() + "Reward Collected").build()
            );
        }
    }

}
