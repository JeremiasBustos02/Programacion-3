/* Ejercicio 3

Dado un juego de dominó compuesto de 28 fichas se desea encontrar una secuencia circular de fichas
que utilice la totalidad de las fichas y respete las restricciones de ubicacion de 2 fichas consecutivas
que coincidan en el número. */

/* a) En cada paso del arbol se va a elegir una ficha, la informacion que se va a llevar en cada paso es el conjunto solucion de las fichas (solo pide una).
Nivel 0: (ficha 1)
Nivel 1: (ficha 1, ficha 5), (ficha 1, ficha 2) -> no es compatible y poda
nivel 2: (ficha 1, ficha 5, ficha 2)

/* b) */
public List<Ficha> buscarSecuencia(List<Ficha> fichas) {

    for (Ficha fichaInicial : fichas) {
        List<Ficha> solucion = new ArrayList<>();
        ArrayList<Ficha> f = new ArrayList<>(fichas);

        // Probar ficha normal
        solucion.add(fichaInicial);
        f.remove(fichaInicial);
        if (buscar(f, solucion)) {
            return new ArrayList<>(solucion);
        }


        // Probar ficha girada
        Ficha girada = fichaInicial.girar();
        solucion.clear();
        solucion.add(girada);
        f = new ArrayList<>(fichas);
        f.remove(fichaInicial);
        if (buscar(f, solucion)) {
            return new ArrayList<>(solucion);
        }
    }

    return new ArrayList<>();
}

public boolean buscar(ArrayList<Ficha> f, List<Ficha> solucion) {
    if (f.isEmpty()) {
        return esCompatible(solucion.get(0), solucion.get(size()-1));

    }

    for (int i = 0; i < f.size(); i++) {
        Ficha ficha = f.get(i);
        if (esCompatible(ficha, solucion.get(solucion.size()-1))) {
            solucion.add(ficha);
            f.remove(ficha);
            if (buscar(f, solucion)) {
                return true;
            }
            solucion.remove(ficha); //backtrack
        } else {
            ficha.girar();
            if (esCompatible(ficha, solucion.get(solucion.size()-1))) {
                solucion.add(ficha);
                f.remove(ficha);
                if (buscar(f, solucion)) {
                    return true;
                }
                solucion.remove(ficha); //backtrack
            }
        }
    }

    return false;
}