package dev.ghostbuster.asturias.controller;

<<<<<<< HEAD
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
=======
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

>>>>>>> dev
import dev.ghostbuster.asturias.models.Ghost;
import dev.ghostbuster.asturias.models.GhostClassEnum;
import dev.ghostbuster.asturias.models.GhostDangerLevelEnum;

<<<<<<< HEAD
public class ControllerTest {

=======

   public class ControllerTest {
>>>>>>> dev
    private Controller controller;

    @BeforeEach
    void setUp() {
        controller = new Controller("GhostbusterX");
    }

    @Test
    void testCaptureGhost() {
        controller.captureGhost("Slimer", GhostClassEnum.CLASE_III, GhostDangerLevelEnum.MEDIO, "Atravesar paredes", "8/10");
        List<Ghost> ghosts = controller.getAllGhosts();
<<<<<<< HEAD
=======

>>>>>>> dev
        assertEquals(1, ghosts.size());
        assertEquals("Slimer", ghosts.get(0).getGhostName());
    }

    @Test
<<<<<<< HEAD
    void testCaptureMultipleGhosts() {
        controller.captureGhost("Slimer", GhostClassEnum.CLASE_III, GhostDangerLevelEnum.MEDIO, "Atravesar paredes", "8/10");
        controller.captureGhost("Stay Puft", GhostClassEnum.CLASE_V, GhostDangerLevelEnum.ALTO, "Gigante", "Marshmallow");
        List<Ghost> ghosts = controller.getAllGhosts();
        assertEquals(2, ghosts.size());
        assertEquals("Slimer", ghosts.get(0).getGhostName());
        assertEquals("Stay Puft", ghosts.get(1).getGhostName());
    }

    @Test
    void testCaptureGhostWithEmptyData() {
        controller.captureGhost("", GhostClassEnum.CLASE_I, GhostDangerLevelEnum.BAJO, "", "");
        List<Ghost> ghosts = controller.getAllGhosts();
        assertEquals(1, ghosts.size());
        assertEquals("", ghosts.get(0).getGhostName());
        assertEquals("", ghosts.get(0).getSpecialAbility());
    }

    @Test
    void testReleaseGhostById() {
        controller.captureGhost("Slimer", GhostClassEnum.CLASE_III, GhostDangerLevelEnum.MEDIO, "Atravesar paredes", "8/10");
        controller.captureGhost("Stay Puft", GhostClassEnum.CLASE_V, GhostDangerLevelEnum.ALTO, "Gigante", "Marshmallow");
        List<Ghost> ghosts = controller.getAllGhosts();
        int ghostId = ghosts.get(0).getId();
        assertTrue(controller.releaseGhostById(ghostId));
        assertEquals(1, controller.getAllGhosts().size());
    }
 
    @Test
    void testReleaseNonExistentGhost() {
        controller.captureGhost("Slimer", GhostClassEnum.CLASE_III, GhostDangerLevelEnum.MEDIO, "Atravesar paredes", "8/10");
        assertFalse(controller.releaseGhostById(999)); 
        assertEquals(1, controller.getAllGhosts().size());
    }


    @Test
    void testReleaseAllGhosts() {
        controller.captureGhost("Slimer", GhostClassEnum.CLASE_III, GhostDangerLevelEnum.MEDIO, "Atravesar paredes", "8/10");
        controller.captureGhost("Stay Puft", GhostClassEnum.CLASE_V, GhostDangerLevelEnum.ALTO, "Gigante", "Marshmallow");

        List<Ghost> ghosts = controller.getAllGhosts();
        for (Ghost ghost : ghosts) {
            assertTrue(controller.releaseGhostById(ghost.getId()));
        }
        assertTrue(controller.getAllGhosts().isEmpty());
    }
=======
    void testReleaseGhostById() {
        controller.captureGhost("Slimer", GhostClassEnum.CLASE_III, GhostDangerLevelEnum.MEDIO, "Atravesar paredes", "8/10");
        controller.captureGhost("Stay Puft", GhostClassEnum.CLASE_V,GhostDangerLevelEnum.ALTO, "Gigante", "Marshmallow");

        List<Ghost> ghosts = controller.getAllGhosts();
        int ghostId = ghosts.get(0).getId();

        assertTrue(controller.releaseGhostById(ghostId));
        assertEquals(1, controller.getAllGhosts().size());
    }
>>>>>>> dev

    @Test
    void testFilterGhostsByClass() {
        controller.captureGhost("Slimer", GhostClassEnum.CLASE_III, GhostDangerLevelEnum.MEDIO, "Atravesar paredes", "8/10");
<<<<<<< HEAD
        controller.captureGhost("Stay Puft", GhostClassEnum.CLASE_V, GhostDangerLevelEnum.ALTO, "Gigante", "Marshmallow");
        List<Ghost> filteredGhosts = controller.filterGhostsByClass(GhostClassEnum.CLASE_III);
=======
        controller.captureGhost("Stay Puft", GhostClassEnum.CLASE_V,GhostDangerLevelEnum.ALTO, "Gigante", "Marshmallow");

        List<Ghost> filteredGhosts = controller.filterGhostsByClass(GhostClassEnum.CLASE_III);

>>>>>>> dev
        assertEquals(1, filteredGhosts.size());
        assertEquals("Slimer", filteredGhosts.get(0).getGhostName());
    }

