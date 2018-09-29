package com.aa.travianbot.bot.browser;

import com.aa.travianbot.config.TravianBotConfig;
import com.aa.travianbot.model.TravianModel;
import com.aa.travianbot.model.fields.ResourceField;
import com.aa.travianbot.model.fields.ResourceFieldType;
import com.aa.travianbot.model.progress.BuildingInProgress;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.aa.travianbot.bot.utils.Utils.parseInt;

@Service
@Slf4j
public class Dorf1Browser {

    private final WebDriver driver;
    private final TravianBotConfig travianBotConfig;
    private final TravianModel travianModel;

    @Autowired
    public Dorf1Browser(WebDriver driver, TravianBotConfig travianBotConfig, TravianModel travianModel) {
        this.driver = driver;
        this.travianBotConfig = travianBotConfig;
        this.travianModel = travianModel;
    }

    public void load() {
        driver.get(travianBotConfig.getTravianServerUrl() + "dorf1.php");

        loadResources();
        loadFields();
        loadBuildingsInProgress();
        loadHeroInformation();
    }

    public boolean upgradeField(ResourceField field) {
        driver.get(travianBotConfig.getTravianServerUrl() + "build.php?id=" + field.getId());
        WebElement upgradeButtonsContainer = driver.findElement(By.className("upgradeButtonsContainer"));
        WebElement upgradeButton = upgradeButtonsContainer.findElement(By.tagName("button"));
        if (!upgradeButton.getText().contains("master builder")) {
            upgradeButton.click();
            log.info("Field Upgraded: " + field.toString());
            return true;
        }
        return false;
    }

    private void loadResources() {
        travianModel.getResources().setLumber(parseInt(driver.findElement(By.id("l1")).getText()));
        travianModel.getResources().setClay(parseInt(driver.findElement(By.id("l2")).getText()));
        travianModel.getResources().setIron(parseInt(driver.findElement(By.id("l3")).getText()));
        travianModel.getResources().setCrop(parseInt(driver.findElement(By.id("l4")).getText()));
        log.info(travianModel.getResources().toString());
    }

    private void loadFields() {
        List<WebElement> areas = driver.findElements(By.tagName("area"));
        for (WebElement area : areas) {
            if (area.getAttribute("href").contains("id=")) {
                ResourceField resourceField = ResourceField.builder()
                        .id(parseInt(area.getAttribute("href").substring(area.getAttribute("href").indexOf("id=") + 3)))
                        .level(parseInt(area.getAttribute("alt").split(" Level ")[1]))
                        .type(ResourceFieldType.getFieldTypeByFielName(area.getAttribute("alt")))
                        .build();
                travianModel.getResourceFields().update(resourceField);
            }
        }
        log.info(travianModel.getResourceFields().toString());
    }

    private void loadBuildingsInProgress() {
        WebElement boxesContents = driver.findElement(By.className("boxes-contents"));
        List<BuildingInProgress> buildingsInProgress = boxesContents.findElements(By.tagName("li")).stream()
                .map(inProgress -> {
                    BuildingInProgress buildingInProgress = new BuildingInProgress();
                    buildingInProgress.setText(inProgress.getText());
                    return buildingInProgress;
                })
                .collect(Collectors.toList());
        travianModel.setBuildingsInProgress(buildingsInProgress);
        log.info("BuildingsInProgress: " + travianModel.getBuildingsInProgress().toString());
    }

    private void loadHeroInformation() {
        WebElement heroStatusMessage = driver.findElement(By.className("heroStatusMessage"));
        travianModel.getHero().setHeroStatusMessage(heroStatusMessage.getText());
        WebElement sidebarBoxHero = driver.findElement(By.id("sidebarBoxHero"));
        try {
            String availableAdventures = sidebarBoxHero.findElement(By.className("speechBubbleContent")).getText();
            travianModel.getHero().setHeroAvailableAdventures(parseInt(availableAdventures));
        } catch (NotFoundException e) {
            // no adventures
        }
        log.info(travianModel.getHero().toString());
    }
}
