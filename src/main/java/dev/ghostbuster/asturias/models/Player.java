package dev.ghostbuster.asturias.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
<<<<<<< HEAD

      private String playerName;
    private final List<Ghost> ghosts = new ArrayList<>();
    private int nextId = 1;
=======
    private String playerName;
    private final List<Ghost> ghosts = new ArrayList<>();
    private int nextId = 1;

>>>>>>> dev
    public Player(String playerName) {
        this.playerName = playerName;
    }

    public void captureGhost(String ghostName, GhostClassEnum ghostClass, GhostDangerLevelEnum dangerLevel, String specialAbility, String ghostAfinity) {
        Ghost ghost = new Ghost(
            nextId++,
            ghostName,
            ghostClass,
            dangerLevel,
            LocalDate.now().toString(),
            specialAbility,
            ghostAfinity
        );
        ghosts.add(ghost);
    }

    public boolean releaseGhostById(int id) {
        return ghosts.removeIf(ghost -> ghost.getId() == id);
    }

    public List<Ghost> filterGhostsByClass(GhostClassEnum ghostClass) {
        return ghosts.stream()
                .filter(ghost -> ghost.getGhostClass() == ghostClass)
                .collect(Collectors.toList());
    }

    public List<Ghost> filterGhostsByDangerLevel(GhostDangerLevelEnum dangerLevel) {
        return ghosts.stream()
                .filter(ghost -> ghost.getDangerLevel() == dangerLevel)
                .collect(Collectors.toList());
    }

    public List<Ghost> filterGhostsByDate(String captureDate) {
        return ghosts.stream()
                .filter(ghost -> ghost.getCaptureDate().equals(captureDate))
                .collect(Collectors.toList());
    }

    public List<Ghost> getGhosts() {
        return new ArrayList<>(ghosts);
    }

    public String getPlayerName() {
        return playerName;
    }
}
