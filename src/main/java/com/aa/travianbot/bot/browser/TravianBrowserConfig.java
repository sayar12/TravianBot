package com.aa.travianbot.bot.browser;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TravianBrowserConfig {

    @Bean
    public HtmlUnitDriver htmlUnitDriver() {
        return new HtmlUnitDriver(true);
    }

}
