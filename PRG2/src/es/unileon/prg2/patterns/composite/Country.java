package es.unileon.prg2.patterns.composite;

import es.unileon.prg2.patterns.handler.*;
import es.unileon.prg2.patterns.iterator.*;

public class Country extends Composite{

    public Country(GenericId country){
        super(country);
    }

    public Country(Name name) {
        super(new GenericId(name.toString()));
    }

    @Override
    public Level getLevel() {
        return Level.COUNTRY;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\tCountry: ").append(this.id).append("\n"); 
        for (Iterator<ElectionsComponent> it = this.composite.createIterator(); it.hasMoreElements(); it.nextElement()) {
            sb.append(it.currentElement().toString());
        }
        return sb.toString();
    }

}

