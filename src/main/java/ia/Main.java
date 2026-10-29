package ia;

import ia.minimax.arboles.Trees;
import ia.minimax.juegos.Minimax;
import ia.minimax.arboles.Node;
import ia.minimax.juegos.TicTacToeState;

// PEDIR REGLAS DE JUEGOS Y EL ÁRBOL 2

public class Main {
    static void main(String[] args) {
        Node[] trees = {Trees.treeUno(), Trees.treeDos(), Trees.treeTres(),
                Trees.treeCuatro(), Trees.treeNegativo()};
        String[] treesResultados = {Trees.resultadoUno, Trees.resultadoDos, Trees.resultadoTres,
                Trees.resultadoCuatro, Trees.resultadoNegativo};

        // Estado inicial: con juego óptimo, TicTacToe es tablas.
        System.out.println(Minimax.solve(new TicTacToeState()));        // 0

        // Tres en raya para X ya en el tablero: gana MAX.
        System.out.println(Minimax.solve(
                TicTacToeState.fromString("XXX/OO./...")));                 // +1

        // Tres en raya para O: gana MIN.
        System.out.println(Minimax.solve(
                TicTacToeState.fromString("OOO/XX./X..")));                 // -1

        // Tablero lleno sin ganador: empate.
        System.out.println(Minimax.solve(
                TicTacToeState.fromString("XOX/OOX/XXO")));                 // 0

        // No terminal, pero MAX tiene jugada ganadora inmediata (fila superior).
        System.out.println(Minimax.solve(
                TicTacToeState.fromString("XX./.O./..O")));                 // +1
    }
}

        // Comprobar cTree = new Comprobar(trees[i], treesResultados[i], true); // Para los árboles

        /*
          ** Clase NimState **
          * Al jugador que le toque y las pilas tengan la misma cantidad pierde.
          Comprobar cNim1 = new Comprobar(new NimState(1, 2, true), NimState.respuestaUno, false);
          Comprobar cNim2 = new Comprobar(new NimState(1, 2, false), NimState.respuestaDos, false);
          Comprobar cNim3 = new Comprobar(new NimState(2, 2, true), NimState.respuestaTres, false);
          Comprobar cNim4 = new Comprobar(new NimState(7, 11, true), NimState.respuestaCuatro, false);
          Para valores mayores ya se demora el minimax puro debido a que calcula el árbol de juego.
          Probar con (7, 13).
         */

        /*
          ** Clase SubtractionState **
          * Al jugador que le toque y quede un N múltiplo de 3 pierde.
           Comprobar cS1 = new Comprobar(new SubtractionState(3, true),
                SubtractionState.respuestaUno,  false);
           Comprobar cS2 = new Comprobar(new SubtractionState(3, false),
                SubtractionState.respuestaDos,  false);
           Comprobar cS3 = new Comprobar(new SubtractionState(4, true),
                SubtractionState.respuestaTres,  false);
           Comprobar cS4 = new Comprobar(new SubtractionState(10, false),
                SubtractionState.respuestaCuatro,  false);
         */

        /*
          ** Clase TwentyOneState **
          * Empezar con 0 es perder para quien mueve.
          Comprobar cTOS1 = new Comprobar(new TwentyOneState(0, true),
                TwentyOneState.respuestaUno, false);
          Comprobar cTOS2 = new Comprobar(new TwentyOneState(4, true),
                TwentyOneState.respuestaDos, false);
          Comprobar cTOS3 = new Comprobar(new TwentyOneState(7, true), // Le toca a MAX y dice 1.
                TwentyOneState.respuestaTres, false);
          Comprobar cTOS4 = new Comprobar(new TwentyOneState(17, false),
                TwentyOneState.respuestaCuatro, false);
         */
