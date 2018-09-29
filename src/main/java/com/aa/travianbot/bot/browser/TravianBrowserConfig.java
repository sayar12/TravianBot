package com.aa.travianbot.bot.browser;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TravianBrowserConfig {

    @Bean
    public HtmlUnitDriver htmlUnitDriver() {
        HtmlUnitDriver driver = new HtmlUnitDriver(BrowserVersion.CHROME) {
            @Override
            protected WebClient newWebClient(BrowserVersion version) {
                WebClient webClient = super.newWebClient(version);
                webClient.getOptions().setThrowExceptionOnScriptError(false);
                return webClient;
            }
        };
        driver.setJavascriptEnabled(true);
        return driver;
    }

}
