package es.unileon.prg2.patterns.composite;

import es.unileon.prg2.patterns.handler.GenericId;
import es.unileon.prg2.patterns.handler.Name;
import es.unileon.prg2.patterns.iterator.*;

public class Province extends Composite{

    public Province(GenericId province){
        super(province);
    }

    public Province(Name name) {
        super(new GenericId(name.toString()));
    }

    public Level getLevel() {
        return Level.PROVINCE;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t\t\tProvince: ").append(this.id).append("\n"); 
        for (Iterator<ElectionsComponent> it = this.composite.createIterator(); it.hasMoreElements(); it.nextElement()) {
            sb.append(it.currentElement().toString());
        }
        return sb.toString();
    }
    
}