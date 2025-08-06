/*
Dado un conjunto C de letras (que tiene más de 4 elementos), se desean generar todas las palabras válidas que
contengan exactamente 4 letras sin repetir y no empiecen con una letra vocal. Se supone que contamos con una
clase Diccionario que nos permite verificar si una secuencia de letras es una palabra válida
<Diccionario.esPalabraValida(string)>.
Por ejemplo, con C={E, R, N, O, M, A, T} se debería generar una solución compuesta por {MANO, MONA, REMO,
MORA, RAMO, ROEN, TOMA, ROTA, etc… }
a) Dibuje el árbol de exploración del algoritmo, indicando qué decisiones se toman en cada paso y qué
información se lleva en los estados.
b) Escriba un algoritmo en pseudo-java que resuelva el problema mediante la técnica de Backtracking.
c) ¿Se podría plantear alguna poda que minimice la cantidad de estados generados por el Backtracking?

a) En cada paso se seleccionara una letra de la lista de caracteres. En los estados se lleva la informacion de las
letras seleccionadas.
 */

Diccionario diccionario;

    public String buscarPalabras(List<Char> letras, int size) {
        List<Char> seleccion;
        List<String> conjunto;
        backtracking(letras, seleccion, conjunto, size);
        return conjunto;
    }

    private void backtracking(List<Char> letras, String seleccion, List<String> conjunto, int size) {
        if (size == 0) {
            if (diccionario.esPlabraValida(seleccion)) {
                if (!conjunto.contains(seleccion)) {
                    conjunto.add(seleccion);
                }
            } else {
                return;
            }
        } else {
            for (Char c : letras) {
                if (selecion.size() != 0 || seleccion.size() == 0 && !esVocal(c))) {
                    if (!seleccion.contains(c)) {
                        seleccion.addLetra(c);
                        if (esPrefijoValido(s))) {
                            backtracking(letras, seleccion, conjunto, size-1);
                        }
                        seleccion.removeLast();
                    }
                }
            }
        }
    }
