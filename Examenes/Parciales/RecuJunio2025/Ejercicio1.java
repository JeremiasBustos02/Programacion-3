/* Ejercicio 1
Dado un Árbol Binario de Búsqueda, se desea calcular la suma total de los valores almacenados en los nodos del árbol
que están dentro de un cierto rango [L, R]. Es decir, dados dos enteros L y R, hay que sumar todos los valores v
del árbol tales que L <= v <= R.

a) Implemente un algoritmo eficiente en JAVA que recorra solo las partes necesarias del árbol para calcular la
suma de los valores dentro del rango dado.

b) Justifique por qué su algoritmo evita visitar nodos innecesarios.

Por propiedad del BST, si el valor del nodo es menor que L, sabemos que todos los valores en su subarbol izquierdo seran menores.
Lo mismo sucede con el subarbol derecho.

c) Exprese y justifique cuál es la complejidad temporal del algoritmo en el peor caso en la notación Big-O.

La complejidad sera O(n), ya que en el peor de los casos, debera recorrer todos los nodos.

 */

public int searchSum(TreeNode tree, L, R) {
	return search(tree, L, R);
}

private int search(TreeNode actual, int L, int R){
	// Si el actual es null, sumamos un 0
	if (actual == null) return 0;

	int valor = actual.getValor();

	// Si el valor del nodo es menor que L, sabemos que todos los valores en su subárbol izquierdo serán menores 	// (por propiedad del BST), por lo tanto lo ignoramos.

	if (valor < L) {
		return search(actual.getRight(), L, R);
	} else if (valor > R) {
		return search(actual.getLeft(), L, R);
	} else {
		return valor + search(actual.getLeft(), L, R) + search(actual.getRight(), L, R);
	}
}


