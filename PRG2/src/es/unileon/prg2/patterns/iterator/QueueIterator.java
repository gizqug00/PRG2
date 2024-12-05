package es.unileon.prg2.patterns.iterator;

public class QueueIterator<T> implements Iterator<T> {

    private Aggregate<T> aggregate;
    private int current;

    public QueueIterator(Aggregate<T> aggregate) {
        this.aggregate = aggregate;
        this.current = aggregate.getSize() - 1; // Comienza desde el último elemento
    }

    @Override
    public void firstElement() {
        current = aggregate.getSize() - 1; // Establece el índice al último elemento
    }

    @Override
    public void nextElement() {
        if (hasMoreElements()) {
            current--; // Decrementa el índice para ir al elemento anterior
        }
    }

    @Override
    public boolean hasMoreElements() {
        return current >= 0; // Verifica si todavía hay elementos por recorrer
    }

    @Override
    public T currentElement() {
        if (hasMoreElements()) {
            return aggregate.get(current); // Devuelve el elemento actual
        }
        return null; // Si no hay más elementos, retorna null
    }
}
