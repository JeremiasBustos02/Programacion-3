/*
a) La estrategia greedy que voy a seguir sera tenes dos listas, una lista con las cajas ordenadas por su peso de menor
a mayor, y otra ordenada por su resistencia de mayor a menor. La primer caja de cada fila sera elegida de la lista de
resistencia, y luego ire apilando de la lista de peso.

public Integer calcularColumnas(List<Caja> cajas) {
    List<Caja> ordenadasPeso = new ArrayList<>(cajas.ordenarPorPeso());
    List<Caja> ordenadasResistencia = new ArrayList<>(cajas.ordenarPorResistencia());
    Integer columnas = 0;
    while(!cajas.isEmpty()) {
        List<Caja> usadas = new ArrayList<>();
        Caja cajaBase = ordenadasResistencia.get(0);
        int peso = 0
        usadas.add(cajaBase);
        for (Caja c : ordenadasPeso) {
            if (peso + c.getPeso() <= cajaBase.getResistencia()) {
                usadas.add(c);
            }
        }
        cajas.removeAll(usadas);
        ordenadasResistencia.remove(cajaBase);
        ordenadasPeso.removeAll(usadas);
        columnas++;
    }
    return columnas;
}
*/