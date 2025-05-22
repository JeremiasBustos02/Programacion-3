package ProgramacionIII.TP4_Grafos;

import java.util.*;

/* Ejercicio 2
Implemente los recorridos Depth-First-Search*/

public class ServicioDFS<T> {
    private Grafo<T> grafo;
    private static final int BLANCO = 0;
    private static final int AMARILLO = 1;
    private static final int NEGRO = 2;
    private final HashMap<Integer, Integer> distancias = new HashMap<Integer, Integer>();
    private int tiempo;

    public ServicioDFS(Grafo<T> grafo) {
        this.grafo = grafo;
    }

    public void DFS() {
        // Con color llevamos el control del estado de cada vertice
        HashMap<Integer, Integer> color = new HashMap<Integer, Integer>();
        // Con verticesIterator recorremos todos los vertices del grafo
        Iterator<Integer> verticesIterator = grafo.obtenerVertices();

        // Pintamos de blanco todos los vertices
        while (verticesIterator.hasNext()) {
            color.put(verticesIterator.next(), BLANCO);
        }
        tiempo = 0;
        // Obtenemos nuevamente el iterador
        verticesIterator = grafo.obtenerVertices();
        // Ahora iniciamos DFS en cada vertice que no fue visitado
        while (verticesIterator.hasNext()) {
            Integer vertice = verticesIterator.next();
            if (color.get(vertice) == BLANCO) {
                DFS_Visit(vertice, color);
            }
        }

    }

    public void DFS_Visit(Integer vertice, HashMap<Integer, Integer> color) {
        // Marcamos el vertice como visitado
        color.put(vertice, AMARILLO);
        tiempo++;

        // Obtenemos los adyacentes del vertice donde estamos parado
        Iterator<Integer> verticesAdyacentes = grafo.obtenerAdyacentes(vertice);

        while (verticesAdyacentes.hasNext()) {
            Integer adyacente = verticesAdyacentes.next();
            // Si todavia no fue visitado, seguimos explorando
            if (color.get(adyacente) == BLANCO) {
                DFS_Visit(adyacente, color);
            } else {
                /* Ejercicio 3 */
                /* Implemente un algoritmo que determine si un grafo dirigido tiene algún ciclo. */
                if (color.get(adyacente) == AMARILLO) {
                    System.out.println("Existe un ciclo");
                }
            }
        }
        // Cuanado ya no hay mas adyacente por explorar, lo marcamos como negro
        color.put(vertice, NEGRO);
        // Guardamos el tiempo de finalización del vertice
        distancias.put(vertice, tiempo);
    }

    public List<Integer> caminoMasLargo(Grafo<T> grafo, int inicio, int fin) {
        ArrayList<Integer> visitados = new ArrayList<Integer>();
        ArrayList<Integer> caminoMasLargo = new ArrayList<Integer>();
        visitados.add(inicio);
        dfsCaminoMasLargo(grafo, inicio, fin, visitados, caminoMasLargo);
        return caminoMasLargo;

    }

    public void dfsCaminoMasLargo(Grafo<T> grafo, int actual, int fin, ArrayList<Integer> visitados, ArrayList<Integer> caminoMasLargo) {
        if (actual == fin) {
            if (visitados.size() > caminoMasLargo.size()) {
                caminoMasLargo.clear();
                caminoMasLargo.addAll(visitados);
            }
            return;
        }
        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(actual);
        while (adyacentes.hasNext()) {
            Integer adyacente = adyacentes.next();
            if (!visitados.contains(adyacente)) {
                visitados.add(adyacente);
                dfsCaminoMasLargo(grafo, adyacente, fin, visitados, caminoMasLargo);
                visitados.remove(adyacente); // Backtracking
            }
        }

    }

    /* Ejercicio 5 */
    /* Escriba un algoritmo que dado un grafo G y un vértice v de dicho grafo, devuelva una lista
    con todos los vértices a partir de los cuales exista un camino en G que termine en v.
     */
    public List<Integer> verticesTerminenEnV(Grafo<T> grafo, int verticeDestino) {
        Set<Integer> solucion = new HashSet<Integer>();
        Iterator<Integer> verticesIterator = grafo.obtenerVertices();

        while (verticesIterator.hasNext()) {
            Integer vertice = verticesIterator.next();
            if ((vertice != verticeDestino) && (!solucion.contains(vertice))) {
                List<Integer> visitados = new ArrayList<Integer>();
                dfsVerticesTerminenEnV(verticeDestino, vertice, grafo,  visitados, solucion);
            }
        }
        return new ArrayList<>(solucion);
    }

    public void dfsVerticesTerminenEnV(int verticeDestino, Integer vertice, Grafo<T> grafo, List<Integer> visitados, Set<Integer> solucion) {
        // Si esta en visitados agrego todo el camino y freno la recursividad
        if (vertice.equals(verticeDestino)) {
            solucion.addAll(visitados);
            return;
        }

        visitados.add(vertice);
        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(vertice);
        while (adyacentes.hasNext()) {
            Integer adyacente = adyacentes.next();
            if (!visitados.contains(adyacente)) {
                dfsVerticesTerminenEnV(verticeDestino, adyacente, grafo,  visitados, solucion);
            }
        }
    }

