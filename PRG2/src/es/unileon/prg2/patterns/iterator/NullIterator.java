package es.unileon.prg2.patterns.iterator;

public class NullIterator<T> implements Iterator<T> {

    @Override
    public void firstElement() {}

    @Override
    public void nextElement() {}

    @Override
    public boolean hasMoreElements() {
        return false;
    }

    @Override
    public T currentElement() {
        return null;
    }
}
