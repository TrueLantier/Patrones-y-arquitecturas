package ia.minimax.faseuno;

/**
 * Algoritmo Minimax (y su variante con poda alfa-beta).
 * Completamente independiente del juego: solo usa la interfaz GameState.
 */
public final class Minimax {

    private Minimax() {}   // clase de utilidades, no instanciable.

    /**
     * Minimax clásico (sin poda). Recorre TODO el árbol.
     * Devuelve el valor que MAX puede garantizarse si ambos juegan óptimamente.
     * Coste: O(b^d) con b = factor de ramificación, d = profundidad.
     */
    public static int solve(GameState state) {
        // Caso base: terminal --> devolvemos la utilidad tal cual.
        if (state.isTerminal()) {
            return state.utility();
        }

        // Caso recursivo: depende de quién mueve en ESTE nodo.
        if (state.isMaxTurn()) {
            int best = Integer.MIN_VALUE;          // ¡-∞, NO 0!
            for (GameState child : state.getSuccessors()) {
                best = Math.max(best, solve(child));
            }
            return best;
        } else {
            int best = Integer.MAX_VALUE;          // ¡+∞, NO 0!
            for (GameState child : state.getSuccessors()) {
                best = Math.min(best, solve(child));
            }
            return best;
        }
    }

    /**
     * Minimax con poda alfa-beta. Mismo resultado que solve(), pero
     * en el mejor caso explora muchas menos ramas.
     *
     * α = mejor valor ya garantizado para MAX (cota inferior).
     * β = mejor valor ya garantizado para MIN (cota superior).
     * Si β ≤ α, la rama actual no puede mejorar a ningún ancestro → se corta.
     */
    public static int solveWithPruning(GameState state) {
        return alphaBeta(state, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static int alphaBeta(GameState state, int alpha, int beta) {
        if (state.isTerminal()) {
            return state.utility();
        }

        if (state.isMaxTurn()) {
            int best = Integer.MIN_VALUE;
            for (GameState child : state.getSuccessors()) {
                best = Math.max(best, alphaBeta(child, alpha, beta));
                alpha = Math.max(alpha, best);      // MAX sube la cota inferior.
                if (beta <= alpha) break;           // poda β
            }
            return best;
        } else {
            int best = Integer.MAX_VALUE;
            for (GameState child : state.getSuccessors()) {
                best = Math.min(best, alphaBeta(child, alpha, beta));
                beta = Math.min(beta, best);        // MIN baja la cota superior.
                if (beta <= alpha) break;           // poda α
            }
            return best;
        }
    }
}