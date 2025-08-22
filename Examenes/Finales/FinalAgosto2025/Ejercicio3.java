/*
Ejercicio 3
Se quiere organizar la distribución de invitados a las mesas en una fiesta de casamiento.
Hay N invitados, y M mesas de k lugares cada mesa. (siendo M*k >= N).
Se dispone de una función de afinidad que dada una lista de entre 1 y k invitados que se sentarán a una mesa, devuelve
un valor entero positivo de afinidad entre esas personas, a mayor valor devuelva, mayor afinidad entre ellas:
public int calcularAfinidad(List<Invitado> grupо)

Escriba un algoritmo en JAVA mediante la técnica Backtracking que tenga la siguiente especificación:

public Asignacion asignarMesas(List<Invitado> invitados, int M, int k)

Debe retornar la asignación de invitados a las mesas que maximice el valor total de afinidad.
Ud. decida y explique la especificación de la clase Asignación.
Pueden quedar mesas vacías (tendrán afinidad cero) o incompletas, pero todos los invitados deben tener una mesa
asignada.

El algoritmo debe contar con función de poda.

a) Dibuje el árbol de exploración del algoritmo, indicando qué decisiones se toman en cada paso y qué
información se lleva en los estados.
b) Escriba en JAVA un algoritmo de backtracking que lo resuelva.
c) Explique la poda implementada

a) En cada paso se le asignara una mesa a un invitado, siempre que tenga un espacio. En cada estado se llevara la lista
de mesas con los grupos actuales, y la afinidad acumulada hasta el momento.

Árbol de decisiones (esquema):

Eje horizontal: mesas (Cantidad de mesas)
Eje vertical: personas (Cantidad de invitados)

Nivel 0 (raíz):
    [Mesas: [], []] (afinidad=0)

Nivel 1 (invitado 1):

    [ [p1], [] ] (p1 en mesa 1)

    [ [], [p1] ] (p1 en mesa 2)

Nivel 2 (invitado 2):
    Desde [ [p1], [] ]:

        [ [p1,p2], [] ] (p2 en mesa 1)

        [ [p1], [p2] ] (p2 en mesa 2)

    Desde [ [], [p1] ]:

        [ [p2], [p1] ]

        [ [], [p1,p2] ]

b)
private Asignacion mejorAsignacion;

public Asignacion asignarMesas(List<Invitado> invitados, int M, int K) {
    // Promedio de afinidad que nos ayuda a calcular la estimacion
    promedioAfinidad(invitados);
    Asignacion solucion = new Asignacion();
    backtracking(invitados, 0, solucion, M, K, promedio);
    return solucion;
}

public void backtracking(List<Invitado> invitados, int index, Asignacion solucion, int M, int K, int promedio) {
    if (index == invitados.size()) {
        if (mejorSolucion == null || actual.getAfinidadTotal() > mejorSolucion.getAfinidadTotal()) {
            clonarSolucion(mejorSolucion, solucion);
        }
        return;
    }

    // Poda 1: chequear espacios disponibles
    int invitadosRestantes = invitados.size() - index;
    int lugaresDisponibles = 0;
    for (List<Invitado> mesa : actual.getMesas()) {
        lugaresDisponibles += (k - mesa.size());
    }
    if (lugaresDisponibles < invitadosRestantes) {
        return; // no hay lugar para todos
    }


    // Agarramos el invitado
    Invitado invitado = invitados.get(index);
    // Para cada mesa, probamos un lugar
    for (int i = 0; i < M; i++) {
        if (solucion.getMesas().get(i).size() < k) {
            solucion.getMesas().get(i).add(invitado);
            int afinidadTotalActual = solucion.getAfinidadTotal();

            // Hacemos una estimacion global del potencial
            int invitadosRestantes = invitados.size() - (index + 1);
            int estimacionPotencial = afinidadTotalActual + (invitadosRestantes * promedio);

            if (estimacionPotencial > afinidadMejor.getAfinidadTotal()) {
                backtrack(invitados, index+1, solucion, M, K, promedio);
            }

            // backtrack
            solucion.getMesas().get(i).remove(solucion.getMesas().get(i).size()-1);
        }
    }
}
*/