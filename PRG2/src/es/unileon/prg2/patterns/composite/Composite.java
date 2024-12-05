package es.unileon.prg2.patterns.composite;

import es.unileon.prg2.patterns.handler.GenericId;
import es.unileon.prg2.patterns.handler.Name;
import es.unileon.prg2.patterns.iterator.*;


public abstract class Composite implements ElectionsComponent{
    
    protected GenericId id;
    protected Aggregate<ElectionsComponent> composite;

    public Composite(GenericId id){
        this.id = id;
        this.composite = new VectorAggregate<>();
    }

    public GenericId getId(){
        return id;
    }

    public boolean add(ElectionsComponent component) {
        if (!this.getLevel().canContain(component.getLevel())) {
            return false; 
        }

        return this.composite.add(component);
    }

    public int size() {
        int count = 0;
    
        Iterator<ElectionsComponent> iterator = this.composite.createIterator();
    
        while (iterator.hasMoreElements()) {
            ElectionsComponent component = iterator.currentElement();
            count += component.size(); 
            iterator.nextElement();
        }
    
        return count;
    }
    

    @Override
    public boolean remove(ElectionsComponent component) {
        for (int i = 0; i < composite.getSize(); i++) {
            ElectionsComponent current = composite.get(i);
            if (current.getId().equals(component.getId())) {
                composite.remove(i);
                return true;
            }
        }
    
        Iterator<ElectionsComponent> iterator = composite.createIterator();
        while (iterator.hasMoreElements()) {
            ElectionsComponent child = iterator.currentElement();
            if (child.remove(component)) {
                return true;
            }
            iterator.nextElement();
        }
    
        return false;
    }
    
    
    
    public ElectionsComponent search(GenericId id) {

        if (this.id.equals(id)) {
            return this;
        }
    
        Iterator<ElectionsComponent> iterator = this.composite.createIterator();
    
        while (iterator.hasMoreElements()) {
            ElectionsComponent current = iterator.currentElement();
            ElectionsComponent result = current.search(id); 
            if (result != null) {
                return result;
            }
            iterator.nextElement();
        }
    
        return null;
    }
    

    public ElectionsComponent search(String id){
        return this.search(new GenericId(id));
    }

    public ElectionsComponent search(Name id){
        return this.search(new GenericId(id.toString()));
    }

    @Override
    public Iterator<ElectionsComponent> createIterator() {
        return new ListIterator<>(this.composite);  
    }

 
    @Override
    public Iterator<ElectionsComponent> createIterator(String type) {
        if ("queue".equalsIgnoreCase(type)) {
            return new QueueIterator<>(this.composite); // Crear un iterador de tipo "queue"
        } else {
            return createIterator(); // Por defecto, usar ListIterator
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Iterator<ElectionsComponent> it = this.composite.createIterator(); it.hasMoreElements(); it.nextElement()) {
            sb.append(it.currentElement().toString());
        }
        return sb.toString();
    }

}
