/*
a) En cada paso del arbol de exploracion se elegira un movimiento (un punto), de la cuadricula. Asi hasta llegar al
patron que desbloqueara el telefono.

public List<Punto> desbloquearTelefono(Cuadricula c) {
    List<Punto> sol = new ArrayList<>();
    List<Punto> puntos = c.obtenerPuntos(); // Suponemos que Cuadricula puede devolver una lista con sus puntos
    for (int index = 0; index < puntos.size(); index++) {
        int puntoActual = puntos.get(index);
        sol.add(puntoActual);
        backtracking(puntos, sol, puntoActual, 0);
        sol.remove(puntoActual); // backtrack
    }
}

public void backtracking (List<Punto> puntos, List<Punto> sol, Punto puntoActual, int index) {
    if (index = puntos.size() && !validarPatron(sol)) {
        sol = null;
        return;
    }

    for (int index = 0; index < puntos.size(); index++) {
        int puntoActual = puntos.get(index);
        if (!sol.contains(puntoActual)) {
            sol.add(puntoActual);
            if (validarPatron(sol)) {
                break;
            }
            backtracking(puntos, sol, puntoActual, index + 1);
            sol.remove(puntoActual); // backtrack
        }
    }

    return sol;
}
*/