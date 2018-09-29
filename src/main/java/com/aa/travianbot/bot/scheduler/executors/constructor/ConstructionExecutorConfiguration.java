package com.aa.travianbot.bot.scheduler.executors.constructor;

import com.aa.travianbot.model.buildings.BuildingsUtils;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class ConstructionExecutorConfiguration {

    public List<ConstructionExecutorConfigurationEntry> config = new ArrayList<>();

    public ConstructionExecutorConfiguration() {
        config.add(ConstructionExecutorConfigurationEntry.builder().name(BuildingsUtils.ALL_RESOURCE).level(1).build());
        config.add(ConstructionExecutorConfigurationEntry.builder().name(BuildingsUtils.WAREHOUSE).level(1).build());
        config.add(ConstructionExecutorConfigurationEntry.builder().name(BuildingsUtils.GRANARY).level(1).build());
        config.add(ConstructionExecutorConfigurationEntry.builder().name(BuildingsUtils.CRANNY).level(1).build());
        config.add(ConstructionExecutorConfigurationEntry.builder().name(BuildingsUtils.ALL_RESOURCE).level(2).build());
        config.add(ConstructionExecutorConfigurationEntry.builder().name(BuildingsUtils.CRANNY).level(3).build());
        config.add(ConstructionExecutorConfigurationEntry.builder().name(BuildingsUtils.WAREHOUSE).level(2).build());
        config.add(ConstructionExecutorConfigurationEntry.builder().name(BuildingsUtils.GRANARY).level(1).build());
        config.add(ConstructionExecutorConfigurationEntry.builder().name(BuildingsUtils.ALL_RESOURCE).level(3).build());
        config.add(ConstructionExecutorConfigurationEntry.builder().name(BuildingsUtils.CRANNY).level(5).build());
        config.add(ConstructionExecutorConfigurationEntry.builder().name(BuildingsUtils.WAREHOUSE).level(4).build());
        config.add(ConstructionExecutorConfigurationEntry.builder().name(BuildingsUtils.GRANARY).level(1).build());
    }
}
