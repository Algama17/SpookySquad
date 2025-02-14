package ghostbusters.asturias.model;

public enum GhostClassEnum {
    
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

}
