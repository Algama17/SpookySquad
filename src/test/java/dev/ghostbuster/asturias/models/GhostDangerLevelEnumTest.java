package dev.ghostbuster.asturias.models;

import org.junit.jupiter.api.Test;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;




public class GhostDangerLevelEnumTest {
   
    @Test
    void testValues() {

        GhostDangerLevelEnum[] expectedValues = {

            GhostDangerLevelEnum.BAJO,
            GhostDangerLevelEnum.MEDIO,
            GhostDangerLevelEnum.ALTO,
            GhostDangerLevelEnum.CRITICO

        };

        GhostDangerLevelEnum[] actualValues = GhostDangerLevelEnum.values();
        assertThat(actualValues, equalTo(expectedValues));

    }
}   
