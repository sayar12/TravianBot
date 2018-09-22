package com.aa.travianbot.browser;

import com.aa.travianbot.config.TravianBotConfig;
import com.aa.travianbot.model.TravianModel;
import com.aa.travianbot.model.fields.ResourceField;
import com.aa.travianbot.model.fields.ResourceFieldType;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.aa.travianbot.util.Utils.parseInt;

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

        travianModel.getResources().setLumber(parseInt(driver.findElement(By.id("l1")).getText()));
        travianModel.getResources().setClay(parseInt(driver.findElement(By.id("l2")).getText()));
        travianModel.getResources().setIron(parseInt(driver.findElement(By.id("l3")).getText()));
        travianModel.getResources().setCrop(parseInt(driver.findElement(By.id("l4")).getText()));
        log.info(travianModel.getResources().toString());

        List<WebElement> areas = driver.findElements(By.tagName("area"));
        for (WebElement area : areas) {
            if (area.getAttribute("href").contains("id=")) {
                ResourceField resourceField = new ResourceField();
                resourceField.setId(parseInt(area.getAttribute("href").substring(area.getAttribute("href").indexOf("id=") + 3)));
                resourceField.setLevel(parseInt(area.getAttribute("alt").split(" Level ")[1]));
                resourceField.setType(ResourceFieldType.getFieldTypeByFielName(area.getAttribute("alt")));
                travianModel.getResourceFields().update(resourceField);
            }
        }
        log.info(travianModel.getResourceFields().toString());
    }

    public ResourceField getMinimumResourceField(ResourceFieldType type) {
        ResourceField minimumResourceField = null;

        for (int resourceFieldId : travianModel.getResourceFields().getResourceFields().keySet()) {
            ResourceField currentResourceField = travianModel.getResourceFields().getResourceFields().get(resourceFieldId);
            if (currentResourceField.getType().equals(type)) {
                if (minimumResourceField == null) {
                    minimumResourceField = currentResourceField;
                    continue;
                }

                if (minimumResourceField.getLevel() > currentResourceField.getLevel()) {
                    minimumResourceField = currentResourceField;
                }
            }
        }

        return minimumResourceField;
    }

    public void upgradeField(ResourceField field) {
        driver.get(travianBotConfig.getTravianServerUrl() + "build.php?id=" + field.getId());
        WebElement upgradeButtonsContainer = driver.findElement(By.className("upgradeButtonsContainer"));
        upgradeButtonsContainer.findElement(By.tagName("button")).click();
        log.info("Field Upgraded: " + field.toString());
    }
}
