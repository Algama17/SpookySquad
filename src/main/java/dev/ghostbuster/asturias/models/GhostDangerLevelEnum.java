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
    public static String[] getDisplayNames() {
        GhostDangerLevelEnum[] values = GhostDangerLevelEnum.values();
        String[] displayNames = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            displayNames[i] = values[i].getLevelName(); // Usa getLevelName() para obtener el nombre descriptivo
        }
        return displayNames;
} 
}




