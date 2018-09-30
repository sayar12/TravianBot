package com.aa.travianbot.bot.browser;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AdvisorBrowser {

    private final WebDriver driver;

    @Autowired
    public AdvisorBrowser(WebDriver driver) {
        this.driver = driver;
    }

    public Optional<String> getReward() {
        WebElement sidebarBoxQuestmaster = driver.findElement(By.id("sidebarBoxQuestmaster"));
        List<WebElement> quests = sidebarBoxQuestmaster.findElements(By.tagName("li"));
        for (WebElement quest : quests) {
            if (isCompleted(quest)) {
                quest.click();
                new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.className("questButtonGainReward")));
                String questText = quest.getText() + " - " + driver.findElement(By.className("questRewards")).getText();
                WebElement questButtonGainReward = driver.findElement(By.className("questButtonGainReward"));
                new Actions(driver).moveToElement(questButtonGainReward);
                sleep(500);
                new Actions(driver).click();
                sleep(500);
                log.info("Reward: '" + questText + "' - Collected");
                return Optional.of(questText);
            }
        }
        return Optional.empty();
    }

    private boolean isCompleted(WebElement quest) {
        try {
            quest.findElement(By.tagName("img"));
            return true;
        } catch (NotFoundException e) {
            return false;
        }
    }

    @SneakyThrows
    private void sleep(int millis) {
        Thread.sleep(millis);
    }

}
