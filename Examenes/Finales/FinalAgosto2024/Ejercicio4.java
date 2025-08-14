/*
a)i) el numero pd significa la densidad de almacenamiento, es la proporcion de espacio utilizado respecto del espacio
total del almacenamiento asignado.

a)ii) Numeros chicos significa que la mayoría de los slots están libres, lo que reduce colisiones y los numeros grandes
significan listas encadenadas muy largas en hashing cerrado y tablas llenas en hashing cerrado.

b) Utilizaria un arbol binario balanceado, ordenado por el numero de libreta. Esto ya me asegura el ordenamiento
(in-order), recorrer todos los alumnos costara O(n) que es bastante optimo. La insercion y eliminacion costara O(nlogn),
la busqueda O(logn).

*/