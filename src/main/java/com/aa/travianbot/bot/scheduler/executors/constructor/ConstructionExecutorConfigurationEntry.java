package com.aa.travianbot.bot.scheduler.executors.constructor;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ConstructionExecutorConfigurationEntry {
    private String name;
    private int level;
}
