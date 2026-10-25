package ia.minimax.faseuno;

public class Comprobar {
    public Comprobar(Node nodo, String resultado) {
        TreePrinter.print(nodo);
        Node root = nodo;               // esperado: 3
        System.out.println(resultado);
        System.out.println("  minimax   = " + Minimax.solve(nodo));
        System.out.println("  α-β       = " + Minimax.solveWithPruning(nodo));
    }
}
