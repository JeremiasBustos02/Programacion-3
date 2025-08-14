/*
a) La estrategia greedy que voy a seguir va a ser elegir la mejor llave para cada iteracion del for de llaves, es decir,
eligo la llave que mas cerraduras abra en ese momento, ya que si solo ordeno al principio y utilizo esa lista ordenada
no me va a servir para cuando se vayan abriendo las cerraduras ya que es posible que distintas llaves abran la misma
cerradura.

b)
public List<Llave> minimoLlaves(List<Llave> llaves, List<Cerradura> cerraduras) {
    List<Llave> llavesUsadas = new ArrayList<>();
    List<Llave> cerradurasAbiertas = new ArrayList<>();

    while (!cerraduras.isEmpty()) {
        cerradurasAbiertas.clear();
        Llave mejorLlave = null;
        int maxCobertura = 0;

        for (Llave l : llaves) {
            int cobertura = 0;
            for (Cerradura c : cerraduras) {
                if (abre(l, c)) {
                    cobertura++;
                }
            }
            if (cobertura > maxCobertura) {
                mejorLlave = l;
                maxCobertura = cobertura;
            }
        }

        if (mejorLlave == null) {
            throw new RuntimeException("No se pueden abrir todas las cerraduras");
        }

        for (Cerradura c : cerraduras) {
            if (abre(mejorLlave, c)) {
                ceradurasAbiertas.add(c);
            }
        }

        llavesUsadas.add(mejorLlave);
        llaves.remove(mejorLlave);
        cerraduras.removeAll(cerradurasAbiertas);
    }

    return llavesUsadas;
}

*/