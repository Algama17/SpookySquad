package dev.ghostbuster.asturias.controller;
import java.util.List;
import dev.ghostbuster.asturias.models.Ghost;
import dev.ghostbuster.asturias.models.GhostClassEnum;
import dev.ghostbuster.asturias.models.GhostDangerLevelEnum;
import dev.ghostbuster.asturias.models.Player;
public class Controller {
    private final Player player;
    public Controller(String playerName) {
        this.player = new Player(playerName);
    }
    public void captureGhost(String ghostName, GhostClassEnum ghostClass, GhostDangerLevelEnum dangerLevel,
            String specialAbility, String ghostAfinity) {
        player.captureGhost(ghostName, ghostClass, dangerLevel, specialAbility, ghostAfinity);
    }
    public boolean releaseGhostById(int id) {
        return player.releaseGhostById(id);
    }
    public List<Ghost> filterGhostsByClass(GhostClassEnum ghostClass) {
        return player.filterGhostsByClass(ghostClass);
    }
    public List<Ghost> filterGhostsByDangerLevel(GhostDangerLevelEnum dangerLevel) {
        return player.filterGhostsByDangerLevel(dangerLevel);
    }
    public List<Ghost> filterGhostsByDate(String captureDate) {
        return player.filterGhostsByDate(captureDate);
    }
    public List<Ghost> getAllGhosts() {
        return player.getGhosts();
    }
    public String getPlayerName() {
        return player.getPlayerName();
    }
}