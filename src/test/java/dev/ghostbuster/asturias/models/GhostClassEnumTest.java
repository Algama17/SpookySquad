package dev.ghostbuster.asturias.models;
import dev.ghostbuster.asturias.models.GhostClassEnum;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GhostClassEnumTest {

    @Test
    @DisplayName("testing getDisplayNames")
    public void testGetDisplayNames() {
        String[] displayNames = GhostClassEnum.getDisplayNames();
        assertAll(
            () -> assertThat(displayNames.length, is(7)),
            () -> assertThat(displayNames[0], is("Clase 1: Manifestación menor")),
            () -> assertThat(displayNames[1], is("Clase 2: Aparición móvil")),
            () -> assertThat(displayNames[2], is("Clase 3: Entidad inteligente")),
            () -> assertThat(displayNames[3], is("Clase 4: Fantasma histórico")),
            () -> assertThat(displayNames[4], is("Clase 5: Espíritu antropomorfo")),
            () -> assertThat(displayNames[5], is("Clase 6: Espíritu demoníaco")),
            () -> assertThat(displayNames[6], is("Clase 7: Entidad ultraterrena"))
        );
    }

}
