/*
Se tiene un árbol ternario como el de la imagen para llevar el registro de los resultados de una competencia por
equipos.
El nodo raíz contendrá el conjunto de los 10 equipos que participan de la competencia, mientras que cada nodo del árbol
sólo contendrá los equipos que dconsiguieron los resultados sabiendo que el nodo izquierdo representa una derrota, el
nodo central un empate y el nodo derecho una victoria.
Cada nivel del árbol representa una fecha de competencia de los equipos.
Implementar un algoritmo en Java que permita obtener los equipos, sin repetidos, que consiguieron al menos 2 victorias
cuando se jugaron 4 fechas de competencia.
Nota: Puede asumir la existencia de la clase TreeNode: public class TreeNode {
}
private List<Equipo> equipos; private TreeNode left, center, right;
 */

public List<Equipo> victoriasHastaFecha(TreeNode raiz, int fecha) {
    HashMap<Equipo, Integer> equiposVic = new HashMap<>();
    List<Equipo> sol = new ArrayList<>();
    buscar(raiz, fecha, equiposVic, false);
    for (Equipo e : equiposVic.keySey()) {
        if (equiposVic.get(e) >= 2) {
            sol.add(e);
        }
    }
    return sol;
}

public void buscar(TreeNode actual, int fecha, HashMap<Equipo, Integer> equiposVic, boolean fueVictoria) {
    if (nodo == null || fechaRestante == 0) {
        return;
    }

    // Si llegamos por la rama de victoria, sumamos a los equipos actuales
    if (fueVictoria) {
        for (Equipo e : nodo.getEquipos()) {
            victorias.put(e, victorias.getOrDefault(e, 0) + 1);
        }
    }

    // Bajamos a los 3 hijos, indicando de qué rama venimos
    buscar(nodo.getLeft(), fecha - 1, victorias, false);  // derrota
    buscar(nodo.getCenter(), fecha - 1, victorias, false); // empate
    buscar(nodo.getRight(), fecha - 1, victorias, true);   // victoria

}