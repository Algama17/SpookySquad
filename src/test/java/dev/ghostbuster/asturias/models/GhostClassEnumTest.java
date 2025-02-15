package dev.ghostbuster.asturias.models;

import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GhostClassEnumTest {
    @Test
    @DisplayName ("se testa todos los valores que tienen las clases y sus propiedades")
    public void testForValiumsPropertiesVerificated() {
        assertAll(
            () -> assertThat(CLASE_I.getDescriptionClass(), is("Manifestación menor")),
            () -> assertThat(CLASE_I.getLevelClass(), is(1)),
        );

    }
}
