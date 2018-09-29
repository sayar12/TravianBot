package com.aa.travianbot.bot.browser;

import com.aa.travianbot.bot.scheduler.executors.ExecutedAction;
import com.aa.travianbot.config.TravianBotConfig;
import com.aa.travianbot.model.TravianModel;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HeroBrowser {

    private final WebDriver driver;
    private final TravianBotConfig travianBotConfig;

    @Autowired
    public HeroBrowser(WebDriver driver, TravianBotConfig travianBotConfig) {
        this.driver = driver;
        this.travianBotConfig = travianBotConfig;
    }

    public boolean startAdventure() {
        driver.get(travianBotConfig.getTravianServerUrl() + "hero.php?t=3");
        driver.findElements(By.linkText("To the adventure")).get(0).click();
        driver.findElement(By.className("button-content")).click();
        driver.findElement(By.className("button-content")).click();
        return true;
    }

}
