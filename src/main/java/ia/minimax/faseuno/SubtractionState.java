package ia.minimax.faseuno;

/**
 * Implementación del juego de la sustracción.
 */

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
