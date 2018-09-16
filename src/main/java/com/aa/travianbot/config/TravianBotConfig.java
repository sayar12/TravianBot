package com.aa.travianbot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TravianBotConfig {

    @Value("${TRAVIAN_SERVER_URL}")
    private String travianServerUrl;

    public String getTravianServerUrl() {
        return travianServerUrl;
    }

}
