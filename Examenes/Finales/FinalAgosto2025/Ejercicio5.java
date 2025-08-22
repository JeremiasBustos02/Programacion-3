/*
Ejercicio 5
La cátedra de Programación 3 ha podido automatizar la corrección de los trabajos prácticos de cursada. Para eso, se ha
programado una tarea (que llamaremos AdministradorEntregas) que recibe cada trabajo que es envíado a la casilla de
email, lo formatea y lo ubica en una carpeta compartida. Por otro lado, se ha programado una tarea Corrector  que toma
los trabajos de la carpeta compartida, los corrige y los copia a otra carpeta "corregidos".
Si se desea poder contar con más de una tarea Corrector corriendo en paralelo, para agilizar la corrección de los
trabajos, Responda: ¿qué situaciones se deberían considerar?
Esquematice un pequeño pseudo-código para implementar ambas tareas y las consideraciones explicadas.

Situaciones a considerar:
1. Acceso seguro a la lista de trabajos pendientes::
    - Todos los Correctores comparten una estructura de datos (lista, cola, etc.) que contienen los trabajos pendients.
    - Se debe una sincronización para evitar que dos threads tomen el mismo trabajo al mismo tiempo.
2. Eficiencia en la asignación de trabajos:
    - Los threads deben esperar de manera controlada si no hay trabajos pendientes (ej, dormir unos segundos) para
      evitar usar CPU innecesariamente.
    - Cuando un nuevo trabajo llega, los threads deben poder despertar y procesarlo rapidamente.
3. Manejo de errores dentro de un thread:
    - Si un Corrector falla mientras corrige un trbaajo, ese trabajo deberia volver a la lista de pendientes para que
      otro Thread pueda tomarlo.
    - Esto evita perdidas de trabajos por fallos individuales.
4. Escalabilidad:
    - La solución debe permitir agregar o quitar Threads Corrector fácilmente sin romper la sincronización ni generar
      duplicación de trbaajo.

Pseudo-código:

# AdministradorEntregas
tarea AdministradorEntregas:
    mientras true:
        email = recibirEmail()
        trabajo = formatear(email)
        sincronizado(listaTrabajos):
            listaTrabajo.agregar(trabajo)
        esperar(segundos=10)

# Corrector
tarea Corrector:
    mientras true:
        trabajo = null
        sincronizado(listaTrabajos):
            si listaTrabajos.noVacia():
                trabajo = listaTrabajos.quitarPrimero()
            si trabajo != null:
                resultado = corregir(trabajo)
                moverACarpetaCorregidos(trabajo, resultado)
            sino:
                esperar(segundos=5)

main:
    # Lista compartida de trabajos pendientes
    listaTrabajos = []

    # Crear y arrancar el thread del Administrador de Entregas
    administrador = Thread(target=AdministradorEntregas, args=(listaTrabajos,))
    administrador.start()

    # Crear y arrancar múltiples threads Corrector
    numeroCorrectores = 3  # Numero de ejemplo
    correctores = []
    para i = 1 hasta numeroCorrectores:
        corrector = Thread(target=Corrector, args=(listaTrabajos,))
        corrector.start()
        correctores.agregar(corrector)

    # Esperar a que los threads terminen (en este caso, nunca terminan)
    administrador.join()
    para cada corrector en correctores:
        corrector.join()

*/