# AmazonViewer

### Clase 18
El concepto que estamos aplicando al tener capas disponibles y otras no disponibles en mi proyecto es **encapsulamiento**. 
Cuanto menos encapsulamiento tiene una funcionalidad, mayor es su accesibilidad desde otras clases y métodos del proyecto.

### Clase 20
Es posible la herencia multiple entre interfaces. 😳

### Clase 21
El _Deque_ es como una Cola (Queue) pero doble, ya que se le pueden agregar y quitar elementos de ambos extremos. 
Imagínate poder posicionarte en el primer lugar de la fila del súper delante de un montón de gente, a parte de hacer lo típico de ir hacia detrás de toda la fila! 
</br>

Hay 4 métodos para **añadir** elementos a una Deque:
- addFirst
- offerFirst 
- addLast
- offerLast
</br>

Los que tienen un nombre que comienza con 'offer' son los que se recomiendan utilizar cuando la capacidad de nuestra Deque es limitada.
</br>

Hay 4 métodos para **quitar** elementos a una Deque:
- removeFirst
- pollFirst 
- removeLast
- pollLast
</br>

Los que tienen un nombre que comienza con 'poll' son los que devuelven null si la Deque está vacía, 
mientras que los que tienen un nombre que comienza con 'remove' arrojarían una Exception en ese caso.
</br>

Hay 4 métodos para **obtener** elementos de una Deque:
- getFirst
- peekFirst 
- getLast
- peekLast
</br>

Los que tienen un nombre que comienza con 'peek' son los que devuelven NULL si la Deque está vacía, 
mientras que los que tienen un nombre que comienza con 'get' arrojarían una Exception en ese caso.