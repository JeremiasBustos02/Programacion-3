/* Ejercicio 4

Dado un conjunto de productos N donde cada producto tiene un peso Pi y un valor económico Vi, y una mochila con capacidad máxima
de K kilos. Se desea encontrar el subconjunto de productos a ubicar en la mochila que maximice el valor económico total, sin superar
los K kilos disponibles. Se sabe que los productos no pueden ser fraccionados, es decir, si se elige poner el producto X en
la mochila deberá hacerse en su totalidad.

a) Dibuje el árbol de exploración del algoritmo, indicando qué decisiones se toman en cada paso y qué información se lleva en los estados.

b) Escriba el pseudo java del algoritmo que resuelva el problema mediante Backtracking.

a) En cada paso del arbol se elegira un producto, si un subconjunto es mejor (tiene mayor valor economico que el mejor
encontrado hasta ese momento) se reemplazara por ese mismo. Asi hasta que recorra todas las opciones disponibles.
 */

List<Producto> mejorSolucion;
    public List<Producto> buscarSubconjunto(List<Producto> productos, int maxKg) {
        List<Producto> solucion = new ArrayList<>();
        mejorSolucion = new ArrayList<>();
        backtracking(productos, maxKg, solucion, 0, 0);
        return mejorSolucion;
    }

    private void backtracking(List<Producto> productos, int maxKg, List<Producto> solucion, int index, int pesoActual) {
        if (index == (productos.size()-1)) {
            if (valorEconomico(solucion) > valorEconomico(mejorSolucion)) {
                mejorSolucion = new ArrayList<>(solucion);
            }
        }
        Producto p = productos.get(index);
        // Tomar el producto
        if (pesoActual+p.getPeso() <= maxKg) {
            solucion.add(p);
            backtracking(productos, maxKg, solucion, index+1, pesoActual);
            solucion.remove(p);
        }
        // No usarlo
        backtracking(productos, maxKg, solucion, index+1, pesoActual + p.getPeso());
    }

    private int valorEconomico(List<Producto> productos) {
        int valor = 0;
        for (Producto p : productos) {
            valor += p.getValor();
        }
        return valor;
    }
