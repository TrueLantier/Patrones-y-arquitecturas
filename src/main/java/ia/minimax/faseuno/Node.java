package ia.minimax.faseuno;

import java.util.ArrayList;
import java.util.List;

/**
 * Nodo genérico del árbol de prueba. Implementa GameState para que Minimax
 * pueda recorrerlo sin saber si es un árbol preconstruido o un juego real.
 */
public class Node implements GameState {

    private String name;              // etiqueta solo para depurar (A, X1...)
    private Integer value;            // null si es nodo interno
    private boolean isMax;            // true=MAX, false=MIN (irrelevante en hojas)
    public List<Node> children;

    public Node(String name, boolean isMax) {
        this.name = name;
        this.isMax = isMax;
        this.children = new ArrayList<>();
    }

    public Node(String name, int leafValue) {
        this.name = name;
        this.value = leafValue;
        this.isMax = false;
        this.children = new ArrayList<>();
    }

    public Node add(Node child) {
        this.children.add(child);
        return this;
    }

    // ---------- Implementación de GameState ----------

    @Override
    public boolean isTerminal() {
        return children.isEmpty();
    }

    @Override
    public int utility() {
        if (!isTerminal()) {
            throw new IllegalStateException(
                    "utility() solo es válido en hojas. Nodo: " + name);
        }
        return value;
    }

    @Override
    public boolean isMaxTurn() {
        return isMax;
    }

    @Override
    public List<Node> getSuccessors() {
        // List<Node> es subtipo de List<? extends GameState>
        return children;
    }

    @Override
    public String toString() {
        return isTerminal() ? name + " = " + value : name + (isMax ? " (MAX)" : " (MIN)");
    }
}