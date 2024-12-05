package es.unileon.prg2.patterns.handler;

public class GenericId implements Handler {
    
    private String id;

    public GenericId(String id){
        this.id = id;
    }

    public GenericId(GenericId id){
        this.id = id.toString();
    }

    public String getId() {
        return id;
    }

    public int compareTo(Handler other) {
        return this.id.toString().compareTo(other.toString());
    }

    @Override
    public String toString() {
        return this.id; 
    }


    
}
