/*
public boolean contieneDosCiclos(Grafo g) {
    List<Integer> camino = new ArrayList<>();
    Set<Integer> visitados = new HashSet<>();
    List<List<Integer>> solucion = new ArrayList<>();

    Iterator<Integer> verticesIt = g.obtenerVertices();

    while (verticesIt.hasNext()) {
        Integer v = verticesIt.next();
        dfs(g, v, camino, visitados, solucion);
    }

    if (solucion.size() > 1) {
        return true;
    }
    return false;
}

private void dfs(Grafo g, Integer actual, List<Integer> camino, Set<Integer> visitados,  List<List<Integer>> solucion) {
    camino.add(v);
    visitados.add(v);

    if (solucion.size() > 1) {
        return;
    }

    Iterator<Arco<T>> arcosIt = g.obtenerArcos(v);
    while (arcosIt.hasNext()) {
        Arco<T> arco = arcosIt.next();
        if (!visitados.contains(arco.getDestino())) {
            dfs(g, arco.getDestino()), camino, visitados, solucion);
        } else {
            if (arcoValido(solucion, v, arco.getDestino())) {
                List<Integer> aux = new ArrayList<>();
                aux.add(v);
                aux.add(arco.getDestino());
                solucion.add(aux);
            }
        }
    }
}
*/