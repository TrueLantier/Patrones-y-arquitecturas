package ia.minimax.faseuno;

/**
 * =====================================================================
 *  NIM CON DOS PILAS
 * =====================================================================
 *
 *  Reglas:
 *    - Hay dos pilas de fichas, con a y b fichas.
 *    - En cada turno se elige UNA sola pila no vacía y se quita de ella
 *      cualquier cantidad positiva de fichas (1, 2, ..., o todas).
 *    - No se pueden tocar las dos pilas en el mismo turno.
 *    - Quien no puede mover pierde (juego normal, no misère).
 *      Equivalente: gana quien hace el último movimiento.
 *
 *  Modelo con la interfaz GameState:
 *    - Estado:      (a, b, isMax), con a >= 0, b >= 0.
 *    - Movimientos: para k = 1..a:  (a-k, b, !isMax)
 *                   para k = 1..b:  (a, b-k, !isMax)
 *    - Terminal:    a == 0 && b == 0.
 *    - utility():   SOLO válida en terminal.
 *                   Si (0,0), el que mueve pierde:
 *                     isMax == true  -> MAX pierde -> -1
 *                     isMax == false -> MIN pierde -> +1
 *                   ->  return isMax ? -1 : +1;
 *
 *  Posiciones perdedoras para el jugador que mueve:
 *    (0,0), (1,1), (2,2), (3,3), ...   (pilas iguales)
 *  Posiciones ganadoras:
 *    (a,b) con a != b.  Movimiento ganador: igualar las pilas
 *    quitando de la pila mayor hasta dejar (min(a,b), min(a,b)).
 *
 *  Valores esperados con Minimax:
 *    NimState(1, 2, true) -> +1   (MAX quita 1 de la 2ª pila -> (1,1))
 *    NimState(2, 2, true) -> -1   (pilas iguales: pierde quien mueve)
 *    NimState(0, 3, true) -> +1   (MAX quita 3 y deja (0,0))
 *
 *  Ojo: el estado es (pilas, turno). El árbol NO es lineal como en
 *  sustracción: hay ramificación y conviene usar solveWithPruning.
 * =====================================================================
 */

import java.util.ArrayList;
import java.util.List;

public class NimState implements GameState {
    private int a, b;
    private boolean isMax;
    public static String respuestaUno = "1"; // (1, 2, true)
    public static String respuestaDos = "-1"; // (2, 1, true)
    public static String respuestaTres = "-1"; // (2, 2, true)
    public static String respuestaCuatro = "1"; // (7, 11, true)

    public NimState(int a, int b, boolean isMax) {
        if (a < 0 || b < 0) throw new IllegalArgumentException("a,b >= 0");
        this.a = a;
        this.b = b;
        this.isMax = isMax;
    }

    @Override public boolean isTerminal() { return a == 0 && b == 0; }

    @Override public int utility() {
        if (!isTerminal()) throw new IllegalStateException("utility() solo en terminal");
        return isMax ? -1 : +1;
    }

    @Override public boolean isMaxTurn() { return isMax; }

    @Override public List<NimState> getSuccessors() {
        List<NimState> children = new ArrayList<>();

        for (int i = 1; i <= a; i++) {
            children.add(new NimState(a - i, b, !isMax));
        }
        for (int j = 1; j <= b; j++) {
            children.add(new NimState(a, b - j, !isMax));
        }

        return children;
    }

    @Override public String toString() {
        return "Nim(" + a + "," + b + "," + (isMax ? "MAX" : "MIN") + ")";
    }
}
