package dev.ghostbuster.asturias.models;
<<<<<<< HEAD
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
=======
import dev.ghostbuster.asturias.models.GhostClassEnum;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

>>>>>>> dev
public class GhostClassEnumTest {
    @Test
    @DisplayName ("se testa todos los valores que tienen las clases y sus propiedades")
    public void testForValiumsPropertiesVerificated() {
        assertAll(
            () -> assertThat(GhostClassEnum.CLASE_I.getDescriptionClass(), is("Manifestación menor")),
            () -> assertThat(GhostClassEnum.CLASE_I.getLevelClass(), is(1)),
<<<<<<< HEAD
            () -> assertThat(GhostClassEnum.CLASE_II.getDescriptionClass(), is("Aparición móvil")),
            () -> assertThat(GhostClassEnum.CLASE_II.getLevelClass(), is(2)),
            () -> assertThat(GhostClassEnum.CLASE_III.getDescriptionClass(), is("Entidad inteligente")),
            () -> assertThat(GhostClassEnum.CLASE_III.getLevelClass(), is(3)),
            () -> assertThat(GhostClassEnum.CLASE_IV.getDescriptionClass(), is("Fantasma histórico")),
            () -> assertThat(GhostClassEnum.CLASE_IV.getLevelClass(), is(4)),
=======

            () -> assertThat(GhostClassEnum.CLASE_II.getDescriptionClass(), is("Aparición móvil")),
            () -> assertThat(GhostClassEnum.CLASE_II.getLevelClass(), is(2)),

            () -> assertThat(GhostClassEnum.CLASE_III.getDescriptionClass(), is("Entidad inteligente")),
            () -> assertThat(GhostClassEnum.CLASE_III.getLevelClass(), is(3)),

            () -> assertThat(GhostClassEnum.CLASE_IV.getDescriptionClass(), is("Fantasma histórico")),
            () -> assertThat(GhostClassEnum.CLASE_IV.getLevelClass(), is(4)),

>>>>>>> dev
            () -> assertThat(GhostClassEnum.CLASE_V.getDescriptionClass(), is("Espíritu antropomorfo")),
            () -> assertThat(GhostClassEnum.CLASE_V.getLevelClass(), is(5)),
            
            () -> assertThat(GhostClassEnum.CLASE_VI.getDescriptionClass(), is("Espíritu demoníaco")),
            () -> assertThat(GhostClassEnum.CLASE_VI.getLevelClass(), is(6)),
<<<<<<< HEAD
            () -> assertThat(GhostClassEnum.CLASE_VII.getDescriptionClass(), is("Entidad ultraterrena")),
            () -> assertThat(GhostClassEnum.CLASE_VII.getLevelClass(), is(7))
        );
    }
    @Test
    @DisplayName ("testing the correctly message for every ClassEnum")
    public void testgetInfoClass() {
=======

            () -> assertThat(GhostClassEnum.CLASE_VII.getDescriptionClass(), is("Entidad ultraterrena")),
            () -> assertThat(GhostClassEnum.CLASE_VII.getLevelClass(), is(7))
        );

    }

    @Test
    @DisplayName ("testing the correctly message for every ClassEnum")
    public void testgetInfoClass() {

>>>>>>> dev
        assertAll(
            () -> assertThat(GhostClassEnum.CLASE_I.getInfoClass(), is("Clase 1: Manifestación menor")),
            () -> assertThat(GhostClassEnum.CLASE_II.getInfoClass(), is("Clase 2: Aparición móvil")),
            () -> assertThat(GhostClassEnum.CLASE_III.getInfoClass(), is("Clase 3: Entidad inteligente")),
            () -> assertThat(GhostClassEnum.CLASE_IV.getInfoClass(), is("Clase 4: Fantasma histórico")),
            () -> assertThat(GhostClassEnum.CLASE_V.getInfoClass(), is("Clase 5: Espíritu antropomorfo")),
            () -> assertThat(GhostClassEnum.CLASE_VI.getInfoClass(), is("Clase 6: Espíritu demoníaco")),
            () -> assertThat(GhostClassEnum.CLASE_VII.getInfoClass(), is("Clase 7: Entidad ultraterrena"))
        );
<<<<<<< HEAD
    }
=======

    }

>>>>>>> dev
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
<<<<<<< HEAD
}
=======
}
>>>>>>> dev
