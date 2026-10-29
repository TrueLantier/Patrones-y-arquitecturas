package ia.minimax.juegos;

/**
 * =====================================================================
 *  JUEGO DE SUSTRACCIÓN (UNA PILA)
 * =====================================================================
 *
 *  Reglas:
 *    - Hay N fichas en una sola pila.
 *    - En cada turno se quitan 1 o 2 fichas (nunca 0, nunca más de 2).
 *    - Quien no puede mover pierde (juego normal, no misère).
 *      Equivalente: gana quien hace el último movimiento.
 *
 *  Modelo con la interfaz GameState:
 *    - Estado:      (n, isMax), con n = fichas restantes, n >= 0.
 *    - Movimientos: n-1 y (si n >= 2) n-2.
 *    - Terminal:    n == 0  (el jugador que debe mover no puede).
 *    - utility():   SOLO válida en terminal.
 *                   Si n == 0, el que mueve pierde:
 *                     isMax == true  -> MAX pierde -> -1
 *                     isMax == false -> MIN pierde -> +1
 *                   ->  return isMax ? -1 : +1;
 *
 *  Posiciones perdedoras para el jugador que mueve:
 *    n = 0, 3, 6, 9, ...   (múltiplos de 3)
 *  Posiciones ganadoras:
 *    cualquier otro n.
 *
 *  Valores esperados con Minimax:
 *    SubtractionState(3, true) -> -1   (MAX pierde si MIN juega bien)
 *    SubtractionState(4, true) -> +1
 *    SubtractionState(6, true) -> -1
 *
 *  Estrategia (por si quieres comprobar a mano):
 *    deja siempre al rival un múltiplo de 3.
 * =====================================================================
 */

import ia.minimax.interfaz.GameState;

import java.util.ArrayList;
import java.util.List;

public class SubtractionState implements GameState {
    private int n;
    private boolean isMax;
    public static String respuestaUno = "-1"; // (3, true)
    public static String respuestaDos = "1"; // (3 false)
    public static String respuestaTres = "1"; // (4, true)
    public static String respuestaCuatro = "-1"; // (10, true)

    public SubtractionState(int n, boolean isMax) {
        if (n < 0) throw new IllegalArgumentException("n >= 0");
        this.n = n;
        this.isMax = isMax;
    }

    @Override public boolean isTerminal() { return n == 0; }

    @Override public int utility() {
        if (!isTerminal()) throw new IllegalStateException("utility() solo en terminal");
        // n == 0 --> quien debe mover pierde.
        return isMax ? -1 : +1;   // si le tocaba a MAX, MAX perdió.
    }

    @Override public boolean isMaxTurn() { return isMax; }

    @Override public List<SubtractionState> getSuccessors() {
        List<SubtractionState> children = new ArrayList<>();
        if (n >= 1) {
            children.add(new SubtractionState(n - 1, !isMax));
        }
        if (n >= 2) {
            children.add(new SubtractionState(n - 2, !isMax));
        }
        return children;
    }

    @Override public String toString() {
        return "Sub(" + n + "," + (isMax ? "MAX" : "MIN") + ")";
    }
}
