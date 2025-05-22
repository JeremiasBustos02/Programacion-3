package ProgramacionIII.TP5_Backtracking.Ejercicio03;

import java.util.ArrayList;
import java.util.List;

/* Ejercicio 3

Suma de subconjuntos. Dados n números positivos distintos, se desea encontrar todas las
combinaciones de esos números tal que la suma sea igual a M. */

public class SumaSubconjuntos {
    private List<List<Integer>> soluciones;
    private int M;

    public List<List<Integer>> backtracking(List<Integer> conjunto) {
        soluciones = new ArrayList<>();
        ArrayList<Integer> aux = new ArrayList<>();
        backtracking(conjunto, 0, 0, aux);
        return soluciones;
    }

    private void backtracking (List<Integer> conjunto, int actual, int suma, List<Integer> aux) {
        // Si suma es igual a M, lo agrega a soluciones
        if (suma == M) {
            soluciones.add(new ArrayList<>(conjunto));
            return;
        } else {
            // Para cada elemento de conjunto a partir del actual
            for (int i = actual; i < conjunto.size(); i++) {
                aux.add(conjunto.get(i));
                // Poda, si la suma es mayor, no nos sirve y hacemos backtrack
                if (suma + conjunto.get(i) <= M) {
                    // Si no, seguimos sumando
                    backtracking(conjunto, actual, suma + conjunto.get(i), aux);
                }
                // Removemos el ultimo
                aux.remove(aux.size() - 1);
            }
        }
    }
}
