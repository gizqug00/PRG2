package es.unileon.prg2.patterns.handler;

public class Name implements Handler {

    private String name;

    public Name(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        this.name = name;
    }

    public Name(Name other) {
        if (other == null) {
            throw new IllegalArgumentException("Other name cannot be null");
        }
        this.name = other.name;
    }

    @Override
    public int compareTo(Handler other) {
        if (other == null || !(other instanceof Name)) {
            throw new IllegalArgumentException("Comparison must be with another Name");
        }

        Name otherName = (Name) other;
        return this.name.compareTo(otherName.name); 
    }

    @Override
    public String toString() {
        return this.name; 
    }
}