    @Test
<<<<<<< HEAD
    void testFilterGhostsByClass_NoMatches() {
        controller.captureGhost("Slimer", GhostClassEnum.CLASE_III, GhostDangerLevelEnum.MEDIO, "Atravesar paredes", "8/10");
        List<Ghost> filteredGhosts = controller.filterGhostsByClass(GhostClassEnum.CLASE_I);
        assertTrue(filteredGhosts.isEmpty());
    }


    @Test
    void testFilterGhostsByClass_MultipleMatches() {
        controller.captureGhost("Slimer", GhostClassEnum.CLASE_III, GhostDangerLevelEnum.MEDIO, "Atravesar paredes", "8/10");
        controller.captureGhost("Wraith", GhostClassEnum.CLASE_III, GhostDangerLevelEnum.ALTO, "Telepatía", "5/10");
        List<Ghost> filteredGhosts = controller.filterGhostsByClass(GhostClassEnum.CLASE_III);
        assertEquals(2, filteredGhosts.size());
    }

    @Test
    void testFilterGhostsByDangerLevel() {
        controller.captureGhost("Slimer", GhostClassEnum.CLASE_III, GhostDangerLevelEnum.MEDIO, "Atravesar paredes", "8/10");
        controller.captureGhost("Stay Puft", GhostClassEnum.CLASE_V, GhostDangerLevelEnum.ALTO, "Gigante", "Marshmallow");
        List<Ghost> filteredGhosts = controller.filterGhostsByDangerLevel(GhostDangerLevelEnum.ALTO);
=======
    void testFilterGhostsByDangerLevel() {
        controller.captureGhost("Slimer", GhostClassEnum.CLASE_III, GhostDangerLevelEnum.MEDIO, "Atravesar paredes", "8/10");
        controller.captureGhost("Stay Puft", GhostClassEnum.CLASE_V,GhostDangerLevelEnum.ALTO, "Gigante", "Marshmallow");

        List<Ghost> filteredGhosts = controller.filterGhostsByDangerLevel(GhostDangerLevelEnum.ALTO);

>>>>>>> dev
        assertEquals(1, filteredGhosts.size());
        assertEquals("Stay Puft", filteredGhosts.get(0).getGhostName());
    }

    @Test
<<<<<<< HEAD
    void testFilterGhostsByDangerLevel_NoMatches() {
        controller.captureGhost("Slimer", GhostClassEnum.CLASE_III, GhostDangerLevelEnum.MEDIO, "Atravesar paredes", "8/10");
        List<Ghost> filteredGhosts = controller.filterGhostsByDangerLevel(GhostDangerLevelEnum.CRITICO);
        assertTrue(filteredGhosts.isEmpty());
    }

    @Test
    void testFilterGhostsByDangerLevel_MultipleMatches() {
        controller.captureGhost("Slimer", GhostClassEnum.CLASE_III, GhostDangerLevelEnum.MEDIO, "Atravesar paredes", "8/10");
        controller.captureGhost("Wraith", GhostClassEnum.CLASE_III, GhostDangerLevelEnum.MEDIO, "Telepatía", "5/10");
        List<Ghost> filteredGhosts = controller.filterGhostsByDangerLevel(GhostDangerLevelEnum.MEDIO);
        assertEquals(2, filteredGhosts.size());
    }

    @Test
    void testFilterGhostsByDate() {
        controller.captureGhost("Slimer", GhostClassEnum.CLASE_III, GhostDangerLevelEnum.MEDIO, "Atravesar paredes", "8/10");
        String captureDate = controller.getAllGhosts().get(0).getCaptureDate();
        List<Ghost> filteredGhosts = controller.filterGhostsByDate(captureDate);
=======
    void testFilterGhostsByDate() {
        controller.captureGhost("Slimer", GhostClassEnum.CLASE_III, GhostDangerLevelEnum.MEDIO, "Atravesar paredes", "8/10");
        String captureDate = controller.getAllGhosts().get(0).getCaptureDate();

        List<Ghost> filteredGhosts = controller.filterGhostsByDate(captureDate);

>>>>>>> dev
        assertEquals(1, filteredGhosts.size());
        assertEquals("Slimer", filteredGhosts.get(0).getGhostName());
    }

<<<<<<< HEAD

    @Test
    void testFilterGhostsByDate_NoMatches() {
        controller.captureGhost("Slimer", GhostClassEnum.CLASE_III, GhostDangerLevelEnum.MEDIO, "Atravesar paredes", "8/10");
        List<Ghost> filteredGhosts = controller.filterGhostsByDate("2023-01-01");
        assertTrue(filteredGhosts.isEmpty());
    }

=======
>>>>>>> dev
    @Test
    void testGetPlayerName() {
        assertEquals("GhostbusterX", controller.getPlayerName());
    }
<<<<<<< HEAD

    @Test
    void testGetAllGhosts_EmptyList() {
        List<Ghost> ghosts = controller.getAllGhosts();
        assertTrue(ghosts.isEmpty());
    }
}
=======
}

>>>>>>> dev
