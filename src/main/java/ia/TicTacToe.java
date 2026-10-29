package ia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {

    static final char MAX_PLAYER = 'X';   // IA (jugador fijo, MAX)
    static final char MIN_PLAYER = 'O';   // humano (MIN)
    static final char EMPTY      = ' ';

    // Las 8 líneas ganadoras
    static final int[][] WIN_LINES = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},   // filas
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},   // columnas
            {0, 4, 8}, {2, 4, 6}               // diagonales
    };

    // ---------------------------------------------------------
    //  Utilidades del juego
    // ---------------------------------------------------------
    static char[] newBoard() {
        char[] b = new char[9];
        Arrays.fill(b, EMPTY);
        return b;
    }

    static List<Integer> availableMoves(char[] board) {
        List<Integer> moves = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            if (board[i] == EMPTY) moves.add(i);
        }
        return moves;
    }

    /** Devuelve 'X', 'O' o EMPTY si aún no hay ganador. */
    static char winner(char[] board) {
        for (int[] line : WIN_LINES) {
            char a = board[line[0]];
            char b = board[line[1]];
            char c = board[line[2]];
            if (a != EMPTY && a == b && b == c) return a;
        }
        return EMPTY;
    }

    static boolean isTerminal(char[] board) {
        return winner(board) != EMPTY || availableMoves(board).isEmpty();
    }

    /**
     * Función de utilidad SOLO para estados terminales,
     * evaluada desde el punto de vista de MAX:
     *   +1 → gana MAX ('X')
     *   -1 → gana MIN ('O')
     *    0 → empate
     */
    static int utility(char[] board) {
        char w = winner(board);
        if (w == MAX_PLAYER) return  1;
        if (w == MIN_PLAYER) return -1;
        return 0;
    }

    // ---------------------------------------------------------
    //  Resultado del minimax: (valor, jugada)
    // ---------------------------------------------------------
    static class Result {
        final int value;
        final Integer move;   // null si el nodo es terminal
        Result(int value, Integer move) {
            this.value = value;
            this.move  = move;
        }
    }

    // ---------------------------------------------------------
    //  MINIMAX  (sin profundidad máxima, sin heurística)
    // ---------------------------------------------------------
    static Result minimax(char[] board, boolean isMaxTurn) {
        // Caso base: estado terminal → utilidad pura
        if (isTerminal(board)) {
            return new Result(utility(board), null);
        }

        if (isMaxTurn) {
            int bestValue = Integer.MIN_VALUE;
            Integer bestMove = null;
            for (int move : availableMoves(board)) {
                board[move] = MAX_PLAYER;
                int value = minimax(board, false).value;   // turno del rival
                board[move] = EMPTY;                        // deshacer
                if (value > bestValue) {
                    bestValue = value;
                    bestMove  = move;
                }
            }
            return new Result(bestValue, bestMove);
        } else {
            int bestValue = Integer.MAX_VALUE;
            Integer bestMove = null;
            for (int move : availableMoves(board)) {
                board[move] = MIN_PLAYER;
                int value = minimax(board, true).value;     // turno del rival
                board[move] = EMPTY;                        // deshacer
                if (value < bestValue) {
                    bestValue = value;
                    bestMove  = move;
                }
            }
            return new Result(bestValue, bestMove);
        }
    }

    // ---------------------------------------------------------
    //  Impresión del tablero
    // ---------------------------------------------------------
    static void printBoard(char[] board) {
        System.out.println();
        for (int r = 0; r < 3; r++) {
            System.out.println("  " + board[r*3] + " | "
                    + board[r*3+1] + " | "
                    + board[r*3+2]);
            if (r < 2) System.out.println(" ---+---+---");
        }
        System.out.println();
    }

    static void printBoardWithIndices(char[] board) {
        System.out.println();
        for (int r = 0; r < 3; r++) {
            StringBuilder sb = new StringBuilder("  ");
            for (int c = 0; c < 3; c++) {
                int i = r * 3 + c;
                sb.append(board[i] == EMPTY ? String.valueOf(i)
                        : String.valueOf(board[i]));
                if (c < 2) sb.append(" | ");
            }
            System.out.println(sb);
            if (r < 2) System.out.println(" ---+---+---");
        }
        System.out.println();
    }

    // ---------------------------------------------------------
    //  Bucle de juego
    // ---------------------------------------------------------
    static void play() {
        char[] board = newBoard();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== 3 EN RAYA ===");
        System.out.println("MAX = 'X' (IA)  |  MIN = 'O' (tú)");
        System.out.println("Índices de casillas:");
        printBoardWithIndices(board);

        boolean turnMax = true;   // X (MAX) siempre empieza

        while (!isTerminal(board)) {
            if (turnMax) {
                Result r = minimax(board, true);
                board[r.move] = MAX_PLAYER;
                System.out.printf("MAX (IA) juega en la casilla %d  [valor minimax = %d]%n",
                        r.move, r.value);
            } else {
                int move = -1;
                List<Integer> avail = availableMoves(board);
                while (!avail.contains(move)) {
                    System.out.print("Tu turno (0-8): ");
                    String line = sc.nextLine().trim();
                    try {
                        move = Integer.parseInt(line);
                    } catch (NumberFormatException e) {
                        move = -1;
                    }
                    if (!avail.contains(move)) {
                        System.out.println("Casilla inválida, inténtalo de nuevo.");
                    }
                }
                board[move] = MIN_PLAYER;
            }
            printBoard(board);
            turnMax = !turnMax;
        }

        char w = winner(board);
        if      (w == MAX_PLAYER) System.out.println(">>> Gana MAX ('X')");
        else if (w == MIN_PLAYER) System.out.println(">>> Gana MIN ('O')");
        else                      System.out.println(">>> Empate");

        sc.close();
    }

    public static void main(String[] args) {
        play();
    }
}
