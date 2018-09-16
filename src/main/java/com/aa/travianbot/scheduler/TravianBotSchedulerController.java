package com.aa.travianbot.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TravianBotSchedulerController {

    private final TravianBotSchedulerDao travianBotSchedulerDao;

    @Autowired
    public TravianBotSchedulerController(TravianBotSchedulerDao travianBotSchedulerDao) {
        this.travianBotSchedulerDao = travianBotSchedulerDao;
    }

    @RequestMapping(method = RequestMethod.GET, path = "scheduler/count")
    public int getSchedulerCount() {
        return travianBotSchedulerDao.getCount();
    }

}