    /* Ejercicio 7 */
    /* Dado un grafo no orientado que modela las rutas de la provincia de Buenos Aires, devolver
    todos los caminos alternativos que se pueden tomar para ir desde la ciudad de Buenos Aires
    a la ciudad de Tandil, considerando que en el tramo Las Flores-Rauch está cortado al tránsito. */

    public List<List<Integer>> buscarDestinoConTransito(Grafo<T> grafo, int inicio, int fin, int trans1, int trans2) {
        List<List<Integer>> caminos = new ArrayList<>();
        List<Integer> caminoActual = new ArrayList<>();

        // Recorremos por los adyacentes de inicio para no recorrer de más
        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(inicio);
        while (adyacentes.hasNext()) {
            Integer adyacente = adyacentes.next();
            dfsbuscarDestinoConTransito(grafo, adyacente, fin, trans1, trans2, caminoActual, caminos);
        }
        return caminos;
    }

    public void dfsbuscarDestinoConTransito(Grafo<T> grafo, int actual, int fin, int trans1, int trans2, List<Integer> caminoActual, List<List<Integer>> caminos) {
        // Si el vertice actual ya esta en caminoActual, vuelve
        if (caminoActual.contains(actual)) {
            return;
        }

        caminoActual.add(actual);

        // Si actual es igual a fin, añadimos el camino a caminos
        if (actual == fin) {
            caminos.add(new ArrayList<>(caminoActual));
            caminoActual.remove(actual);
            return;
        }

        // Hacemos busqueda DFS para todos los adyacentes
        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(actual);
        while (adyacentes.hasNext()) {
            Integer siguiente = adyacentes.next();
            if ((actual == trans1 && siguiente == trans2) || (actual == trans2 && siguiente == trans1)) {
                continue;
            }
            dfsbuscarDestinoConTransito(grafo, siguiente, fin, trans1, trans2, caminoActual, caminos);
        }

        // Hacemos backtracking
        caminoActual.remove(actual);
    }

    /* Se dispone de un conjunto de tareas, donde cada tarea tiene un nombre, una descripción y
    una duración (medida en horas). Se sabe también que hay una dependencia en el orden
    posible en el cual se pueden ejecutar estas tareas y un tiempo de espera entre dos tareas
    consecutivas (también medido en horas). Por ejemplo, si la tarea B depende de la tarea A y
    tiene un tiempo de espera de 5 horas; significa que:

        ● B no puede ejecutarse antes que A y,
        ● B debe ejecutarse 5 horas después de haber finalizado la ejecución de A.

    Objetivo
    Implementar un algoritmo que obtenga la secuencia de ejecución crítica de estas tareas, es
    decir, la secuencia de tareas que resulta en el máximo tiempo empleado para su ejecución.

    Por ejemplo: si partimos de la siguiente configuración podemos encontrar el camino crítico en
    la secuencia de tareas [0, 2, 5, 6, 10], ya que su tiempo de ejecución es la duración de cada
    tarea más el tiempo de espera entre cada par de tareas: 70 horas. */

    public List<Integer> secuenciaEjecucionCritica(Grafo<T> grafo) {
        List<Integer> camino =  new ArrayList<>();
        List<Integer> caminoFinal =  new ArrayList<>();
        int sumaTotal = 0;
        int suma = 0;
        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(0);
        while (adyacentes.hasNext()) {
            Integer adyacente = adyacentes.next();
            dfsSecuenciaEjecucionCritica(adyacente, suma, sumaTotal, camino, caminoFinal, grafo);
        }
        return caminoFinal;
    }

    public void dfsSecuenciaEjecucionCritica(Integer adyacente, int suma, int sumaTotal, List<Integer> camino, List<Integer> caminoFinal, Grafo<T> grafo) {
        // Si el vertice actual ya esta en caminoActual, vuelve
        if (camino.contains(adyacente)) {
            return;
        }

        camino.add(adyacente);
        suma += grafo.obtenerDuracion;

        Iterator<Integer> adyacentes =  grafo.obtenerAdyacentes(adyacente);
        while (adyacentes.hasNext()) {
            Integer siguiente = adyacentes.next();
            Arco<T> arco = grafo.obtenerArco(adyacente,  siguiente);
            suma += arco.getEtiqueta();
            dfsSecuenciaEjecucionCritica(siguiente, suma, sumaTotal, camino, caminoFinal, grafo);
        }
        if (suma > sumaTotal) {
            sumaTotal = suma;
            caminoFinal = new ArrayList<>(camino);
        }
        // Hacemos backtracking
        camino.remove(adyacente);
    }
}
