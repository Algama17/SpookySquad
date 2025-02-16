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
        switch (this) {
            case BAJO: return "Bajo";
            case MEDIO: return "Medio";
            case ALTO: return "Alto";
            case CRITICO: return "Crítico";
            default: return name();
        }
    }
    public int getLevelDanger() {
        return levelDanger;
    }
    public static String[] getDisplayNames() {
        return java.util.Arrays.stream(values())
            .map(level -> {
                switch (level) {
                    case BAJO: return "Bajo";
                    case MEDIO: return "Medio";
                    case ALTO: return "Alto";
                    case CRITICO: return "Crítico";
                    default: return level.name();
                }
            })
            .toArray(String[]::new);
    }
}




