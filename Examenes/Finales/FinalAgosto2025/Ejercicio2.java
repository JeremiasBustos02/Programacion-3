/*
Ejercicio 2
Responda:
a) Se requiere una estructura de hashing abierto con M=100 con un rho de diseño bajo, y función de hashing
h(x)=x mod M, se sabe también que las claves que se guardarán son todas múltiplos de 10. En este contexto,
recomendaría utilizar la implementación de HashTable o de HashMap de JAVA. Justifique su respuesta.

b) ¿Cuál es la complejidad temporal en notación big-O del algoritmo backtracking para el Problema de la Suma
de Subconjuntos (PSS) visto en clases? Justifique su respuesta.

a- Solo se usaran posiciones 0, 10, 20, 30 ... 90, lo que da solo 10 posiciones ocupadas de 100 posibles. Esto reduce
la dispersion, generando colisiones muy bajas.

Hashtable → útil si necesitas acceso seguro desde varios hilos simultáneamente.
HashMap → generalmente preferible si no hay concurrencia, incluso con muchas colisiones.

No menciona concurrencia ni multihilo, ni acceso simultáneo a la tabla, entonces no necesitamos sincronización, y
usar Hashtable sería innecesario y más lento. Por lo cual es mejor usar HashMap en este caso.

*/