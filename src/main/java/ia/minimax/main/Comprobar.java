package ia.minimax.main;

import ia.minimax.arboles.TreePrinter;
import ia.minimax.interfaz.GameState;
import ia.minimax.juegos.Minimax;
import ia.minimax.arboles.Node;

public class Comprobar {
    public Comprobar(GameState game, String resultado, boolean isTree) {

        if (isTree) {
            TreePrinter.print((Node) game);
        }

        System.out.println(resultado);
        System.out.println("  minimax   = " + Minimax.solve(game));
        System.out.println("  α-β       = " + Minimax.solveWithPruning(game));
    }
}
