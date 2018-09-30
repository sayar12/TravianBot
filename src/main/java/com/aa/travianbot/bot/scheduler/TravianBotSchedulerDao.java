package com.aa.travianbot.bot.scheduler;

import com.aa.travianbot.bot.scheduler.executors.ExecutedAction;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class TravianBotSchedulerDao {

    private LocalDateTime schedulerCreatedDateTime = LocalDateTime.now();
    private LocalDateTime schedulerLastUpdatedDateTime;
    private int count;
    private List<ExecutedAction> actions = new ArrayList<>();

    public int getCount() {
        this.schedulerLastUpdatedDateTime = LocalDateTime.now();
        return count;
    }

    public void increaseCount() {
        count++;
    }

    public List<ExecutedAction> getActions() {
        return actions;
    }
}
