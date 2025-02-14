package dev.ghostbuster.asturias.models;

public class Ghost {

    private int id;
    private String ghostName;
    private GhostClassEnum ghostClass;
    private GhostDangerLevelEnum dangerLevel;
    private String captureDate;
    private String specialAbility;
    private String ghostAfinity;

    public Ghost(int id, String ghostName, GhostClassEnum ghostClass, GhostDangerLevelEnum dangerLevel, String captureDate, String specialAbility, String ghostAfinity) {
        this.id = id;
        this.ghostName = ghostName;
        this.ghostClass = ghostClass;
        this.dangerLevel = dangerLevel;
        this.captureDate = captureDate;
        this.specialAbility = specialAbility;
        this.ghostAfinity = ghostAfinity;
    }

    public int getId() {
        return id;
    }

    public String getGhostName() {
        return ghostName;
    }

    public GhostClassEnum getGhostClass() {
        return ghostClass;
    }

    public GhostDangerLevelEnum getDangerLevel() {
        return dangerLevel;
    }

    public String getCaptureDate() {
        return captureDate;
    }

    public String getSpecialAbility() {
        return specialAbility;
    }

    public String getGhostAfinity() {
        return ghostAfinity;
    }

    @Override
    public String toString() {
        return String.format(
            "%-5d %-20s %-35s %-15s %-15s %-20s %-15s",
            id,
            ghostName,
            ghostClass.getInfoClass(),
            dangerLevel.getLevelName(),
            captureDate,
            specialAbility,
            ghostAfinity
        );
    }

}
