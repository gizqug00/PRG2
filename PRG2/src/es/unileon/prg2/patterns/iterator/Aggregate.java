package es.unileon.prg2.patterns.iterator;

public interface Aggregate<T> {
    Iterator<T> createIterator();
    Iterator<T> createIterator(String type);
    int getSize();
    T get(int index);
    boolean add(T element);
    boolean remove(int index);
}

