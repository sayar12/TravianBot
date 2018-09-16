package com.aa.travianbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TravianBotApplication {
    public static void main(String[] args) {
        SpringApplication.run(TravianBotApplication.class, args);
    }
}
