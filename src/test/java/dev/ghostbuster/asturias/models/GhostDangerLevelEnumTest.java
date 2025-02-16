package dev.ghostbuster.asturias.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;




public class GhostDangerLevelEnumTest {
   
    @Test
    @DisplayName ("test a display names of danger levels")
    void testDisplayDangerLevel() {

        String[] displayNames = GhostDangerLevelEnum.getDisplayNames();

        assertThat(displayNames, hasItem ("Bajo"));
        assertThat(displayNames, hasItem ("Medio"));
        assertThat(displayNames, hasItem ("Alto"));
        assertThat(displayNames, hasItem ("Crítico"));

        assertThat(displayNames.length, equalTo(4));

    }


}   
