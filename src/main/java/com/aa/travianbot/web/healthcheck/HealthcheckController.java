package com.aa.travianbot.web.healthcheck;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthcheckController {

    @RequestMapping(method = RequestMethod.GET, path = "healthcheck")
    public String getSchedulerCount() {
        return "OK";
    }

}
