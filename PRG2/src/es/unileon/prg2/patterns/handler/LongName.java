package es.unileon.prg2.patterns.handler;

public class LongName implements Handler {
    
    private String name;

    // Constructor
    public LongName(String name) {
        this.name = name;
    }

    public LongName(LongName other) {
        this.name = other.toString();
    }

    @Override
    public int compareTo(Handler other) {
        if (other instanceof LongName) {
            LongName otherName = (LongName) other;
            return this.name.compareTo(otherName.name); 
        }
        return -1; 
    }

    @Override
    public String toString() {
        return this.name; 
    }
}
