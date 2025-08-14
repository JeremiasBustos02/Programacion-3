/*
a) En cada paso se tomara la decision de poner una nota en la secuencia hasta llegar, cada nota solo se puede repetir
dos veces. Se llegara a un estado final cuando se cumpla los requisitos del tamaño y cada nota elegida solo este 2
o menos veces.

b)
List<Nota> mejorSecuencia
public List<Nota> buscarSecuencia(List<Nota> notas, Integer H) {
    List<Nota> secuencia = new ArrayList<>();
    mejorSecuencia = null;
    backtracking(notas, h, secuencia);
    return mejorSecuencia;
}

private void backtracking(List<Nota> notas, List<Nota> secuencia, Integer H) {
    if (secuencia.size() == H) {
        if (valoracion(secuencia) > valoracion(mejorSecuencia) || mejorSecuencia == null) {
            mejorSecuencia = new ArrayList<>(secuencia);
        }
        return;
    }

    for (int i = 0; i < notas.size(); i++) {
        Nota nota = notas.get(i);
        if (secuencia.isEmpty() || !nota.equals(secuencia.get(secuencia.size() - 1))) {
            secuencia.add(nota);
            backtracking(notas, secuencia, H);
            secuencia.remove(nota);
        }
    }
}
*/