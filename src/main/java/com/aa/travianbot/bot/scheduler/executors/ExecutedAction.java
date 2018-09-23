package com.aa.travianbot.bot.scheduler.executors;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ExecutedAction {
    @Builder.Default
    private LocalDateTime dateTime = LocalDateTime.now();
    private String action;
}
