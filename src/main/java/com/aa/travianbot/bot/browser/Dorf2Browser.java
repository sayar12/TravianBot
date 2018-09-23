package com.aa.travianbot.bot.browser;

import com.aa.travianbot.config.TravianBotConfig;
import com.aa.travianbot.model.BuildingsUtils;
import com.aa.travianbot.model.TravianModel;
import com.aa.travianbot.model.buildings.Building;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.aa.travianbot.bot.utils.Utils.parseInt;

@Service
@Slf4j
public class Dorf2Browser {

    private final WebDriver driver;
    private final TravianBotConfig travianBotConfig;
    private final TravianModel travianModel;

    @Autowired
    public Dorf2Browser(WebDriver driver, TravianBotConfig travianBotConfig, TravianModel travianModel) {
        this.driver = driver;
        this.travianBotConfig = travianBotConfig;
        this.travianModel = travianModel;
    }

    public void load() {
        driver.get(travianBotConfig.getTravianServerUrl() + "dorf2.php");

        for (int i = 19; i <= 39; i++) {
            WebElement element = driver.findElement(By.className("a" + i));
            String buildingCode = element.getAttribute("class").split(" ")[2];
            int buildingLevel = 0;
            if (!buildingCode.equals("g0")) {
                buildingLevel = parseInt(element.findElement(By.className("labelLayer")).getText());
            }
            Building building = Building.builder()
                    .code(buildingCode)
                    .level(buildingLevel)
                    .id(i)
                    .build();
            travianModel.getBuildings().update(building);
        }
        log.info(travianModel.getBuildings().toString());
    }

    public void buildNew(String buildingName) {
        List<Building> emptySlot = travianModel.getBuildings().findByName(BuildingsUtils.EMPTY);

        if (emptySlot.isEmpty()) {
            throw new RuntimeException("Cannot build building because there are not empty slots: " + buildingName);
        }

        driver.get(travianBotConfig.getTravianServerUrl() + "build.php?id=" + emptySlot.get(0).getId());
        log.info("<h1> " + driver.findElement(By.tagName("h1")).getText());

        List<WebElement> buildingWrappers = driver.findElements(By.className("buildingWrapper"));
        for (WebElement buildingWrapper : buildingWrappers) {
            log.info("<h2> " + buildingWrapper.findElement(By.tagName("h2")).getText());
            if (buildingWrapper.findElement(By.tagName("h2")).getText().equals(buildingName)) {
                buildingWrapper.findElement(By.tagName("button")).click();
            }
        }
        log.info("Building created: " + buildingName);
    }
}
