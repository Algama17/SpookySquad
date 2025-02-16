package dev.ghostbuster.asturias.models;
import dev.ghostbuster.asturias.models.GhostClassEnum;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GhostClassEnumTest {
  


    @Test
    @DisplayName ("testing the correctly message for every ClassEnum")
    public void testGetInfoClass() {

        assertAll(
            () -> assertThat(GhostClassEnum.CLASE_I.getInfoClass(), is("Clase 1: Manifestación menor")),
            () -> assertThat(GhostClassEnum.CLASE_II.getInfoClass(), is("Clase 2: Aparición móvil")),
            () -> assertThat(GhostClassEnum.CLASE_III.getInfoClass(), is("Clase 3: Entidad inteligente")),
            () -> assertThat(GhostClassEnum.CLASE_IV.getInfoClass(), is("Clase 4: Fantasma histórico")),
            () -> assertThat(GhostClassEnum.CLASE_V.getInfoClass(), is("Clase 5: Espíritu antropomorfo")),
            () -> assertThat(GhostClassEnum.CLASE_VI.getInfoClass(), is("Clase 6: Espíritu demoníaco")),
            () -> assertThat(GhostClassEnum.CLASE_VII.getInfoClass(), is("Clase 7: Entidad ultraterrena"))
        );

    }
}
