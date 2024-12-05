package es.unileon.prg2.patterns.iterator;

import java.util.Vector;

public class VectorAggregate<T> implements Aggregate<T> {

    private Vector<T> elements;

    public VectorAggregate() {
        elements = new Vector<>();
    }

    @Override
    public Iterator<T> createIterator() {
        return new ListIterator<>(this);
    }

    @Override
    public Iterator<T> createIterator(String type) {
        if (type.equalsIgnoreCase("Queue")) {
            return new QueueIterator<>(this);
        } else {
            return createIterator(); // Default ListIterator
        }
    }

    @Override
    public int getSize() {
        return elements.size();
    }

    @Override
    public T get(int index) {
        return elements.get(index);
    }

    @Override
    public boolean add(T element) {
        return elements.add(element);
    }

    @Override
    public boolean remove(int index) {
        if (index >= 0 && index < elements.size()) {
            elements.remove(index);
            return true;
        }
        return false;
    }
}
