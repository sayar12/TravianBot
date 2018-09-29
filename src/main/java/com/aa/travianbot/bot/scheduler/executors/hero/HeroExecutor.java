package com.aa.travianbot.bot.scheduler.executors.hero;

import com.aa.travianbot.bot.browser.TravianBrowser;
import com.aa.travianbot.bot.scheduler.TravianBotSchedulerDao;
import com.aa.travianbot.bot.scheduler.executors.ExecutedAction;
import com.aa.travianbot.bot.scheduler.executors.TravianExecutor;
import com.aa.travianbot.model.TravianModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HeroExecutor implements TravianExecutor {

    private final TravianBrowser travianBrowser;
    private final TravianModel travianModel;
    private final TravianBotSchedulerDao travianBotSchedulerDao;

    @Autowired
    public HeroExecutor(TravianBrowser travianBrowser, TravianModel travianModel, TravianBotSchedulerDao travianBotSchedulerDao) {
        this.travianBrowser = travianBrowser;
        this.travianModel = travianModel;
        this.travianBotSchedulerDao = travianBotSchedulerDao;
    }

    @Override
    public void execute() {
        log.info("HeroExecutor - execute()");
        if (travianModel.getHero().getHeroAvailableAdventures() > 0 && travianModel.getHero().getHeroStatusMessage().equalsIgnoreCase("in home village")) {
            boolean adventureStarted = travianBrowser.getHeroBrowser().startAdventure();
            if (adventureStarted) {
                travianBotSchedulerDao.getActions().add(ExecutedAction.builder().action(
                        "Adventure Started").build()
                );
            }
        }
    }

}
