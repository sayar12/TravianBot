package com.aa.travianbot.util;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class UtilsTest {

    @Test
    public void parseIntShouldParseANormalInt() {
        Assertions.assertThat(Utils.parseInt("800")).isEqualTo(800);
    }

    @Test
    public void parseIntShouldParseAnIntWithSeparators() {
        Assertions.assertThat(Utils.parseInt("8,000")).isEqualTo(8000);
    }

    @Test
    public void parseIntShouldParseAnIntWithWeirdCharacters() {
        Assertions.assertThat(Utils.parseInt("\\800")).isEqualTo(800);
    }

}