package com.aa.travianbot.bot.scheduler;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TravianBotSchedulerDao {

    private LocalDateTime schedulerCreatedDateTime = LocalDateTime.now();
    private int count;

    public LocalDateTime getSchedulerCreatedDateTime() {
        return schedulerCreatedDateTime;
    }

    public int getCount() {
        return count;
    }

    public void increaseCount() {
        count++;
    }

}
