package ProgramacionIII.TP2_1_Arboles;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeSearch {
    private TreeNodeInt root;

    public BinaryTreeSearch(TreeNodeInt root) {
        this.root = root;
    }
    /* Ejercicio 1
    Implemente la estructura de Árbol Binario para búsquedas.

    Métodos:
    • Integer getRoot(), boolean hasElem(Integer), boolean isEmpty(), void insert(Integer),
    boolean delete(Integer), int getHeight(), void printPosOrder(), void printPreOrder(), void
    printInOrder(), List getLongestBranch(), List getFrontera(), Integer getMaxElem(), List getElemAtLevel(int) */
    // Complejidad O(1), solo devuelve la raiz
    public Integer getRoot() {
        if (root == null) {
            return null;
        }
        return this.root.getValue();
    }

    // Complejidad O(h), h es la altura del arbol
    // Complejidad O(log n) en un arbol balanceado, O(n) si es desbalanceado
    public boolean hasElem(Integer value) {
        return hasElemPath(this.root, value);
    }

    private boolean hasElemPath(TreeNodeInt node, Integer value) {
        if (node == null) {
            return false;
        }
        if (node.getValue().equals(value)) {
            return true;
        }
        if (node.getValue() > value) {
            return hasElemPath(node.getLeft(), value);
        } else {
            return hasElemPath(node.getRight(), value);
        }
    }

    // Complejidad O(1)
    public boolean isEmpty() {
        return root == null;
    }

    // Complejidad O(n)
    public void insert(Integer value) {
        if (this.root == null) {
            this.root = new TreeNodeInt(value);
        } else {
            insertPath(this.root, value);
        }
    }

    private void insertPath(TreeNodeInt pointer, Integer value) {
        if (pointer.getValue() > value) {
            if (pointer.getLeft() == null) {
                pointer.setLeft(new TreeNodeInt(value));
            } else {
                insertPath(pointer.getLeft(), value);
            }
        } else if (pointer.getValue() < value) {
            if (pointer.getRight() == null) {
                pointer.setRight(new TreeNodeInt(value));
            } else {
                insertPath(pointer.getRight(), value);
            }
        }
    }

    // Complejidad O(n)
    public boolean delete(Integer value) {
        if (this.root != null) {
            this.root = delete(this.root, value);
            return true;
        } else {
            return false;
        }
    }

    private TreeNodeInt delete(TreeNodeInt pointer, Integer value) {
        if (value > pointer.getValue()) { // Si value > nodo, busca por la derecha
            pointer.setRight(delete(pointer.getRight(), value));
        } else if (value < pointer.getValue()) { // Si value < nodo, busca por la izquierda
            pointer.setLeft(delete(pointer.getLeft(), value));
        } else { // Si value == nodo.value (Caso sin hijos o con 1 hijo, es lo mismo)
            if (pointer.getLeft() == null) { // Si el izquierdo es null, lo reemplaza con el nodo de la derecha
                return pointer.getRight();
            } else if (pointer.getRight() == null) { // Si el de la derecha es null, lo reemplaza con el nodo de la izquierda
                return pointer.getLeft();
            }
            // Si no se cumple ninguna de esas condiciones, es porque el nodo encontrado tiene dos hijos
            // Buscamos el mayor de la izquierda
            // Intercambiamos el value, no el nodo. Ademas despues tenemos que borrar el nodo que convertimos a nodo padre
            TreeNodeInt max = findMaxValueNode(pointer.getLeft());
            pointer.setValue(max.getValue());
            pointer.setLeft(delete(pointer.getLeft(), max.getValue()));
        }
        return pointer;
    }

    private TreeNodeInt findMaxValueNode(TreeNodeInt pointer) {
        TreeNodeInt current = pointer;
        while (current.getRight() != null) {
            current = current.getRight();
        }
        return current;
    }

    // Complejidad O(n)
    public int getHeight() {
        return getHeight(this.root);
    }

    private int getHeight(TreeNodeInt node) {
        if (node == null) {
            return 0;
        } else {
            // Recorre el arbol por izquierda hasta que llega a null, luego va volviendo busca por la derecha
            // Luego en cada return va comparando cual altura es mas grande, si por izquierda o por derecha y suma +1
            int leftHeight = getHeight(node.getLeft());
            int rightHeight = getHeight(node.getRight());
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public void setRoot(TreeNodeInt root) {
        this.root = root;
    }

    // Complejidad O(n)
    public void printPosOrder() {
        printPosOrder(this.root);
    }

    private void printPosOrder(TreeNodeInt node) {
        if (node != null) {
            printPosOrder(node.getLeft());
            printPosOrder(node.getRight());
            System.out.print(node.getValue() + " ");
        }
    }

    // Complejidad O(n)
    public void printPreOrder() {
        printPreOrder(this.root);
    }

    private void printPreOrder(TreeNodeInt node) {
        if (node != null) {
            System.out.print(node.getValue() + " ");
            printPreOrder(node.getLeft());
            printPreOrder(node.getRight());
        }
    }

    // Complejidad O(n)
    public void printInOrder() {
        printInOrder(this.root);
        System.out.println();
    }

    private void printInOrder(TreeNodeInt node) {
        if (node != null) {
            printInOrder(node.getLeft());
            System.out.print(node.getValue() + " ");
            printInOrder(node.getRight());
        }
    }

    // Complejidad O(n)
    public List<Integer> getLongestBranch() {
        List<Integer> longestBranch = new ArrayList<Integer>();
        List<Integer> currentBranch = new ArrayList<Integer>();
        getLongestBranch(this.root, longestBranch, currentBranch);
        return longestBranch;
    }

    public void getLongestBranch(TreeNodeInt node, List<Integer> longestBranch, List<Integer> currentBranch) {
        if (node != null) {
            currentBranch.add(node.getValue());
            if (node.getLeft() == null && node.getRight() == null) {
                if (currentBranch.size() > longestBranch.size()) {
                    longestBranch.clear();
                    longestBranch.addAll(currentBranch);
                }
            } else {
                getLongestBranch(node.getLeft(), longestBranch, currentBranch);
                getLongestBranch(node.getRight(), longestBranch, currentBranch);
            }
            currentBranch.remove(currentBranch.size() - 1);
        }
    }

    // Complejidad O(n)
    public List<Integer> getFrontera() {
        List<Integer> frontera = new ArrayList<Integer>();
        getFrontera(this.root, frontera);
        return frontera;
    }

    public void getFrontera(TreeNodeInt node, List<Integer> frontera) {
        if (node != null) {
            if (node.getLeft() == null && node.getRight() == null) {
                frontera.add(node.getValue());
            } else {
                getFrontera(node.getLeft(), frontera);
                getFrontera(node.getRight(), frontera);
            }
        }
    }

    // Complejidad O(h), recorre la altura maxima en el peor de los casos
    public Integer getMaxElem() {
        if (this.root == null) {
            return null;
        }
        TreeNodeInt current = this.root;
        findMaxValueNode(current);
        return current.getValue();
    }

    // Complejidad O(n)
    public List<Integer> getElemAtLevel(int level) {
        List<Integer> resultList = new ArrayList<Integer>();
        getElemAtLevel(this.root, resultList, level, 1);
        return resultList;
    }

    public void getElemAtLevel(TreeNodeInt node, List<Integer> resultList, int level, int currentLevel) {
        if (node != null) {
            if (currentLevel == level) {
                resultList.add(node.getValue());
            } else {
                getElemAtLevel(node.getLeft(), resultList, level, currentLevel + 1);
                getElemAtLevel(node.getRight(), resultList, level, currentLevel + 1);
            }
        }
    }

    /* Ejercicio 2
    Dado un árbol binario de búsquedas que almacena números enteros, implementar un algoritmo
    que retorne la suma de todos los nodos internos del árbol. */
    public int internalSumNodes() {
        return internalSumNodes(this.root);
    }

    private int internalSumNodes(TreeNodeInt node) {
        // Solo se suman los nodos que tienen al menos un hijo
        if (node == null) {
            return 0;
        }
        if (node.getLeft() == null && node.getRight() == null) {
            return 0;
        }
        // Suma el valor del nodo actual
        // Llama recursivamente los subarboles y suma los nodos internos
        return node.getValue() + internalSumNodes(node.getLeft()) + internalSumNodes(node.getRight());
    }

    /* Ejercicio 3
    Dado un árbol binario de búsqueda que almacena números enteros y un valor de entrada K, implementar un
    algoritmo que permita obtener un listado con los valores de todas las hojas cuyo valor supere K. Por ejemplo,
    para el árbol de la derecha, con un valor K = 8, el resultado debería ser [9, 11]. */
    public List<Integer> findLeavesGreaterThan(int k) {
        List<Integer> resultList = new ArrayList<Integer>();
        findLeavesGreaterThan(this.root, resultList, k);
        return resultList;
    }

    public void findLeavesGreaterThan(TreeNodeInt node, List<Integer> resultList, int k) {
        if (node != null) {
            if (node.getLeft() == null && node.getRight() == null) {
                if (node.getValue() > k) {
                    resultList.add(node.getValue());
                } else {
                    findLeavesGreaterThan(node.getRight(), resultList, k);
                    findLeavesGreaterThan(node.getLeft(), resultList, k);
                }
            }
        }
    }
}
