package es.unileon.prg2.patterns.composite;

import es.unileon.prg2.patterns.handler.*;
import es.unileon.prg2.patterns.iterator.*;

public interface ElectionsComponent {

    boolean add(ElectionsComponent component) throws CompositeException;

    GenericId getId();

    int size();

    boolean remove(ElectionsComponent ana);

    ElectionsComponent search(String id);
    
    ElectionsComponent search(GenericId id);

    ElectionsComponent search(Name name);

    Level getLevel();

    Iterator<ElectionsComponent> createIterator();

    Iterator<ElectionsComponent> createIterator(String type);


}

