/*
Un mapa muestra un continente dividido en varias regiones. El mapa se representa como un grafo no dirigido, donde
cada nodo representa una región y cada arista indica que dos regiones son adyacentes (comparten frontera).

El objetivo es asignar colores a las regiones de to do el mapa de forma tal que ninguna región adyacente tenga el
mismo color y se utilice la mínima cantidad posible de colores.

Implementar en JAVA el método Colorear especificado a continuación, que mediante backtracking determine cuál es
el mínimo número de colores necesario y devuelva una asignación válida de colores para todas las regiones.

public HashMap<int, int> colorear(Grafo g) // El método devuelve para cada vértice, el color asignado

a) Dibuje el árbol de exploración del algoritmo indicando qué decisiones se toman en cada paso y qué
información se lleva en los estados.
b) Escriba un algoritmo en JAVA que resuelva el problema mediante la técnica de Backtracking.
c) Describa cuál sería la estrategia de poda.

a) Cada nodo del arbol representa una decision de color para un vertice y la información que lleva en cada paso es:

⦁	HashMap<vertice, color> que representa que color tiene cada vertice
⦁	Indice del vertice actual.
⦁	Cantidad de colores usados hasta el momento.

Arbol:
Nivel 0: (<,>, indice, cantColores)
Nivel 1: (<1,1>, 1, 1), (<1, 2>, 1, 1), ..., (<1, n>, 1, 1)
Nivel 2: (<2, 1>, 2, 1) -> si es adyacente se poda, (<2,2>, 2, 2), ....

 */

// Atributos de la clase
HashMap<int, int> mejorSolucion = new HashMap<>();
private int menorCantidad = 0;

    // Método principal que resuelve el problema de coloreo
    public HashMap<Integer, Integer> colorear(Grafo g) {
        // Preparamos una lista con todos los vértices del grafo
        HashMap<Integer, Integer> solucion = new HashMap<>();
        Iterator<Integer> verticesIt = g.obtenerVertices();
        List<Integer> vertices = new ArrayList<>();

        // Convertimos el iterador de vértices a una lista para acceso por índice
        while (verticesIt.hasNext()) {
            vertices.add(verticesIt.next());
        }

           // Probamos con diferentes límites de colores (desde 1 hasta el total de vértices)
          // Empezamos con 1 color e incrementamos hasta encontrar la solución mínima
        for (int c = 1; c <= vertices.size(); c++) {
            // Reiniciamos la mejor solución para cada intento con 'c' colores
            mejorSolucion = new HashMap<>();
            // Si encontramos solución con 'c' colores, terminamos la búsqueda
            if (colorearConLimite(g, vertices, new HashMap<>(), 0, c)) {
                break; // Salimos del bucle porque encontramos la solución óptima
            }
        }

        return mejorSolucion; // Devolvemos la mejor solución encontrada
    }

   // Método recursivo que implementa el backtracking para colorear con un límite de colores
   private boolean colorearConLimite(	Grafo g, List<Integer> vertices, HashMap<Integer, Integer> solucion, int index, int maxColores) {
       // Caso base: hemos procesado todos los vértices
       if (index == vertices.size()) {
           // Copiamos la solución actual como la mejor solución encontrada
           mejorSolucion = new HashMap<>(solucion);
           return true; // Indicamos que encontramos una solución válida
       }

       // Obtenemos el vértice actual a colorear
       Integer verticeActual = vertices.get(index);

       // Probamos todos los colores posibles desde 1 hasta maxColores
       for (int color = 1; color <= maxColores; color++) {
           // Verificamos si el color es válido para este vértice
           if (colorEsValido(g, color, verticeActual, solucion)) {
              solucion.put(verticeActual, color);

              // Llamada recursiva para el siguiente vértice
               if (colorearConLimite(g, vertices, solucion, index + 1, maxColores)) {
                   return true; // Propagamos el éxito si encontramos solución
               }

               // Backtrack: removemos la asignación para probar otra opción
              solucion.remove(verticeActual);
          }
       }

       // Si ningún color funcionó, retornamos false
       return false;
   }