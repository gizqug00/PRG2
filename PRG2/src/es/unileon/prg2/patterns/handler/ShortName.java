package es.unileon.prg2.patterns.handler;

import es.unileon.prg2.patterns.handler.MalformedHandlerException;

public class ShortName implements Handler {

    private String name;

    public ShortName(String name) throws MalformedHandlerException {
        if (name == null || name.isEmpty()) {
            throw new MalformedHandlerException("The identifier can not be an empty one.\n");
        }
        if (!name.matches("[a-zA-Z]+")) {
            throw new MalformedHandlerException("The identifier can only include letters.\n" + 
                                                 name + " is not valid.");
        }
        if (name.length() > 2) {
            throw new MalformedHandlerException("The length of the identifier should be less than 2.\n" + 
                                                 name + " is not valid.");
        }
        this.name = name;
    }

    public ShortName(ShortName other) {
        this.name = other.name; 
    }

    @Override
    public int compareTo(Handler other) {
        if (other instanceof ShortName) {
            ShortName otherName = (ShortName) other;
            int result = this.name.compareTo(otherName.name);
            return Integer.compare(result, 0); 
        }
        return -1; 
    }
    
    @Override
    public String toString() {
        return this.name;
    }
}
