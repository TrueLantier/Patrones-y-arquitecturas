package ia.minimax.faseuno;

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
        return new TicTacToeState(b);
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

    private boolean hasWinner(char símbolo) {
        // filas
        for (int r = 0; r < 3; r++)
            if (board[r*3] == símbolo && board[r*3+1] == símbolo && board[r*3+2] == símbolo)
                return true;

        // columnas
        for (int c = 0; c < 3; c++)
            if (board[c] == símbolo && board[3+c] == símbolo && board[6+c] == símbolo)
                return true;

        // diagonales
        if (board[0] == símbolo && board[4] == símbolo && board[8] == símbolo) return true;
        if (board[2] == símbolo && board[4] == símbolo && board[6] == símbolo) return true;

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
