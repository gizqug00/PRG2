package es.unileon.prg2.patterns.composite;

public class Level {

    private static Level instancia;

    public static final Level COUNTRY = new Level("COUNTRY");
    public static final Level REGION = new Level("REGION");
    public static final Level PROVINCE = new Level("PROVINCE");
    public static final Level MUNINCIPE = new Level("MUNINCIPE");
    public static final Level DISTRICT = new Level("DISTRICT");
    public static final Level SECTION = new Level("SECTION");
    public static final Level ELECTORALTABLE = new Level("ELECTORALTABLE");

    private String name;

    private Level(String name) {
        this.name = name;
    }

    public static Level getInstancia() {
        if (instancia == null) {
            instancia = new Level("SingletonInstance");
        }
        return instancia;
    }

    public boolean canContain(Level other) {
        if (this == COUNTRY) {
            return other == REGION || other == PROVINCE || other == MUNINCIPE || other == DISTRICT || other == SECTION || other == ELECTORALTABLE;
        } else if (this == REGION) {
            return other == PROVINCE || other == MUNINCIPE || other == DISTRICT || other == SECTION || other == ELECTORALTABLE;
        } else if (this == PROVINCE) {
            return other == MUNINCIPE || other == DISTRICT || other == SECTION || other == ELECTORALTABLE;
        } else if (this == MUNINCIPE) {
            return other == DISTRICT || other == SECTION || other == ELECTORALTABLE;
        } else if (this == DISTRICT) {
            return other == SECTION || other == ELECTORALTABLE;
        } else if (this == SECTION) {
            return other == ELECTORALTABLE; 
        } else if (this == ELECTORALTABLE) {
            return false; 
        }
        throw new IllegalArgumentException("Nivel desconocido: " + this.name);
    }

    public boolean canAdd(ElectionsComponent parent, ElectionsComponent child) {
        return parent.getLevel().canContain(child.getLevel());
    }

    @Override
    public String toString() {
        return this.name;
    }
}
