/*
Se desea implementar un recorrido sobre un grafo dirigido mediante la tecnica de DFS pero intentando minimizar la
cantidad de veces que se llama al metodo auxiliar DFS_visit.
Para esto, se propone modificar el metodo DFS para incorporar una estrategia Greedy en busca del objetivo deseado.
Explique que estrategia Greedy se podria utilizar para intentar minimizar la cantidad de llamados la metodo DFS_visit.
Implementar en Java el metodo DFS donde se vea la estrategia Greedy elegida.

Una solucion greedy es ordenar los vertices de mayor a menor segun su cantidad de adyacentes salientes y realizar
el recorrido en ese orden.
*/

    public void dfs(Grafo g) {
        List<Integer> vertices = g.obtenerVertices();
        ordenarPorAdyacencia(vertices, g); // Suponiendo que esta funcion los ordena

        Set<Integer> visitados = new HashSet<>();

        for (int v : vertices) {
            if (!visitados.contains(v)) {
                DFS_visit(g, v, visitados);
            }
        }
    }

    private void DFS_visit(Grafo g, int v, Set<Integer> visitados) {
        visitados.add(v);
        Iterator<Integer> adyacentes = g.obtenerAdyacentes(v);
        while(adyacentes.hasNext()) {
            Integer ady = adyacentes.next();
            if (!visitados.contains(ady)) {
                DFS_visit(g, ady, visitados);
            }
        }


    }
