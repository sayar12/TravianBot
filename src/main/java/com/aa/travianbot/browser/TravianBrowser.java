package com.aa.travianbot.browser;

import com.aa.travianbot.config.TravianBotConfig;
import com.aa.travianbot.model.TravianModel;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TravianBrowser {

    private final TravianBotConfig travianBotConfig;
    private final TravianModel travianModel;
    private final WebDriver driver;

    @Autowired
    public TravianBrowser(TravianBotConfig travianBotConfig, TravianModel travianModel) {
        this.travianBotConfig = travianBotConfig;
        this.travianModel = travianModel;
        this.driver = new HtmlUnitDriver();
        login();
    }

    public void dorf1() {
        driver.findElement(By.id("n1")).click();

        travianModel.getResources().setLumber(parseInt(driver.findElement(By.id("l1")).getText()));
        travianModel.getResources().setClay(parseInt(driver.findElement(By.id("l2")).getText()));
        travianModel.getResources().setIron(parseInt(driver.findElement(By.id("l3")).getText()));
        travianModel.getResources().setCrop(parseInt(driver.findElement(By.id("l4")).getText()));
        log.info(travianModel.getResources().toString());

        List<WebElement> areas = driver.findElements(By.tagName("area"));
        for (WebElement area : areas) {
            log.info(area.getAttribute("alt"));
        }
    }

    private void login() {
        driver.get(travianBotConfig.getTravianServerUrl());
        driver.findElement(By.name("name")).sendKeys(travianBotConfig.getTravianUsername());
        driver.findElement(By.name("password")).sendKeys(travianBotConfig.getTravianPassword());
        driver.findElement(By.className("button-content")).click();
    }

    private int parseInt(String string) {
        return Integer.parseInt(string.replaceAll("[^0-9]+", ""));
    }
}
