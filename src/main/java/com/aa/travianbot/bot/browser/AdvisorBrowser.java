package com.aa.travianbot.bot.browser;

import com.aa.travianbot.config.TravianBotConfig;
import com.aa.travianbot.model.TravianModel;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    private final TravianBotConfig travianBotConfig;
    private final TravianModel travianModel;

    @Autowired
    public AdvisorBrowser(WebDriver driver, TravianBotConfig travianBotConfig, TravianModel travianModel) {
        this.driver = driver;
        this.travianBotConfig = travianBotConfig;
        this.travianModel = travianModel;
    }


    public Optional<String> getReward() {
        WebDriverWait wait = new WebDriverWait(driver, 20);

        WebElement sidebarBoxQuestmaster = driver.findElement(By.id("sidebarBoxQuestmaster"));

        List<WebElement> quests = sidebarBoxQuestmaster.findElements(By.tagName("li"));
        for (WebElement quest : quests) {
            if (isCompleted(quest)) {
                String rewardText = quest.getText();
                log.info(rewardText + " - Rewarding");
                quest.findElement(By.tagName("a")).click();

                WebElement questButtonGainReward = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("questButtonGainReward")));

                // TODO this does not work due to javascript issues.
//                questButtonGainReward.click();
//
//                log.info(rewardText + " - Reward collected");
//                return Optional.of(rewardText);

                return Optional.empty();
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

}
