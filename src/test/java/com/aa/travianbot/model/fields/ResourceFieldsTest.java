package com.aa.travianbot.model.fields;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static com.aa.travianbot.model.fields.ResourceFieldType.CROP;
import static com.aa.travianbot.model.fields.ResourceFieldType.LUMBER;

public class ResourceFieldsTest {

    @Test
    public void getMinimumResourceField() {
        // Given
        ResourceFields resourceFields = new ResourceFields();
        ResourceField resourceField1 = ResourceField.builder()
                .id(1)
                .level(3)
                .type(LUMBER)
                .build();

        ResourceField resourceField2 = ResourceField.builder()
                .id(2)
                .level(1)
                .type(LUMBER)
                .build();

        ResourceField resourceField3 = ResourceField.builder()
                .id(3)
                .level(7)
                .type(LUMBER)
                .build();

        ResourceField resourceField4 = ResourceField.builder()
                .id(4)
                .level(0)
                .type(CROP)
                .build();

        resourceFields.update(resourceField1);
        resourceFields.update(resourceField2);
        resourceFields.update(resourceField3);
        resourceFields.update(resourceField4);

        // When
        ResourceField minimumResourceField = resourceFields.getMinimumResourceField(LUMBER);

        // Then
        Assertions.assertThat(minimumResourceField).isEqualTo(resourceField2);
    }
}