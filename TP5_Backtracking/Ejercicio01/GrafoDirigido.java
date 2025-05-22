package ProgramacionIII.TP5_Backtracking.Ejercicio01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class GrafoDirigido<T> implements Grafo<T> {
	//Vertices + lista de ADYACENTES
	private HashMap<Integer, LinkedList<Arco<T>>> vertices;

	@Override
	public void agregarVertice(int verticeId) {
		if (!vertices.containsKey(verticeId)) {
			vertices.put(verticeId, new LinkedList<Arco<T>>());
		} else {
			System.out.println("El vertice " + verticeId + " ya existe");
		}
	}

	@Override
	public void borrarVertice(int verticeId) {
		if (!vertices.containsKey(verticeId)) {
			System.out.println("El vertice " + verticeId + " no existe");
		} else {
			// Se recorre todo el grafo viendo la lista adyacente de cada vertice
			// para remover de la lista
			for (Integer vecino : vertices.keySet()) {
				LinkedList<Arco<T>> arcos = vertices.get(vecino);
				arcos.removeIf(arco -> arco.getVerticeDestino() == verticeId );
			}
		}
		vertices.remove(verticeId);
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		if (!vertices.containsKey(verticeId1)) {
			System.out.println("El grafo no tiene el vertice " + verticeId1);
		} else if (!vertices.containsKey(verticeId2)) {
			System.out.println("El grafo no tiene el vertice " + verticeId2);
		} else {
			vertices.get(verticeId1).add(new Arco<T>(verticeId1, verticeId2, etiqueta));
		}
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		if (!vertices.containsKey(verticeId1)) {
			System.out.println("El grafo no tiene el vertice " + verticeId1);
		} else if (!vertices.containsKey(verticeId2)) {
			System.out.println("El grafo no tiene el vertice " + verticeId2);
		} else {
			LinkedList<Arco<T>> arcos = vertices.get(verticeId1);
			arcos.removeIf(arco -> arco.getVerticeDestino() == verticeId2);
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		return vertices.containsKey(verticeId);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		if (!vertices.containsKey(verticeId1)) {
			System.out.println("El grafo no tiene el vertice " + verticeId1);
		} else if (!vertices.containsKey(verticeId2)) {
			System.out.println("El grafo no tiene el vertice " + verticeId2);
		} else {
			LinkedList<Arco<T>> arcos = vertices.get(verticeId1);
			for (Arco<T> arco : arcos) {
				if (arco.getVerticeDestino() == verticeId2) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		if (!vertices.containsKey(verticeId1)) {
			return null;
		} else if (!vertices.containsKey(verticeId2)) {
			return null;
		} else {
			LinkedList<Arco<T>> arcos = vertices.get(verticeId1);
			for (Arco<T> arco : arcos) {
				if (arco.getVerticeDestino() == verticeId2) {
					return arco;
				}
			}
		}
		return null;
	}

	@Override
	public int cantidadVertices() {
		return vertices.size();
	}

	@Override
	public int cantidadArcos() {
		int cantArcos = 0;
		for (LinkedList<Arco<T>> arcos : vertices.values()) {
			cantArcos += arcos.size();
		}
		return cantArcos;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		return vertices.keySet().iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		if (!vertices.containsKey(verticeId)) {
			return null;
		}
		LinkedList<Integer> adyacentes = new LinkedList<Integer>();
		for (Arco<T> arco : vertices.get(verticeId)) {
			adyacentes.add(arco.getVerticeDestino());
		}
		return adyacentes.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		LinkedList<Arco<T>> arcos = new LinkedList<Arco<T>>();
        for (LinkedList<Arco<T>> listaAdyacencia : vertices.values()) {
            arcos.addAll(listaAdyacencia);
        }
        return arcos.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        if (!vertices.containsKey(verticeId)) {
            return null;
        }
		return vertices.get(verticeId).iterator();
	}

}
