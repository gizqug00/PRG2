package es.unileon.prg2.patterns.iterator;

public class ListIterator<T> implements Iterator<T> {

    private Aggregate<T> aggregate;
    private int current;

    public ListIterator(Aggregate<T> aggregate) {
        this.aggregate = aggregate;
        this.current = 0;
    }

    @Override
    public void firstElement() {
        current = 0;
    }

    @Override
    public void nextElement() {
        if (hasMoreElements()) {
            current++;
        }
    }

    @Override
    public boolean hasMoreElements() {
        return current < aggregate.getSize();
    }

    @Override
    public T currentElement() {
        if (hasMoreElements()) {
            return aggregate.get(current);
        }
        return null;
    }
}

