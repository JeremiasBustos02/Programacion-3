/*
Dada la tabla de hashing de la derecha, que se comporta como el HashTable de JAVA, y se encuentra cargada de manera que
se muestra. Si M=6 y p_d = 1.2.

a) Indique como quedará la tabla luego de cada una de las siguientes inserciones de claves: 13, 3 y 38.

b) Responda y justifique: Si se tiene una estructura de hashing abierto separado, con M=15 y como funcion de hashing se
elige la funcion h(x)=10. ¿Qué impacto tendra esto en la estructura y en la operacion de busqueda?.

a- Se tendra que recalcular ya que al añadir el tercer elemento estamos encima del limite (7.2 = [6 * 1 * 1.2]), por lo
recalculamos M y agregamos todos los elementos.

M = 6 * 2 + 1 -> 13
L = 13 * 1 * 1.2 -> 15.6

Calculamos las nuevas posiciones de los elementos.

h(12) = 12 mod 13 = 12
h(24) = 24 mod 13 = 11
h(19) = 19 mod 13 = 6
h(2) = 2 mod 13 = 2
h(11) = 11 mod 13 = 11
h(13) = 13 mod 13 = 0
h(3) = 3 mod 13 = 3
h(38) = 38 mod 13 = 12

b- Si usamos h(x) = 10 como función de hash para cualquier x, entonces todos los elementos se insertan en la
posición 10. Eso rompe completamente la distribución uniforme de una función de hashing.


 */