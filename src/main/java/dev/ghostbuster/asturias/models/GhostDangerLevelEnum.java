package dev.ghostbuster.asturias.models;

public enum GhostDangerLevelEnum {
    BAJO("Bajo", 1),
    MEDIO("Medio", 2),
    ALTO("Alto", 3),
    CRITICO("Crítico", 4);

    private final String displayName;
    private final int level;

    GhostDangerLevelEnum(String displayName, int level) {
        this.displayName = displayName;
        this.level = level;
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
        return level;
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

    public static String[] getDisplayNames() {
        GhostDangerLevelEnum[] values = GhostDangerLevelEnum.values();
        String[] displayNames = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            displayNames[i] = values[i].getLevelName();
        }
        return displayNames;
    }

    public static GhostDangerLevelEnum fromDisplayName(String displayName) {
        for (GhostDangerLevelEnum level : values()) {
            if (level.getLevelName().equalsIgnoreCase(displayName)) {
                return level;
            }
        }
        throw new IllegalArgumentException("No se encontró nivel de peligro para: " + displayName);
    }
}
