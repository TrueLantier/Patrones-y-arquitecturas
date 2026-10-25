package ia.minimax.faseuno;

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
