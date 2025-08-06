/*  Ejercicio 2

Implemente en JAVA un algoritmo que dado 2 árboles binarios de
búsqueda determine si ambos tienen la misma estructura. Por estructura
nos referimos a la misma configuración de nodos sin importar el valor de
los mismos. */

public boolean esMisma(TreeNodo arb1, TreeNodo arb2) {
    // Caso base: ambos son null → misma estructura
    if (arb1 == null && arb2 == null) {
        return true;
    }
    // Si uno es null y el otro no → distinta estructura
    if (arb1 == null || arb2 == null) {
        return false;
    }
    // Comparar estructuras de subárbol izquierdo y derecho
    return esMisma(arb1.getLeft(), arb2.getLeft() && arb1.getRight(), arb2.getRight());
}
