package dev.ghostbuster.asturias.models;

public enum GhostDangerLevelEnum {

    BAJO("Bajo", 1),
    MEDIO("Medio", 2),
    ALTO("Alto", 3),
    CRITICO("Crítico", 4);

    private final String levelName;
    private final int levelDanger;

    GhostDangerLevelEnum(String levelName, int levelDanger) {
        this.levelName = levelName;
        this.levelDanger = levelDanger;
    }

    public String getLevelName() {
        return levelName;
    }

    public int getLevelDanger() {
        return levelDanger;
    }
}




