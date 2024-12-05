package es.unileon.prg2.patterns.builder;

import es.unileon.prg2.patterns.composite.*;
import es.unileon.prg2.patterns.handler.*;
import java.util.HashMap;

public class ElectionsConcreteBuilder implements ElectionsBuilder {
    private ElectionsComponent root;
    private ElectionsComponent current;
    private HashMap<Name, ElectionsComponent> cache;

    public ElectionsConcreteBuilder() {
        this.root = null;
        this.current = null;
        this.cache = new HashMap<>();
    }

    public void addCountry(Name name) {
        // Crear o buscar el país
        if (cache.containsKey(name)) {
            current = cache.get(name); // Si ya existe, establecer como actual
        } else {
            root = new Country(name);
            current = root;
            cache.put(name, root);
        }
    }

    public void addRegion(Name name) throws CompositeException {
        if (current == null || !(current instanceof Country)) {
            throw new IllegalStateException("Primero debes agregar un país.");
        }

        // Crear o buscar la región
        if (cache.containsKey(name)) {
            current = cache.get(name); // Si ya existe, establecer como actual
        } else {
            ElectionsComponent region = new Region(name);
            current.add(region); // Agregar la región al país
            current = region; // Establecer la región como el nuevo 'current'
            cache.put(name, region);
        }
    }

    public void addProvince(Name name) throws CompositeException {
        if (current == null || !(current instanceof Region)) {
            throw new IllegalStateException("Primero debes agregar una región.");
        }

        // Crear o buscar la provincia
        if (cache.containsKey(name)) {
            current = cache.get(name); // Si ya existe, establecer como actual
        } else {
            ElectionsComponent province = new Province(name);
            current.add(province); // Agregar la provincia a la región
            current = province; // Establecer la provincia como el nuevo 'current'
            cache.put(name, province);
        }
    }

    public void addMunincipe(Name name) throws CompositeException {
        if (current == null || !(current instanceof Province)) {
            throw new IllegalStateException("Primero debes agregar una provincia.");
        }

        // Crear o buscar el municipio
        if (cache.containsKey(name)) {
            current = cache.get(name); // Si ya existe, establecer como actual
        } else {
            ElectionsComponent munincipe = new Munincipe(name);
            current.add(munincipe); // Agregar el municipio a la provincia
            current = munincipe; // Establecer el municipio como el nuevo 'current'
            cache.put(name, munincipe);
        }
    }

    public void addDistrict(Name name) throws CompositeException {
        if (current == null || !(current instanceof Munincipe)) {
            throw new IllegalStateException("Primero debes agregar un municipio.");
        }

        // Crear o buscar el distrito
        if (cache.containsKey(name)) {
            current = cache.get(name); // Si ya existe, establecer como actual
        } else {
            ElectionsComponent district = new District(name);
            current.add(district); // Agregar el distrito al municipio
            current = district; // Establecer el distrito como el nuevo 'current'
            cache.put(name, district);
        }
    }

    public void addSection(Name name) throws CompositeException {
        if (current == null || !(current instanceof District)) {
            throw new IllegalStateException("Primero debes agregar un distrito.");
        }

        // Crear o buscar la sección
        if (cache.containsKey(name)) {
            current = cache.get(name); // Si ya existe, establecer como actual
        } else {
            ElectionsComponent section = new Section(name);
            current.add(section); // Agregar la sección al distrito
            current = section; // Establecer la sección como el nuevo 'current'
            cache.put(name, section);
        }
    }

    public void addElectoralTableWithVotes(Name name, int maxVotes) throws CompositeException {
        if (current == null || !(current instanceof Section)) {
            throw new IllegalStateException("Primero debes agregar una sección.");
        }

        // Crear la mesa electoral y establecer los votos máximos
        ElectoralTable electoralTable = new ElectoralTable(name);
        electoralTable.setMaxVotes(maxVotes);
        current.add(electoralTable); // Agregar la mesa electoral a la sección
    }

    @Override
    public ElectionsComponent getResult() {
        return root;
    }
}
