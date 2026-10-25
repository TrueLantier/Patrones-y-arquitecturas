package ia.minimax.faseuno;

import java.util.List;

/**
 * Contrato que Minimax necesita de cualquier juego.
 * NO contiene lógica de ningún juego concreto.
 *
 * Convención: mayor valor = mejor para MAX.
 * MAX intenta maximizar; MIN intenta minimizar.
 */
public interface GameState {

    /** ¿Es un estado final? En los árboles de prueba = hoja sin hijos. */
    boolean isTerminal();

    /**
     * Utilidad del estado. SOLO válida si isTerminal() == true.
     * Si se llama en un estado no terminal, la implementación puede lanzar
     * excepción (en Node lo hacemos, para detectar bugs al construir árboles).
     */
    int utility();

    /** ¿Le toca jugar a MAX en este estado? */
    boolean isMaxTurn();

    /**
     * Sucesores (hijos). En árboles preconstruidos devuelve la lista ya
     * existente; en Nim / TicTacToe se generan al vuelo a partir del estado.
     *
     * Usamos el comodín ? extends GameState para que cada implementación
     * pueda devolver su propio tipo (List<Node>, List<NimState>, etc.).
     */
    List<? extends GameState> getSuccessors();
}
