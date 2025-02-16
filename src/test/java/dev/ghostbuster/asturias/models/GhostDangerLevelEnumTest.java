package dev.ghostbuster.asturias.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GhostDangerLevelEnumTest {

    

    @Test
    @DisplayName ("test a display names of danger levels")
    void testDisplayDangerLevel() {

        String[] displayNames = GhostDangerLevelEnum.getDisplayNames();

        MatcherAssert.assertThat(displayNames.length, Matchers.is(4));

        MatcherAssert.assertThat(displayNames[0], Matchers.is("Bajo"));
        MatcherAssert.assertThat(displayNames[1], Matchers.is("Medio"));
        MatcherAssert.assertThat(displayNames[2], Matchers.is("Alto"));
        MatcherAssert.assertThat(displayNames[3], Matchers.is("Crítico"));
    }

}
