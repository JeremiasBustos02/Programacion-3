/*
Las ciudades de una provincia y sus rutas estan modeladas mediante un grafo no dirigido conectado. El rótulo de cada arco es el costo en $ de peaje en esa
ruta entre las dos ciudades.
Una empresa quiere poner un centro de distribucion en una ciudad de la provincia desde el cual se hará un envio una vez por mes a cada una del resto de las
ciudades, el camion saldra del centro de distribucion con destino a una ciudad, y volverá al centro de distribución, hara esto una vez al mes por cada ciudad.
Se buscara que el costo total de los peajes a pagar sea el menor posible.
Escriba un algoritmo en JAVA dado que el grafo mencionado, devuelva que ciudad es la que debe seleccionarse para construir el centro de distribucion.
El algoritmo deberá tener complejidad computacional menor o igual a O(n^3)
*/

public Integer buscarCiudad(Grafo g) {
    Iterator<Integer> verticesIt = g.obtenerVertices();
    int ciudadOptima = -1; // valor nulo
    int menorCostoTotal = -1; // valor nulo

    while (verticesIt.hasNext()) {
        Integer i = verticesIt.next();
        // Suponemos que devuelve el array de distancias desde i
        int[] distancias = g.dijkstra(i);
        int costoTotal = 0;

        Iterator<Integer> vertices = g.obtenerVertices();
        while (vertices.hasNext()) {
            Integer j = vertices.next();
            if (i != j) {
                costoTotal += 2 * distancias[j]; // Ida y vuelta
            }
        }

        if (costoTotal < menorCostoTotal || menorCostoTotal == -1) {
            menorCostoTotal = costoTotal;
            ciudadOptima = i;
        }
    }

    return ciudadOptima;
}