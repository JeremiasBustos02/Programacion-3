/*
Si un vertice tiene 4 o mas arcas relacionados a el (que no sea a el mismo), es un vertice de conexion, es decir,
si se pierde ese vertice, se pierde el grafo conexo.

public List<Integer> grafosDeArticulacion(Grafo g) {
    List<Integer> sol = new ArrayList<>();
    Iterator<Integer> verticesIt = g.obtenerVertices();

    while (verticesIt.hasNext()) {
        Integer v = verticesIt.next();
        Iterator<Arco<T>> arcosIt = g.obtenerArcos(v);
        List<Arco<T>> arcos = new ArrayList<>();
        while (arco.hasNext()) {
            arcos.add(arcosIt.next());
        }
        if (g.tieneArco(v,v) && arcos.size() > 4) {
            sol.add(v);
        } else if (!g.tieneArco(v,v) && arcos.size() >= 4) {
            sol.add(v);
        }
    }

    return sol;
}
 */