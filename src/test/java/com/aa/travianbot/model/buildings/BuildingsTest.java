package com.aa.travianbot.model.buildings;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class BuildingsTest {

    @Test
    public void findByName() {
        // Given
        Buildings buildings = new Buildings();
        buildings.update(Building.builder().code(BuildingsUtils.G0).id(1).level(0).build());
        buildings.update(Building.builder().code(BuildingsUtils.G0).id(2).level(0).build());
        buildings.update(Building.builder().code(BuildingsUtils.G10).id(5).level(20).build());
        buildings.update(Building.builder().code(BuildingsUtils.G11).id(6).level(20).build());
        buildings.update(Building.builder().code(BuildingsUtils.G10).id(7).level(4).build());

        // When
        List<Building> foundBuildings = buildings.findByName(BuildingsUtils.WAREHOUSE);

        // Then
        Assertions.assertThat(foundBuildings).isEqualTo(newArrayList(
                Building.builder().code(BuildingsUtils.G10).id(5).level(20).build(),
                Building.builder().code(BuildingsUtils.G10).id(7).level(4).build()
        ));
    }

    @Test
    public void findByNameNotFound() {
        // Given
        Buildings buildings = new Buildings();

        // When
        List<Building> foundBuildings = buildings.findByName(BuildingsUtils.WAREHOUSE);

        // Then
        Assertions.assertThat(foundBuildings).isEqualTo(newArrayList());
    }
}