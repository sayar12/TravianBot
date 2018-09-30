package com.aa.travianbot.bot.scheduler.executors.updater;

import com.aa.travianbot.bot.browser.TravianBrowser;
import com.aa.travianbot.bot.scheduler.executors.TravianExecutor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Order(1)
@Service
@Slf4j
public class UpdaterExecutor implements TravianExecutor {

    private final TravianBrowser travianBrowser;

    @Autowired
    public UpdaterExecutor(TravianBrowser travianBrowser) {
        this.travianBrowser = travianBrowser;
    }

    @Override
    public void execute() {
        log.info("UpdaterExecutor - execute()");
        travianBrowser.closeDialogIfOpen();

        travianBrowser.getDorf1Browser().load();
        travianBrowser.getDorf2Browser().load();
    }

}
