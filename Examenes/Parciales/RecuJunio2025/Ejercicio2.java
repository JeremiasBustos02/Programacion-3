/*
Debido a un mal funcionamiento de una de las máquinas que generan piezas, la empresa se encuentra con la
situación de tener que enviar a un depósito la cantidad de piezas sobrantes. Los empleados han ubicado dichas piezas
en un número X de cajas, cada una con su propio peso.

Se sabe que el transporte contratado puede llevar un peso total P en cada viaje. Se desea encontrar el orden en que
deben ser cargadas las cajas en el transporte de manera de minimizar el total de viajes a realizar.

a) Explique claramente cuál sería la estrategia greedy que seguiría.
b) Escriba un algoritmo en JAVA que lo resuelva mediante la estrategia greedy.
c) Diga y justifique cuál será la complejidad computacional del algoritmo en notación Big-O.

a) La estrategia greedy que voy a utilizar sera ordenar las cajas de mayor a menor peso, e ir poniéndolas en el transporte de
manera que pueda cumplir con la condición (peso total <= P) con la mayor cantidad de cajas posibles. Los candidatos
serán las cajas ordenadas por peso de mayor a menor.


 */

public void cargarTransporte(int pesoMaximo, List<Caja> cajas) {
    // Ordenamos las cajas de mayor a menor peso
	cajas.ordenarPorPeso();

	int viajes = 0;

	while (!cajas.isEmpty()) {
		int pesoTotal = 0;
		List<Caja> usadas = new ArrayList<>();

		for (Caja c : cajas) {
			if ((pesoTotal + c.peso()) <= pesoMaximo) {
				pesoTotal += c.peso();
				usadas.add(c);
			}
		}
		cajas.removeAll(usadas);
		viajes++;
	}

	System.out.println("Se hicieron " + viajes + " viajes.");
}

/*
c- Ordenamiento inicial: cajas.sort(...) -> O(n logn n)
Loop principal (while): En el peor caso se hace 1 iteración por caja -> O(n)
En cada viaje, se puede recorrer todas las cajas restantes, entonces tenemos en total -> O(n^2)

Por lo cual queda: O(n log n + n^2) = O(n^2)
 */

