/*
Ejercicio 1
Implemente en JAVA un árbol binario de búsqueda cuya clave de búsqueda es un int key y que implementa la técnica de
lista de factoreo en los nodos.

Muestre en JAVA la declaración de la clase Nodo, y de la clase ABB (Árbol Binario de Búsqueda), en particular sus
atributos de instancia y la implementación eficiente de sólo los siguientes métodos de ABB. Para cada uno indique la
complejidad computacional resultante en notación big-O.

a) public boolean agregar(int key, T elemento); // Agrega un nuevo elemento al árbol y retorna true si la clave es
                                                // nueva o false si ya existía en el árbol.
b) public List<T> elementosPorNivel(int level); //Retorna una lista con todos los elementos de un nivel dado del árbol.
c) public boolean esBalanceado(); //Retorna si el árbol es balanceado o no.

Aclaración: si lo requiere puede agregar métodos privados y/o variables de instancia.

public class ABB {
    private Nodo raiz;

    // constructor

    public boolean agregar(int key, T elemento) {
        return agregar(this.raiz, key, elemento);
    }

    private boolean agregar(Nodo actual, int key, T elemento) {
        if (actual == null) {
            Nodo nuevo = new Nodo(key);
            Nodo.agregarElemento(elemento);
            return false;
        } else {
            if (actual.getKey() == key) {
                actual.agregarElemento(elemento);
                return true;
            } else {
                if (actual.getKey > key) {
                    agregar(actual.getLeft(), key, elemento);
                } else {
                    agregar(actual.getRight(), key, elemento);
                }
            }
        }
    }

    public List<T> elementosPorNivel(int level) {
        List<T> elementos = new ArrayList<>();
        elementosPorNivel(raiz, elementos, level);
        return elementos;
    }

    private void elementosPorNivel(Nodo actual, List<T> elementos, int level) {
        if (level == 0) {
            elementos.addAll(actual.getElementos());
            return;
        } else {
            elementosPorNivel(actual.getLeft(), elementos, level-1);
            elementosPorNivel(actual.getRight(), elementos, level-1);
        }
    }

    // Complejidad: O(n), revisa todos los nodos
    public boolean esBalanceado() {
        return esBalanceadoRec(raiz) != -1;
    }

    private int esBalanceadoRec(Nodo<T> nodo) {
        if (nodo == null) return 0;

        int alturaIzq = esBalanceadoRec(nodo.getLeft());
        if (alturaIzq == -1) return -1;

        int alturaDer = esBalanceadoRec(nodo.getRight());
        if (alturaDer == -1) return -1;

        if (Math.abs(alturaIzq - alturaDer) > 1) return -1;

        return Math.max(alturaIzq, alturaDer) + 1;
    }
}

public class Nodo {
    private int key;
    private List<T> elementos;
    private Nodo left;
    private Nodo right;

    public Nodo(int key) {
        this.key = key;
        this.elementos = new ArrayList<>();
        this.left = null;
        this.right = null;
    }

    public Nodo getLeft() {
        return this.left;
    }

    public Nodo.getRight() {
        return this.right;
    }

    public int getKey() {
        return this.key;
    }

    public void agregarElemento(T elemento) {
        elementos.add(elemento);
    }

    public boolean elementosIsEmpty() {
        return elementos.isEmpty();
    }

    public List<T> getElementos() {
        return new ArrayList<T>(this.elementos);
    }
}

*/