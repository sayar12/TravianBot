package com.aa.travianbot.scheduler;

import org.springframework.stereotype.Service;

@Service
public class TravianBotSchedulerDao {

    private int count;

    public int getCount() {
        return count;
    }

    public void increaseCount() {
        count++;
    }

}
