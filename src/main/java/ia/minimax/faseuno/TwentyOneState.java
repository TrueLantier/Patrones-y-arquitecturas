package ia.minimax.faseuno;

/**
 * Implementación del juego del 21.
 */

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
