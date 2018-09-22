package com.aa.travianbot.browser;

import com.aa.travianbot.config.TravianBotConfig;
import com.aa.travianbot.model.TravianModel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Getter
public class TravianBrowser {

    private final WebDriver driver;
    private final TravianBotConfig travianBotConfig;
    private final TravianModel travianModel;
    private final Dorf1Browser dorf1Browser;

    @Autowired
    public TravianBrowser(WebDriver driver, TravianBotConfig travianBotConfig, TravianModel travianModel, Dorf1Browser dorf1Browser) {
        this.driver = driver;
        this.travianBotConfig = travianBotConfig;
        this.travianModel = travianModel;
        this.dorf1Browser = dorf1Browser;
        login();
    }

    private void login() {
        driver.get(travianBotConfig.getTravianServerUrl() + "login.php");
        driver.findElement(By.name("name")).sendKeys(travianBotConfig.getTravianUsername());
        driver.findElement(By.name("password")).sendKeys(travianBotConfig.getTravianPassword());
        driver.findElement(By.className("button-content")).click();
    }
}
