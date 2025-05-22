package ProgramacionIII.TP5_Backtracking.Ejercicio01;

import java.util.*;

public class Backtracking<T> {
    private GrafoDirigido<T> grafo;
    private List<Integer> caminoMasLargo;
    private int maxNodosVisitados;

    public Backtracking(GrafoDirigido<T> grafo) {
        this.grafo = grafo;
        this.caminoMasLargo = new ArrayList<>();
        this.maxNodosVisitados = 0;
    }

    public List<Integer> backtracking(int entrada, int salida) {
        List<Integer> caminoActual = new ArrayList<>();
        Set<Integer> visitados = new HashSet<>();
        backtracking(entrada, salida, caminoActual, visitados);
        return caminoMasLargo;
    }

    private void backtracking(int actual, int salida, List<Integer> caminoActual, Set<Integer> visitados) {
        caminoActual.add(actual);
        visitados.add(actual);

        if (actual == salida) {
            if (caminoActual.size() > maxNodosVisitados) {
                maxNodosVisitados = caminoActual.size();
                caminoMasLargo = new ArrayList<>(caminoActual);
            }
        } else {
            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(actual);
            while (adyacentes.hasNext()) {
                Integer adyacente = adyacentes.next();
                if (!visitados.contains(adyacente)) {
                    backtracking(adyacente, salida, caminoActual, visitados);
                }
            }
        }

        // backtrack, sacamos la sala actual para poder visitar otros caminos
        visitados.remove(actual);
        caminoActual.remove(caminoActual.size() - 1);
    }
}
