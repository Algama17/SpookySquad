package dev.ghostbuster.asturias.models;

public enum GhostClassEnum {
<<<<<<< HEAD
=======

>>>>>>> dev
    CLASE_I("Manifestación menor", 1),
    CLASE_II("Aparición móvil", 2),
    CLASE_III("Entidad inteligente", 3),
    CLASE_IV("Fantasma histórico", 4),
    CLASE_V("Espíritu antropomorfo", 5),
    CLASE_VI("Espíritu demoníaco", 6),
    CLASE_VII("Entidad ultraterrena", 7);

    private final String descriptionClass;
    private final int levelClass;

    GhostClassEnum(String descriptionClass, int levelClass) {
        this.descriptionClass = descriptionClass;
        this.levelClass = levelClass;

    }  
    public String getDescriptionClass() {
        return descriptionClass;
    }

    public int getLevelClass() {
        return levelClass;
    }  

    public String getInfoClass() {
        return String.format("Clase %s: %s", levelClass, descriptionClass);
    }

    public static String[] getDisplayNames() {
        GhostClassEnum[] values = GhostClassEnum.values();
        String[] displayNames = new String[values.length];
        for (int i = 0; i < values.length; i++) {
<<<<<<< HEAD
            displayNames[i] = values[i].getInfoClass();
        }
        return displayNames;
    }

    public static GhostClassEnum fromDisplayName(String displayName) {
        for (GhostClassEnum ghostClass : values()) {
            if (ghostClass.getInfoClass().equals(displayName)) {
                return ghostClass;
            }
        }
        throw new IllegalArgumentException("No se encontró una clase de fantasma para: " + displayName);
    }
}
=======
            displayNames[i] = values[i].getInfoClass(); 
        }
        return displayNames;
    }
}
>>>>>>> dev
