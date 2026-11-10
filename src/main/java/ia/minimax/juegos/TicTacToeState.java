package ia.minimax.juegos;

import ia.minimax.interfaz.GameState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicTacToeState implements GameState {

    public static final char EMPTY = '.';
    public static final char X = 'X';   // MAX
    public static final char O = 'O';   // MIN

    // Tablero: índice = fila*3 + columna
    private final char[] board;

    public TicTacToeState() {
        this.board = new char[9];
        Arrays.fill(this.board, EMPTY); // Todas las posiciones con '.'
    }

    private TicTacToeState(char[] board) {
        this.board = board; // Ya viene clonado por quien llama.
    }

    // Construye desde "XO./.O./..X" (acepta '.' o '-' como vacío).
    public static TicTacToeState fromString(String s) {
        String cleaned = s.replace("/", "").replace(" ",
                "").replace('-', '.');
        if (cleaned.length() != 9)
            throw new IllegalArgumentException("Se esperaban 9 celdas: " + s);
        char[] b = cleaned.toCharArray();
        for (char c : b) {
            if (c != EMPTY && c != X && c != O)
                throw new IllegalArgumentException("Símbolo no válido: " + c);
        }
        TicTacToeState state = new TicTacToeState(b);
        if (!state.isValid()) {
            throw new IllegalArgumentException(
                    "Estado ilegal (partida imposible): " + s);
        }
        return state;
    }

    // Método para comprobar si una partida es legal.
    public boolean isValid() {
        int xs = 0, os = 0;
        for (char c : board) {
            if (c == X) xs++;
            else if (c == O) os++;
        }

        // 1. Alternancia X empieza.
        if (xs != os && xs != os + 1) return false;

        boolean xWins = hasWinner(X);
        boolean oWins = hasWinner(O);

        // 2. No ambos ganadores.
        if (xWins && oWins) return false;

        // 3. Victoria de X: X movió último y su jugada creó la victoria.
        if (xWins) {
            if (xs != os + 1) return false;
            if (canBeLastMove(X)) return false;
        }

        // 4. Victoria de O: O movió último y su jugada creó la victoria.
        if (oWins) {
            if (xs != os) return false;
            if (canBeLastMove(O)) return false;
        }

        return true;
    }

    // Método de apoyo: ¿Si se retira el último símbolo, el jugador deja de tener una jugada ganadora?
    private boolean canBeLastMove(char symbol) {
        for (int i = 0; i < 9; i++) {
            if (board[i] == symbol) {
                char[] test = board.clone();
                test[i] = EMPTY;
                if (!hasWinner(test, symbol)) return false;
            }
        }
        return true;
    }

    // ---------- GameState ----------

    @Override
    public boolean isTerminal() {
        return hasWinner(X) || hasWinner(O) || isFull();
    }

    @Override
    public int utility() {
        if (!isTerminal())
            throw new IllegalStateException("utility() solo en terminal: " + this);
        if (hasWinner(X)) return +1;   // MAX ganó
        if (hasWinner(O)) return -1;   // MIN ganó
        return 0;                       // Tablero lleno sin ganador.
    }

    @Override
    public boolean isMaxTurn() {
        // X empieza y se alterna: mueve X cuando #X == #O.
        int xs = 0, os = 0;
        for (char c : board) {
            if (c == X) xs++;
            else if (c == O) os++;
        }
        return xs == os;
    }

    @Override
    public List<TicTacToeState> getSuccessors() {
        List<TicTacToeState> result = new ArrayList<>();
        if (isTerminal()) return result;            // Sin hijos en hoja.
        char symbol = isMaxTurn() ? X : O;
        for (int i = 0; i < 9; i++) {
            if (board[i] == EMPTY) {
                char[] next = board.clone();        // Clonar antes de mutar.
                next[i] = symbol;
                result.add(new TicTacToeState(next));
            }
        }
        return result;
    }

    // Para ayuda, y no hacer métodos que hacen demasiadas cosas.

    private boolean isFull() {
        for (char c : board) {
            if (c == EMPTY) return false;
        }
        return true;
    }

    private boolean hasWinner(char symbol) {
        return hasWinner(board, symbol);
    }

    private static boolean hasWinner(char[] b, char symbol) {
        for (int r = 0; r < 3; r++)
            if (b[r*3] == symbol && b[r*3+1] == symbol && b[r*3+2] == symbol)
                return true;
        for (int c = 0; c < 3; c++)
            if (b[c] == symbol && b[3+c] == symbol && b[6+c] == symbol)
                return true;
        if (b[0] == symbol && b[4] == symbol && b[8] == symbol) return true;
        if (b[2] == symbol && b[4] == symbol && b[6] == symbol) return true;
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < 3; r++) {
            if (r > 0) sb.append('/');
            sb.append(board[r*3]).append(board[r*3+1]).append(board[r*3+2]);
        }
        sb.append(" [").append(isMaxTurn() ? "MAX" : "MIN").append(']');
        return sb.toString();
    }
}
