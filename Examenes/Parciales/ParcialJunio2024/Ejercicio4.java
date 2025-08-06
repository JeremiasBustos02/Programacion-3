/*
a) Muestre en JAVA la declaración de la clase Lista simplemente vinculada, sus atributos de instancia y la
implementación de sólo los siguientes dos métodos, cada uno deberá tener complejidad O(1):
public void agregarPrincipio(<T> elemento)
public void agregarFinal(<T> elemento)
Suponga que la clase Nodo<T> ya está implementada con los métodos usuales.
Y responda (sin implementar) ¿qué complejidad tendría el método borrarUltimo?, justifique su respuesta.
b) ¿Cuáles son las condiciones que deben darse para que la complejidad de la operación de búsqueda de un
elemento en un árbol binario sea O(log2 n) ?
c) Responda Verdadero o Falso, justificando su respuesta:
i) En una estructura de hashing, definir un rho de diseño chico (por ejemplo 0,3) me asegura que no voy a
tener listas de rebalse.
ii) Luego de la ejecución del algoritmo de Dijkstra sobre un grafo G podemos decir que si en el array de
distancias encontramos algún valor infinito, entonces el
grafo G no es conexo.

b- La búsqueda en un árbol binario de búsqueda (ABB) tiene complejidad O(log₂ n) cuando el árbol está balanceado.

c-
i) Un ρ bajo (como 0.3) reduce la probabilidad de colisiones y rebalses, pero no los elimina por completo, ya que el
comportamiento depende también de la función hash.

ii) El algoritmo de Dijkstra, ejecutado desde un nodo origen, encuentra las distancias mínimas desde ese nodo a todos
los demás accesibles. Si algún nodo queda con distancia infinita (∞), significa que no hay camino desde el origen hasta
ese nodo.
 */

public class Lista<T> {

    private Nodo<T> primero;
    private Nodo<T> ultimo;

    public Lista() {
        primero = null;
        ultimo = null;
    }

    // O(1)
    public void agregarPrincipio(T elemento) {
        Nodo<T> nuevo = new Nodo<>(elemento);
        nuevo.setSiguiente(primero);
        primero = nuevo;

        // Si la lista estaba vacía, también actualizamos "ultimo"
        if (ultimo == null) {
            ultimo = nuevo;
        }
    }

    // O(1)
    public void agregarFinal(T elemento) {
        Nodo<T> nuevo = new Nodo<>(elemento);
        if (ultimo != null) {
            ultimo.setSiguiente(nuevo);
        } else {
            // La lista estaba vacía
            primero = nuevo;
        }
        ultimo = nuevo;
    }
}