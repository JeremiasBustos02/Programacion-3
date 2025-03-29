package ProgramacionIII.tp1;

import java.util.Iterator;


public class MySimpleLinkedList<T extends Comparable<T>> implements Iterable<T> {
	
	private Node<T> first;
	private int size;
	
	public MySimpleLinkedList() {
		this.first = null;
		size = 0;
	}
	
	public void insertFront(T info) {
		Node<T> tmp = new Node<T>(info,null);
		tmp.setNext(this.first);
		this.first = tmp;
		size++;
	}
	
	public T extractFront() {		
		if (isEmpty()) {
			return null;
		}
		Node<T> tmp = this.first;
		this.first = this.first.getNext();
		T info = tmp.getInfo();
		tmp.setNext(null);
		size--;
		return info;
	}

	public boolean isEmpty() {
        return this.first == null;
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
	
	public int size() {
		return size;
	}
	
	@Override
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
			} else { // tmp es menor que info (tmp < info)
				newNode.setNext(tmp.getNext());
				tmp.setNext(newNode);
			}
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new MyIterator<>(this.first);
	}
}
