package com.aa.travianbot.bot.scheduler;

import com.aa.travianbot.bot.scheduler.executors.ExecutedAction;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TravianBotSchedulerDao {

    private LocalDateTime schedulerCreatedDateTime = LocalDateTime.now();
    private int count;
    private List<ExecutedAction> actions = new ArrayList<>();

    public LocalDateTime getSchedulerCreatedDateTime() {
        return schedulerCreatedDateTime;
    }

    public int getCount() {
        return count;
    }

    public void increaseCount() {
        count++;
    }

    public List<ExecutedAction> getActions() {
        return actions;
    }
}
