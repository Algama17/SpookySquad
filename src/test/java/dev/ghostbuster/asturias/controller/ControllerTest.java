package dev.ghostbuster.asturias.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.ghostbuster.asturias.models.Ghost;
import dev.ghostbuster.asturias.models.GhostClassEnum;
import dev.ghostbuster.asturias.models.GhostDangerLevelEnum;


   public class ControllerTest {
    private Controller controller;

    @BeforeEach
    void setUp() {
        controller = new Controller("GhostbusterX");
    }

    @Test
    void testCaptureGhost() {
        controller.captureGhost("Slimer", GhostClassEnum.CLASE_III, GhostDangerLevelEnum.MEDIO, "Atravesar paredes", "8/10");
        List<Ghost> ghosts = controller.getAllGhosts();

        assertEquals(1, ghosts.size());
        assertEquals("Slimer", ghosts.get(0).getGhostName());
    }

    @Test
    void testReleaseGhostById() {
        controller.captureGhost("Slimer", GhostClassEnum.CLASE_III, GhostDangerLevelEnum.MEDIO, "Atravesar paredes", "8/10");
        controller.captureGhost("Stay Puft", GhostClassEnum.CLASE_V,GhostDangerLevelEnum.ALTO, "Gigante", "Marshmallow");

        List<Ghost> ghosts = controller.getAllGhosts();
        int ghostId = ghosts.get(0).getId();

        assertTrue(controller.releaseGhostById(ghostId));
        assertEquals(1, controller.getAllGhosts().size());
    }

    @Test
    void testFilterGhostsByClass() {
        controller.captureGhost("Slimer", GhostClassEnum.CLASE_III, GhostDangerLevelEnum.MEDIO, "Atravesar paredes", "8/10");
        controller.captureGhost("Stay Puft", GhostClassEnum.CLASE_V,GhostDangerLevelEnum.ALTO, "Gigante", "Marshmallow");

        List<Ghost> filteredGhosts = controller.filterGhostsByClass(GhostClassEnum.CLASE_III);

        assertEquals(1, filteredGhosts.size());
        assertEquals("Slimer", filteredGhosts.get(0).getGhostName());
    }

    @Test
    void testFilterGhostsByDangerLevel() {
        controller.captureGhost("Slimer", GhostClassEnum.CLASE_III, GhostDangerLevelEnum.MEDIO, "Atravesar paredes", "8/10");
        controller.captureGhost("Stay Puft", GhostClassEnum.CLASE_V,GhostDangerLevelEnum.ALTO, "Gigante", "Marshmallow");

        List<Ghost> filteredGhosts = controller.filterGhostsByDangerLevel(GhostDangerLevelEnum.ALTO);

        assertEquals(1, filteredGhosts.size());
        assertEquals("Stay Puft", filteredGhosts.get(0).getGhostName());
    }

    @Test
    void testFilterGhostsByDate() {
        controller.captureGhost("Slimer", GhostClassEnum.CLASE_III, GhostDangerLevelEnum.MEDIO, "Atravesar paredes", "8/10");
        String captureDate = controller.getAllGhosts().get(0).getCaptureDate();

        List<Ghost> filteredGhosts = controller.filterGhostsByDate(captureDate);

        assertEquals(1, filteredGhosts.size());
        assertEquals("Slimer", filteredGhosts.get(0).getGhostName());
    }

    @Test
    void testGetPlayerName() {
        assertEquals("GhostbusterX", controller.getPlayerName());
    }
}

