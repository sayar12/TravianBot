package com.aa.travianbot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TravianBotConfig {

    @Value("${PASSWORD}")
    private String password;

    @Value("${TRAVIAN_SERVER_URL}")
    private String travianServerUrl;

    @Value("${TRAVIAN_USERNAME}")
    private String travianUsername;

    @Value("${TRAVIAN_PASSWORD}")
    private String travianPassword;

    public String getPassword() {
        return password;
    }

    public String getTravianServerUrl() {
        return travianServerUrl;
    }

    public String getTravianUsername() {
        return travianUsername;
    }

    public String getTravianPassword() {
        return travianPassword;
    }
}
