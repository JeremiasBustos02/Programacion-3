package ProgramacionIII.TP5_Backtracking.Ejercicio02;

/* Ejercicio 2
Dado un laberinto consistente en una matriz cuadrada que tiene en cada posición un valor natural y
cuatro valores booleanos, indicando estos últimos si desde esa casilla se puede ir al norte, este, sur
y oeste, encontrar un camino de longitud mínima entre dos casillas dadas, siendo la longitud de un
camino la suma de los valores naturales de las casillas por las que pasa. Idea: podría representarse
el laberinto como una matriz, de objetos, donde cada objeto tiene el valor natural, y cuatro
booleanos, uno para cada dirección a la que se permite ir desde allí. */

import java.util.ArrayList;

public class Laberinto {
    private Casillero destino;
    private Camino mejorCamino;

    public Camino backtracking(Casillero origen) {
        Camino caminoActual = new Camino();
        caminoActual.agregarAlCamino(origen);
        caminoActual.marcarVisitado(origen);
        caminoActual.incrementar(origen.getValor());

        backtracing(origen, caminoActual);
        return mejorCamino;
    }

    private void backtracing(Casillero casilleroActual, Camino caminoActual) {
        // Si llegue a destino y el valor de camino actual es menor, reemplazo.
        if (casilleroActual.equals(destino)) {
             if (mejorCamino == null || caminoActual.getValor() < mejorCamino.getValor()) {
                 mejorCamino = caminoActual;
             }
         } else {
            // Pedimos los adyacentes/vecinos del casillero actual
            // Esto nos permite saber para donde podemos movernos
             ArrayList<Casillero> adyacentes = casilleroActual.getVecinos();
             for (Casillero casillero : adyacentes) {
                 if (!caminoActual.estaVisitado(casillero)) {
                     // Si no esta visitado, agrego, marco como visitado y modifico el valor del camino.
                     caminoActual.marcarVisitado(casillero);
                     caminoActual.agregarAlCamino(casillero);
                     caminoActual.incrementar(casillero.getValor());

                     // Poda, si el valor de caminoActual es menor, sigue, si no vuelve al anterior
                     if (mejorCamino == null ||  caminoActual.getValor() <= mejorCamino.getValor()) {
                         backtracing(casillero, caminoActual);
                     }

                     // Backtrack
                     caminoActual.quitarUltimo();
                     caminoActual.decrementar(casillero.getValor());
                     caminoActual.quitarVisitado(casillero);
                 }
             }
         }
    }
}
