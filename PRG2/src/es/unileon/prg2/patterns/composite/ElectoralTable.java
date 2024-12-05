package es.unileon.prg2.patterns.composite;

import es.unileon.prg2.patterns.handler.GenericId;
import es.unileon.prg2.patterns.handler.Name;
import es.unileon.prg2.patterns.iterator.Iterator;
import es.unileon.prg2.patterns.iterator.NullIterator;

public class ElectoralTable implements ElectionsComponent{
   
    private GenericId id;
    private int maxVotes;

    public ElectoralTable(GenericId id){
        this.id = id;
        this.maxVotes = 0;
    }

    public ElectoralTable(String id){
        this(new GenericId(id));
    }

    public ElectoralTable(Name name) {
        this(new GenericId(name.toString()));
    }


    public void setMaxVotes(int maxVotes) {
        this.maxVotes = maxVotes;
    }

    public int getMaxVotes() {
        return this.maxVotes;
    }

    public GenericId getId(){
        return this.id;
    }

    public Level getLevel() {
        return Level.ELECTORALTABLE;
    }

    @Override
    public int size() {
        return 1;
    }

    @Override
    public boolean remove(ElectionsComponent component) {
        return false;
    }

    @Override
    public ElectionsComponent search(GenericId id) {        
        if(this.id.toString().equals(id.toString())){
            return this;
        } else{
            return null;
        }
    }

    @Override
    public ElectionsComponent search(String id) {
        return this.search(new GenericId(id));
    }

    @Override
    public ElectionsComponent search(Name name) {
        return this.search(new GenericId(name.toString()));
    }

    @Override
    public boolean add(ElectionsComponent component) throws CompositeException{
        throw new CompositeException("Nothing can be added to a leaf");
    }

    @Override
    public String toString() {
        return "\t\t\t\t\t\t\tMesa: " + this.id + " Votos máximos: " + this.maxVotes + "\n"; 
    }

    @Override
    public Iterator<ElectionsComponent> createIterator() {
        return new NullIterator<>();
    }
    
    @Override
    public Iterator<ElectionsComponent> createIterator(String type) {
        return new NullIterator<>(); 
    }
    

}