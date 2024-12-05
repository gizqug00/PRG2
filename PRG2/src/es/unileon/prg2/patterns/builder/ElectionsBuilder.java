package es.unileon.prg2.patterns.builder;

import es.unileon.prg2.patterns.composite.*;
import es.unileon.prg2.patterns.handler.Name;

public interface ElectionsBuilder {
    ElectionsComponent getResult();

    void addProvince(Name name) throws CompositeException;

    void addMunincipe(Name name) throws CompositeException;

    void addDistrict(Name name) throws CompositeException;

    void addSection(Name name) throws CompositeException;

    void addElectoralTableWithVotes(Name name, int maxVotes) throws CompositeException;

    void addCountry(Name name);

    void addRegion(Name name) throws CompositeException;
}
