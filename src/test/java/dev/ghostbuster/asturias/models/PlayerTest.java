package dev.ghostbuster.asturias.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {
      private Player player;

    @BeforeEach
    void setUp() {
        player = new Player("TestPlayer");
    }

    @Test
    void testCaptureGhost() {
        player.captureGhost("Phantom", GhostClassEnum.CLASE_III, GhostDangerLevelEnum.MEDIO, "Invisibilidad", "8/10");
        List<Ghost> ghosts = player.getGhosts();
        assertEquals(1, ghosts.size());
        assertEquals("Phantom", ghosts.get(0).getGhostName());
    }

    @Test
    void testReleaseGhostById() {
        player.captureGhost("Specter", GhostClassEnum.CLASE_I, GhostDangerLevelEnum.BAJO, "Flotar", "10/10");
        int ghostId = player.getGhosts().get(0).getId();
        assertTrue(player.releaseGhostById(ghostId));
        assertTrue(player.getGhosts().isEmpty());
    }

    @Test
    void testFilterGhostsByClass() {
        player.captureGhost("Wraith", GhostClassEnum.CLASE_IV, GhostDangerLevelEnum.ALTO, "Telepatía", "2/10");
        List<Ghost> filtered = player.filterGhostsByClass(GhostClassEnum.CLASE_IV);
        assertThat(filtered, hasSize(1));
        assertEquals("Wraith", filtered.get(0).getGhostName());
    }

    @Test
    void testFilterGhostsByDangerLevel() {
        player.captureGhost("Ghoul", GhostClassEnum.CLASE_V, GhostDangerLevelEnum.CRITICO, "Terror", "5/10");
        List<Ghost> filtered = player.filterGhostsByDangerLevel(GhostDangerLevelEnum.CRITICO);
        assertThat(filtered, hasSize(1));
        assertEquals("Ghoul", filtered.get(0).getGhostName());
    }

    @Test
    void testFilterGhostsByDate() {
        String today = LocalDate.now().toString();
        player.captureGhost("Spirit", GhostClassEnum.CLASE_II, GhostDangerLevelEnum.MEDIO, "Levitar", "7/10");
        List<Ghost> filtered = player.filterGhostsByDate(today);
        assertThat(filtered, hasSize(1));
        assertEquals("Spirit", filtered.get(0).getGhostName());
    }

    @Test
    void testGetPlayerName() {
        assertEquals("TestPlayer", player.getPlayerName());
    }
}
