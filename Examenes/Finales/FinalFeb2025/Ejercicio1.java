/*
Ejercicio 1:

List<Integer> mejorSolucion

public List<Integer> buscarCamino(Grafo g, Integer i, Integer j) {
    List<Integer> camino = new ArrayList<>();
    Set<Integer> visitados = new HashSet<>();
    mejorSolucion = null;
    buscar(g, camino, visitados, i, j);
    return mejorSolucion;
}

private void buscar(Grafo g, List<Integer> camino, Set<Integer> visitados, Integer actual, Integer j) {
    visitados.add(actual);
    camino.add(actual);

    if (actual == j) {
        if (mejorSolucion == null || peso(camino) > peso(mejorSolucion)) {
            mejorSolucion = new ArrayList<>(camino);
        }
        return;
    }

    Iterator<Arco<T>> arcosIt = g.obtenerArcos(actual);
    while (arcosIt.hasNext()) {
        Arco<T> arco = arcosIt.next();
        if (!visitados.contains(arco.getDestino())) {
            buscar(g, camino, visitados, arco.getDestino(), j);
        }
    }

    visitados.remove(actual);
    camino.remove(camino.size()-1);

}

*/