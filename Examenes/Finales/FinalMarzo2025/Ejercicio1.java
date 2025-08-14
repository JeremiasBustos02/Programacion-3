/*
a) La estrategia greedy que voy a usar es ordenar el conjunto de personas de mayor a menor (respecto a su fuerza), y
inicializar los 4 subconjuntos, para luego ir agregandole mas personjas a dicho subconjunto para minimizar la
diferencia de fuerza.

b)
public List<List<Persona>> buscarMenorDiferencia(List<Persona> personas, int max) {
    // Se ordenan las personas por mayor fuerza
    ordenarPorMayorFuerza(personas);
    List<List<Persona>> solucion = new ArrayList<>();

    for (int i = 0; i < max; i++) {
        List<Persona> aux = new ArrayList<>();
        Persona p = personas.get(i);
        aux.add(p);
        solucion.add(aux);
    }

    for (int i = max-1; i < personas.size(); i++) {
        Persona p = personas.get(i);
        for (int j = 1; j < solucion.size(); j++) {
            List<Persona> subconjunto = solucion.get(j);
            // Suponemos que cantFuerza devuelve la fuerza total de ese subconjunto
            if (cantFuerza(subconjunto) + p.getFuerza < cantFuerza(solucion.get(j-1))) {
                solucion.get(i).add(p);
            }
        }
    }

    return solucion;


}
*/