package ia.minimax.faseuno;

/**
 * Implementación del juego Nim con 2 pilas.
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
