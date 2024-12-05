package es.unileon.prg2.patterns.composite;

public class CompositeException extends Exception{

    public CompositeException(String e) {
        super(e);
    }

    public CompositeException() {
        super("Se ha producido una excepción en el patrón Composite");
    }

}


