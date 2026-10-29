package ia.minimax.juegos;

/**
 * =====================================================================
 *  JUEGO DEL 21  (variante MISÈRE: quien dice 21 pierde)
 * =====================================================================
 *
 *  Reglas:
 *    - Se cuenta desde 0 hasta 21 en orden, sin saltarse números.
 *    - En cada turno el jugador dice 1, 2 o 3 números consecutivos.
 *      Ejemplo: si el último número dicho es 5, puede decir
 *        "6", "6,7" o "6,7,8".
 *    - No se puede pasar de 21: hay que decir el 21 exactamente.
 *    - QUIEN DICE 21 PIERDE.  (Esto es lo que lo hace misère;
 *      no es "quien no puede mover pierde" como en sustracción/Nim.)
 *
 *  Modelo con la interfaz GameState:
 *    - Estado:      (last, isMax), con last = último número dicho,
 *                   last en [0, 21].  Estado inicial: (0, true).
 *    - Movimientos: para k = 1, 2, 3 con last + k <= 21:
 *                   (last + k, !isMax).
 *    - Terminal:    last == 21.
 *                   En ese estado YA perdió el jugador que dijo 21,
 *                   es decir, el jugador ANTERIOR. Por tanto gana
 *                   el que tiene el turno en el terminal.
 *    - utility():   SOLO válida en terminal.
 *                   Si last == 21, gana el que mueve ahora:
 *                     isMax == true  -> MAX gana -> +1
 *                     isMax == false -> MIN gana -> -1
 *                   ->  return isMax ? +1 : -1;
 *                   ¡OJO con el signo!  Es al revés que en
 *                   sustracción y Nim, porque aquí el terminal
 *                   significa "el OTRO perdió", no "yo no puedo mover".
 *
 *  Posiciones perdedoras para el jugador que mueve:
 *    last = 0, 4, 8, 12, 16, 20    (múltiplos de 4 desde 0 hasta 20)
 *  Posiciones ganadoras:
 *    cualquier otro last en [0, 19].
 *    En last = 20 no hay jugada segura: estás forzado a decir 21.
 *
 *  Valores esperados con Minimax:
 *    TwentyOneState(0,  true) -> -1   (empezar en 0 es perdedor)
 *    TwentyOneState(16, true) -> -1   (posición perdedora)
 *    TwentyOneState(18, true) -> +1   (MAX dice "19,20" y deja 20 a MIN)
 *    TwentyOneState(20, true) -> -1   (obligado a decir 21 y pierde)
 *
 *  Estrategia (por si quieres comprobar a mano):
 *    responde completando múltiplos de 4: si el rival deja en m,
 *    di hasta llegar a m' = siguiente múltiplo de 4 (4, 8, 12, 16, 20).
 * =====================================================================
 */

import ia.minimax.interfaz.GameState;

import java.util.ArrayList;
import java.util.List;

public class TwentyOneState implements GameState {
    private static final int META = 21;
    private int last;          // 0..21
    private boolean isMax;
    public static String respuestaUno = "-1"; // (0, true)
    public static String respuestaDos = "-1"; // (4, true)
    public static String respuestaTres = "1"; // (7, true)
    public static String respuestaCuatro = "-1"; // (17, false)

    // last representa el último número dicho al llegar al turno actual.
    public TwentyOneState(int last, boolean isMax) {
        if (last < 0 || last > META) throw new IllegalArgumentException("last ∈ [0,21]");
        this.last = last;
        this.isMax = isMax;
    }

    @Override public boolean isTerminal() { return last == META; }

    @Override public int utility() {
        if (!isTerminal()) throw new IllegalStateException("utility() solo en terminal");
        // Alguien dijo 21 y perdió. Gana el que tiene el turno ahora.
        // Si es turno de MAX --> MIN dijo 21 → MAX gana --> +1
        // Si es turno de MIN --> MAX dijo 21 → MIN gana --> -1
        return isMax ? +1 : -1;
    }

    @Override public boolean isMaxTurn() { return isMax; }

    @Override public List<TwentyOneState> getSuccessors() {
        List<TwentyOneState> children = new ArrayList<>();
        if (isTerminal()) return children;
        for (int i = 1; i <= 3; i++) {
            int next = last + i;
            if (next <= META) children.add(new TwentyOneState(next, !isMax));
        }
        return children;
    }

    @Override public String toString() {
        return "T21(" + last + "," + (isMax ? "MAX" : "MIN") + ")";
    }
}
