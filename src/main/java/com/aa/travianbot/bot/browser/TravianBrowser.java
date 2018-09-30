package com.aa.travianbot.bot.browser;

import com.aa.travianbot.config.TravianBotConfig;
import com.aa.travianbot.model.TravianModel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
@Getter
public class TravianBrowser {

    private final WebDriver driver;
    private final TravianBotConfig travianBotConfig;
    private final TravianModel travianModel;
    private final Dorf1Browser dorf1Browser;
    private final Dorf2Browser dorf2Browser;
    private final HeroBrowser heroBrowser;
    private final AdvisorBrowser advisorBrowser;

    @Autowired
    public TravianBrowser(WebDriver driver, TravianBotConfig travianBotConfig, TravianModel travianModel, Dorf1Browser dorf1Browser, Dorf2Browser dorf2Browser, HeroBrowser heroBrowser, AdvisorBrowser advisorBrowser) {
        this.driver = driver;
        this.travianBotConfig = travianBotConfig;
        this.travianModel = travianModel;
        this.dorf1Browser = dorf1Browser;
        this.dorf2Browser = dorf2Browser;
        this.heroBrowser = heroBrowser;
        this.advisorBrowser = advisorBrowser;
    }

    @PostConstruct
    public void init() {
        login();
    }

    private void login() {
        driver.get(travianBotConfig.getTravianServerUrl() + "login.php");
        driver.findElement(By.name("name")).sendKeys(travianBotConfig.getTravianUsername());
        driver.findElement(By.name("password")).sendKeys(travianBotConfig.getTravianPassword());
        driver.findElement(By.className("button-content")).click();
        closeDialogIfOpen();
    }

    public void closeDialogIfOpen() {
        try {
            driver.findElement(By.className("dialogCancelButton")).click();
        } catch (Exception e) {
            // don't care if not found
        }
    }
}
