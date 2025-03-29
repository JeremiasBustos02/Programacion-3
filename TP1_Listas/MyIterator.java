package ProgramacionIII.TP1_Listas;

import java.util.Iterator;

public class MyIterator<T> implements Iterator<T> {
    private Node<T> current;

    public MyIterator(Node<T> first) {
        this.current = first;
    }

    public boolean hasNext() {
        return current != null;
    }

    public T next() {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        T info = current.getInfo();
        current = current.getNext();
        return info;
    }
}
