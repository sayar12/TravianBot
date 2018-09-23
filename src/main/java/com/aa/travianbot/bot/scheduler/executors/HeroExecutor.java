package com.aa.travianbot.bot.scheduler.executors;

import com.aa.travianbot.bot.browser.TravianBrowser;
import com.aa.travianbot.model.TravianModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HeroExecutor {

    private final TravianBrowser travianBrowser;
    private final TravianModel travianModel;

    @Autowired
    public HeroExecutor(TravianBrowser travianBrowser, TravianModel travianModel) {
        this.travianBrowser = travianBrowser;
        this.travianModel = travianModel;
    }

    public void execute() {
        log.info("HeroExecutor - execute()");
        if (travianModel.getHero().getHeroAvailableAdventures() > 0 && travianModel.getHero().getHeroStatusMessage().equalsIgnoreCase("in home village")) {
            travianBrowser.getHeroBrowser().startAdventure();
        }
    }

}
