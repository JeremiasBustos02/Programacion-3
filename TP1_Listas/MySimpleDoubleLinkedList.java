package ProgramacionIII.TP1_Listas;

import java.util.Iterator;

public class MySimpleDoubleLinkedList<T extends Comparable<T>> implements Iterable<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    public MySimpleDoubleLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public void insertFront(T info) {
        Node<T> tmp = new Node<>(info, null, null);
        tmp.setNext(first);
        if (first != null) {
            first.setPrev(tmp);
        } else {
            last = tmp;
        }
        first = tmp;
        size++;
    }

    public T extractFront() {
        if (isEmpty()) {
            return null;
        } else {
            Node<T> tmp = first;
            this.first = first.getNext();
            if (first != null) {
                first.setPrev(null);
            } else {
                last = null;
            }
            this.size--;
            return tmp.getInfo();
        }
    }

    public T extractLast() {
        if (isEmpty()) {
            return null;
        } else {
            Node<T> tmp = last;
            this.last = last.getPrev();
            if (last != null) {
                last.setNext(null);
            } else {
                first = null;
            }
            this.size--;
            return tmp.getInfo();
        }
    }

    public boolean isEmpty() {
        return this.first == null || this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public T get(int index) {
        if (isEmpty() || index > this.size || index < 0) {
            return null;
        }
        Node<T> tmp = this.first;
        for (int i = 0; i < index; i++) {
            tmp = tmp.getNext();
        }
        return tmp.getInfo();
    }

    public String toString() {
        Node<T> tmp = this.first;
        StringBuilder str = new StringBuilder();
        while (tmp != null) {
            T info = tmp.getInfo();
            str.append(info.toString());
            tmp = tmp.getNext();
        }
        return str.toString();
    }

    public int indexOf(T info) {
        Node<T> tmp = this.first;
        if (isEmpty()) { return -1; };
        int index = 0;
        while (tmp != null) {
            if (tmp.getInfo().equals(info)) {
                return index;
            }
            tmp = tmp.getNext();
            index++;
        }
        return -1;
    }

    public void insertSorted(T info) {
        Node<T> newNode = new Node<>(info, null);
        // Lista vacia o el nodo es menor que el primero
        if (isEmpty() || info.compareTo(first.getInfo()) < 0) {
            insertFront(info);
        }
        else {
            Node<T> tmp = this.first;
            // Si sig no es null y el siguiente es menor que el nodo
            while (tmp.getNext() != null && info.compareTo(tmp.getNext().getInfo()) > 0) {
                tmp = tmp.getNext();
            }
            // Insertado a lo ultimo
            if (tmp.getNext() == null) {
                tmp.setNext(newNode);
                newNode.setPrev(tmp);
            } else { // tmp es menor que info (tmp < info)
                newNode.setNext(tmp.getNext());
                tmp.getNext().setPrev(newNode);
                newNode.setPrev(tmp);
                tmp.setNext(newNode);
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<>(first);
    }
}
