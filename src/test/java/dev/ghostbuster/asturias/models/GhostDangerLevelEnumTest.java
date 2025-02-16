package dev.ghostbuster.asturias.models;

import org.junit.jupiter.api.Test;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.HashSet;
import java.util.Set; 



public class GhostDangerLevelEnumTest {
   
    @Test
    void testValues() {

        GhostDangerLevelEnum[] values = GhostDangerLevelEnum.values();
        assertThat (values.length, equalTo (4));

        assertThat (values[0], hasProperty("levelName", equalTo("Bajo")));
        assertThat (values[0], hasProperty("levelDanger", equalTo(1)));

        assertThat (values[1], hasProperty("levelName", equalTo("Medio")));
        assertThat (values[1], hasProperty("levelDanger", equalTo(2)));

        assertThat (values[2], hasProperty("levelName", equalTo("Alto")));
        assertThat (values[2], hasProperty("levelDanger", equalTo(3)));

        assertThat (values[3], hasProperty("levelName", equalTo("Crítico")));
        assertThat (values[3], hasProperty("levelDanger", equalTo(4)));

    }



   


}
