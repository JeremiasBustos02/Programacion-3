/*
a) Dado el grafo G de la derecha se ejecuto el agoritmo de busqueda en profundidad DFS(G), el cual visitará
todos los vertices del grafo. Suponiendo que el primer vertice que selecciona el algoritmo es el 1.
Enumere, en el orden que va visitando el DFS: la lista de vertices que visita, la lista de arcos tree y la lista
de arcos back.

b) Dado el grafo G de la derecha, dar la vista de vertices en el orden que se visita en un recorrido en amplitud BFS(G)
del grafo suponiendo que el primer vertice que selecciona el algoritmo es el 9.


a)
Recorrido: [1,2,5,3,4,6,7,8,9,11,10]
Arcos Tree: [(1,2), (2,1), (1,3), (3,4), (3,6), (7,8), (7,9), (11, 10)]
Arcos Back: [(5,1), (9,7)]

b)
Recorrido: [9,7,8,1,2,3,5,4,6,11,10]
 */