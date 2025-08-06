/* a) Los estados son new thread (cuando se crea), runnable (cuando esta corriendo), not running (cuando esta durmiendo) y dead (cuando termino el proceso).
b) Una alternativa es hacer que la clase A implemente Runnable, es decir que use la interfaz Runnable.
c) verdadero. ya que al ser balanceado en el primer paso podemos descargar la mitad del arbol, y asi sucesivamente hasta llegar al lugar donde se insertara.
d) falso. por lo explicado en c). Además, la altura en un árbol balanceado es logarítmica respecto al número de nodos, no lineal. */