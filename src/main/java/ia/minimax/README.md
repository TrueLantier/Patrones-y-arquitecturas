# Minimax: IA para juegos de dos jugadores

Implementación del algoritmo **Minimax** en Java, diseñado para funcionar con cualquier juego por turnos de dos jugadores, de suma cero e informacion perfecta. Proyecto de la asignatura de Inteligencia Artificial, desarrollado en equipo.

---

## Idea central

El algoritmo no sabe nada de ningún juego en concreto. Solo conoce la interfaz `GameState`, que abstrae lo que necesita para razonar:

- Quién juega ahora.
- Qué movimientos son legales.
- Qué estado resulta de aplicar un movimiento.
- Si la partida termino y qué valor tiene ese resultado.

Gracias a esto, agregar un juego nuevo es **implementar la interfaz**, sin tocar una línea de `Minimax`.

```
            +------------------+
            |     Minimax      |
            +--------+---------+
                     | recibe referencias a
                     v
            +------------------+
            | <<interface>>    |
            |   GameState      |
            +--------+---------+
                     ^ implementan
     +-------+-------+--------+-----------+
     |       |                |           |
    Nim  Sustracción      Juego del 21  TicTacToe
```

---

## Juegos incluidos

| Juego | Descripción breve |
|---|---|
| **Nim** | Varios montones de objetos; en cada turno se retiran objetos de un solo montón. |
| **Juego de sustracción** | Un monton único; cada turno se restan entre 1 y *k* objetos. |
| **Juego del 21** | Se suma un valor por turno hasta alcanzar o evitar el 21, según la variante. |
| **Tic-Tac-Toe** | Tres en raya clásico sobre un tablero de 3x3. |

> Completa las reglas exactas (quien gana al tomar el último objeto, rango de movimientos, etc.) según cómo las implementaste.

---

## La interfaz `GameState`

Contrato que debe cumplir cada juego. Ejemplo ilustrativo (adapta a tus firmas reales):

```java
public interface GameState {
    boolean isTerminal();             // la partida ha terminado?
    int utility();                   // valor del estado terminal
    boolean isMaxTurn();              // le toca al jugador maximizador?
    List<? extends GameState> getSuccessors();     // estados alcanzables en un movimiento
}
```

---

## El algoritmo

`Minimax` recibe una referencia a un `GameState` y explora recursivamente el árbol de juego:

- En los turnos de **MAX** elige el hijo con mayor valor.
- En los turnos de **MIN** elige el hijo con menor valor.
- En los estados terminales devuelve la evaluación (utilidad) del juego.

Como solo depende de `GameState` (polimorfismo), el mismo código resuelve los cuatro juegos.

---

## Pruebas: árboles verificables a mano

Antes de aplicar el algoritmo a juegos reales, se construyeron **árboles pequeños** cuyo valor minimax se 
puede calcular a mano. Esto permite:

1. Validar que la logica MAX/MIN era correcta de forma aislada.
2. Detectar errores sin la complejidad de las reglas de un juego.
3. Tener casos de referencia con resultado conocido.

Solo después de pasar estas pruebas se probó el algoritmo con Nim, sustracción, 21 y Tic-Tac-Toe.

---

## Como agregar un juego nuevo

1. Crea una clase que implemente `GameState`.
2. Define el estado inicial, los movimientos legales y la condicion de fin.
3. Implementa la evaluacion del estado terminal.
4. Pasala a `Minimax` sin modificar nada mas.

---

## Limitaciones y posibles mejoras

- Minimax explora el árbol completo: en juegos grandes el costo es exponencial.
- **Poda alfa-beta** para reducir drásticamente los nodos visitados. (Se implementa en Tic-Tac-Toe)
- **Límite de profundidad + función heurística** para juegos que no se pueden resolver por completo.
- **Memoización** de estados repetidos (muy util en Nim y sustracción).

---
