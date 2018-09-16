package com.aa.travianbot.scheduler;

import com.aa.travianbot.config.TravianBotConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TravianBotSchedulerController {

    private final TravianBotSchedulerDao travianBotSchedulerDao;
    private final TravianBotConfig travianBotConfig;

    @Autowired
    public TravianBotSchedulerController(TravianBotSchedulerDao travianBotSchedulerDao, TravianBotConfig travianBotConfig) {
        this.travianBotSchedulerDao = travianBotSchedulerDao;
        this.travianBotConfig = travianBotConfig;
    }

    @RequestMapping(method = RequestMethod.GET, path = "scheduler/count")
    public Map<String, Object> getSchedulerCount() {
        Map<String, Object> map = new HashMap<>();
        map.put("COUNT", travianBotSchedulerDao.getCount());
        map.put("URL", travianBotConfig.getTravianServerUrl());
        return map;
    }

}
