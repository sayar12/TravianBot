package com.aa.travianbot.bot.browser;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TravianBrowserConfig {

    @Bean
    public HtmlUnitDriver htmlUnitDriver() {
        HtmlUnitDriver driver = new HtmlUnitDriver(BrowserVersion.CHROME);
        driver.setJavascriptEnabled(true);
        return driver;
    }

}
