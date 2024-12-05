package es.unileon.prg2.patterns.iterator;

public class QueueIterator<T> implements Iterator<T> {

    private Aggregate<T> aggregate;
    private int current;

    public QueueIterator(Aggregate<T> aggregate) {
        this.aggregate = aggregate;
        this.current = aggregate.getSize() - 1; 
    }

    @Override
    public void firstElement() {
        current = aggregate.getSize() - 1; 
    }

    @Override
    public void nextElement() {
        if (hasMoreElements()) {
            current--; 
        }
    }

    @Override
    public boolean hasMoreElements() {
        return current >= 0; 
    }

    @Override
    public T currentElement() {
        if (hasMoreElements()) {
            return aggregate.get(current); 
        }
        return null;
    }
}
