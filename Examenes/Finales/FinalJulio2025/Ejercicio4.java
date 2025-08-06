/*
Se tiene un conjunto de prendeas de vestir sucias que deben lavarse. Cada prende de vestir tiene un peso asociado (el
peso de la prenda) y un color de prenda: blanca, negra o de color (rojo, amarillo, etc.). Por ejemplo, se puede tener un
jean negro de 500 gramos, una remera blanca de 200 gramos, etc. Disponemos de un único lavarropas, que tiene una
capacidad de carga máxima K por lavado (por ejemplo 6kg).

Se desea dividir el conjunto de prendas en tandas de lavado de manera que se minimice la cantidad de puestas en
funcionamiento del lavarropas, siempre asegurándonos que:
- En ninguna tanda sobrepasamos la capacidad máxima de carga K del lavarropas.
- En ningún momento se mezclen prendas blancas con prendas negras (la ropa de color si se puede juntar con
cualquiera de las otras dos).

a) La estrategia greedy que voy a seguir es dividir la ropa en 3 grupos (blanco, negro y color), luego mezclo la ropa de color en esos dos grupos equitativamente para luego calcular las tandas de cada grupo. Las prendas estarán ordenadas por mayor peso y se va a ir agregando mientras que no supere el peso, cuando no entra más, iniciar una nueva tanda.
b)*/
public int cuantasTandas(List<Prenda> prendas, int maxKG) {
    // Dividir en tres grupos
    List<Prenda> blancas = new ArrayList<>();
    List<Prenda> negras = new ArrayList<>();
    List<Prenda> color = new ArrayList<>();

    for (Prenda p : prendas) {
        switch (p.getColor()) {
            case "blanco": blancas.add(p); break;
            case "negro": negras.add(p); break;
            default: color.add(p); break;
        }
    }

    // Decidir a qué grupo agregar cada prenda de color
    asignarColoresAGrupo(blancas, negras, color, maxKG);


    // Calcular tandas por grupo
    int tandasBlanco = contarTandas(blancas, maxKG);
    int tandasNegro = contarTandas(negras, maxKG);

    return tandasBlanco + tandasNegro;
}

private int contarTandas(List<Prenda> grupo, maxKG) {

    prendas.ordenarPorMayorPeso();
    int tandas = 0;

    while(!prendas.isEmpty()) {
        int peso = 0;
        Iterator<Prenda> it = grupo.iterator();

        while (it.hasNext()) {
            Prenda p = it.next();
            if (pesoActual + p.getPeso() <= maxKG) {
                pesoActual += p.getPeso();
                it.remove();  // evitar ConcurrentModificationException
            }
            tandas++;
        }
        return tandas;
    }
