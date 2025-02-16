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
    void testGetLevelName() {

        GhostDangerLevelEnum[] values = GhostDangerLevelEnum.values();
        Set <String> levelNames = new HashSet <>();
        
        for (GhostDangerLevelEnum level : values) {
            assertThat (levelNames.add (level.getLevelName()), equalTo(true));
        }
        assertThat (levelNames.size(, equalTo(values.length));
    }

  
}
