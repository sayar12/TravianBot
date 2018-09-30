package com.aa.travianbot.web.info;

import com.aa.travianbot.config.TravianBotConfig;
import com.aa.travianbot.bot.scheduler.TravianBotSchedulerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class InfoController {

    private final TravianBotSchedulerDao travianBotSchedulerDao;
    private final TravianBotConfig travianBotConfig;

    @Autowired
    public InfoController(TravianBotSchedulerDao travianBotSchedulerDao, TravianBotConfig travianBotConfig) {
        this.travianBotSchedulerDao = travianBotSchedulerDao;
        this.travianBotConfig = travianBotConfig;
    }

    @RequestMapping(method = RequestMethod.GET, path = "info")
    public Map<String, Object> getSchedulerCount() {
        Map<String, Object> map = new HashMap<>();
        map.put("TRAVIAN_SERVER_URL", travianBotConfig.getTravianServerUrl());
        map.put("TRAVIAN_USERNAME", travianBotConfig.getTravianUsername());
        map.put("SCHEDULER_COUNT", travianBotSchedulerDao.getCount());
        map.put("SCHEDULER_CREATED_DATETIME", travianBotSchedulerDao.getSchedulerCreatedDateTime());
        map.put("SCHEDULER_LAST_UPDATED_DATETIME", travianBotSchedulerDao.getSchedulerLastUpdatedDateTime());
        map.put("ACTIONS", travianBotSchedulerDao.getActions());
        return map;
    }

}
