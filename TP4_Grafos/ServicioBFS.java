package ProgramacionIII.TP4_Grafos;

import java.util.*;

public class ServicioBFS<T> {
    private Queue<Integer> fila;
    private static final int BLANCO = 0;
    private static final int AMARILLO = 1;
    private List<Integer> recorrido;

    public ServicioBFS() {
        this.fila = new LinkedList<Integer>();
        this.recorrido = new ArrayList<Integer>();
    }

    public void BFS(Grafo<T> grafo) {
        fila.clear();
        Iterator<Integer> verticesIterator = grafo.obtenerVertices();
        HashMap<Integer, Integer> color = new HashMap<Integer, Integer>();
        // Ponemos todo como no visitado
        while (verticesIterator.hasNext()) {
            color.put(verticesIterator.next(), BLANCO);
        }
        verticesIterator = grafo.obtenerVertices();
        // Por cada vertice del grafo, visitamos.
        while (verticesIterator.hasNext()) {
            Integer vertice = verticesIterator.next();
            if (color.get(vertice) == BLANCO) {
                BFSVisit(vertice, color, grafo);
            }
        }
    }

    public void BFSVisit(Integer vertice, HashMap<Integer, Integer> color, Grafo<T> grafo) {
        // Marcamos visitado
        color.put(vertice, AMARILLO);
        fila.add(vertice);

        while (!fila.isEmpty()) {
            Integer verticeActual = fila.remove();
            recorrido.add(verticeActual);
            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(verticeActual);
            while (adyacentes.hasNext()) {
                Integer adyacente = adyacentes.next();
                if (color.get(adyacente) == BLANCO) {
                    color.put(adyacente, AMARILLO);
                    fila.add(adyacente);
                }
            }
        }
    }

    /* Ejercicio 6 */
    /* Supongamos que una ciudad se encuentra modelada mediante un grafo, donde cada nodo
    es una esquina, y las aristas representan las calles. Diseñe un algoritmo tal que dadas dos
    esquinas, devuelva el camino más corto entre ambas de manera de caminar la menor
    cantidad de cuadras posible. */
    public List<Integer> caminoMasCortoDosEsquinas(Grafo<T> grafo, int inicio, int fin) {
        // Map para hacer el reeconstruir el camino
        Map<Integer, Integer> padres = new HashMap<Integer, Integer>();
        // Set para ver todos los visitados
        Set<Integer> visitado = new HashSet<Integer>();
        // Cola para ir recorriendo
        Queue<Integer> cola = new LinkedList<Integer>();

        cola.add(inicio);
        visitado.add(inicio);
        padres.put(inicio, null);

        while (!cola.isEmpty()) {
            Integer vertice = cola.remove();
            // Si llegamos a destino frenamos el bucle
            if (vertice == fin) {
                break;
            }
            // Si no, seguimos buscando en los siguientes niveles
            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(vertice);
            while (adyacentes.hasNext()) {
                Integer adyacente = adyacentes.next();
                if (!visitado.contains(adyacente)) {
                    visitado.add(adyacente);
                    cola.add(adyacente);
                    padres.put(adyacente, vertice);
                }
            }
        }
        // Una vez encontrado el camino, lo reeconstruimos con el Map padres
        List<Integer> camino = new LinkedList<Integer>();
        Integer paso = fin;
        while (paso != null) {
            camino.add(0, paso);
            paso = padres.get(paso);
        }

        if (!camino.isEmpty() && camino.get(0) == inicio) {
            return camino;
        } else {
            return new ArrayList<>();
        }

    }
}
