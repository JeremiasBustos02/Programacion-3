/*
Ejercicio 4
Dado un grafo no dirigido G que representa las relaciones de amistad entre un conjunto de personas. Determine
mediante un algoritmo greedy la mínima lista de personas que cubran todo el grafo, o sea que cada persona del grafo
sea amiga al menos de una persona en la lista resultado.
a) Describir cuál sería la estrategia Greedy que seguiría,
b) Plantear el algoritmo en Java que lo resuelva mediante dicha estrategia Greedy.

a) La estrategia greedy que voy a seguir va a ser las personas por mayor amistad, es decir, la persona que mayor
amistad tenga estara primera, luego ire agregando esa persona a la solucion, y sacando las amistades de la lista
de personas, y asi ir agregando hasta que no tenga mas para elegir.

b)
public List<Persona> minimaListaPersonas(Grafo g) {
    List<Persona> personas = new ArrayList<>();
    List<Persona> solucion = new ArrayList<>();

    Iterator<Persona> personasIt = g.obtenerPersonas();
    while (personasIt.hasNext()) {
        Persona p = personasIt.next();
        personas.add(p)
    }
    List<Persona> pUsadas = new ArrayList<>();
    while (!personas.isEmpty()) {
        // Ordenamos las personas por cantidad de amigos
        personas.sort((p1, p2) -> g.obtenerAmigos(p2).size() - g.obtenerAmigos(p1).size());
        pUsados.clear();

        Persona seleccionado = personas.get(0);
        pUsados.add(seleccionado);

        Iterator<Persona> amigosIt = g.obtenerAmigos(seleccionado);
        while (amigosIt.hasNext()) {
            Persona p = amigosIt.next();
            pUsadas.add(p);
        }

        solucion.add(seleccionado);
        personas.removeAll(pUsadas);
    }

    return solucion;
}
*/