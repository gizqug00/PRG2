package es.unileon.prg2.patterns.iterator;

public interface Iterator<T> {
    void firstElement();
    void nextElement();
    boolean hasMoreElements();
    T currentElement();
}
