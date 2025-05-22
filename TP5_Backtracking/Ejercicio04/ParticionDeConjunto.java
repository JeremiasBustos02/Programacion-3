package ProgramacionIII.TP5_Backtracking.Ejercicio04;

/* Ejercicio 4

Partición de conjunto. Dado un conjunto de n enteros se desea encontrar, si existe, una partición en
dos subconjuntos disjuntos, tal que la suma de sus elementos sea la misma. */

import java.util.ArrayList;
import java.util.List;

public class ParticionDeConjunto {
    private List<List<Integer>> solucion;

    public List<List<Integer>> backtracking(List<Integer> conjunto) {
        solucion = new ArrayList<>();
        List<Integer> subconjunto1 = new ArrayList<>();
        List<Integer> subconjunto2 = new ArrayList<>();
        backtracking(0, 0, 0, conjunto, subconjunto1, subconjunto2);
        return solucion;
    }

    private void backtracking(int numActual, int sum1, int sum2, List<Integer> conjunto, List<Integer> subconjunto1, List<Integer> subconjunto2) {
        if (numActual == conjunto.size()) {
            if (sum1 == sum2 && !subconjunto1.isEmpty() && !subconjunto2.isEmpty()) {
                solucion.add(new ArrayList<>(subconjunto1));
                solucion.add(new ArrayList<>(subconjunto2));
            }
            return;
        } else {
            int num = conjunto.get(numActual);
            subconjunto1.add(num);
            backtracking(numActual+1, sum1+num, sum2, conjunto, subconjunto1, subconjunto2);
            subconjunto1.remove(subconjunto1.size()-1);

            subconjunto2.add(num);
            backtracking(numActual+1, sum1, sum2+2, conjunto, subconjunto1, subconjunto2);
            subconjunto2.remove(subconjunto2.size()-1);
        }
    }
}
