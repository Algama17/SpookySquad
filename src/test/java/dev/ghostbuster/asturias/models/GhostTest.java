package dev.ghostbuster.asturias.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GhostTest {
    private Ghost ghost;

    @BeforeEach
    void setUp() {
        ghost = new Ghost(
            1,
            "Spectro",
            GhostClassEnum.CLASE_I,
            GhostDangerLevelEnum.ALTO,
            "2025-02-14",
            "Telekinesis",
            "8/10"
        );
    }

    @Test
    void testGhostAttributes() {
        assertEquals(1, ghost.getId());
        assertEquals("Spectro", ghost.getGhostName());
        assertEquals(GhostClassEnum.CLASE_I, ghost.getGhostClass());
        assertEquals(GhostDangerLevelEnum.ALTO, ghost.getDangerLevel());
        assertEquals("2025-02-14", ghost.getCaptureDate());
        assertEquals("Telekinesis", ghost.getSpecialAbility());
        assertEquals("8/10", ghost.getGhostAfinity());
    }

   
} 
