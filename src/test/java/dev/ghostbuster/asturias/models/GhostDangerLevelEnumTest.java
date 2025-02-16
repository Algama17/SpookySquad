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
    @DisplayName ("Test that the name is the predefined one")
    void testLevelIsSameName() {

        assertThat(GhostDangerLevelEnum.BAJO.getLevelName(), equalTo ("Bajo"));
        assertThat(GhostDangerLevelEnum.MEDIO.getLevelName(), equalTo ("Medio"));
        assertThat(GhostDangerLevelEnum.ALTO.getLevelName(), equalTo ("Alto"));
        assertThat(GhostDangerLevelEnum.CRITICO.getLevelName(), equalTo ("Crítico"));

        

}   
