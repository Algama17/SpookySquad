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
    @DisplayName ("Test that the DangerLevel is the predefined one")
    void testDangerIsSameLevel() {

        assertThat(GhostDangerLevelEnum.BAJO.getLevelDanger(), equalTo(1));
        assertThat(GhostDangerLevelEnum.MEDIO.getLevelDanger(), equalTo(2));
        assertThat(GhostDangerLevelEnum.ALTO.getLevelDanger(), equalTo(3));
        assertThat(GhostDangerLevelEnum.CRITICO.getLevelDanger(), equalTo(4));
    }

}   
