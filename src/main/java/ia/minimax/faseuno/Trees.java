package ia.minimax.faseuno;

/**
 * En esta clase se ponen árboles de prueba. Son cortos y se pueden hacer a mano.
 * La idea es probar que el algoritmo funciona con ellos primero ya que son los casos más sencillos.
 */

public class Trees {

    public static String resultadoUno = "Árbol 1, resultado esperado: 3";
    public static String resultadoDos = "Árbol 2, resultado esperado: 6";
    public static String resultadoTres = "Árbol 3, resultado esperado: 3";
    public static String resultadoCuatro = "Árbol 4, resultado esperado: 7";
    public static String resultadoNegativo = "Árbol Negativo, resultado esperado: -2";

    /**
     * Ejemplo clásico de Minimax:
     * Raíz MAX, nivel 2 MIN, hojas con valores.
     *
     *                A (MAX)
     *        /         |         \
     *     B (MIN)     C (MIN)     D (MIN)
     *     / | \      / | \      / | \
     *    3 12 8     2  4 6     14 5 2
     *
     * Resultado esperado: 3
     */
    public static Node treeUno() {
        Node root = new Node("A", true);

        Node b = new Node("B", false);
        b.add(new Node("B1", 3))
                .add(new Node("B2", 12))
                .add(new Node("B3", 8));

        Node c = new Node("C", false);
        c.add(new Node("C1", 2))
                .add(new Node("C2", 4))
                .add(new Node("C3", 6));

        Node d = new Node("D", false);
        d.add(new Node("D1", 14))
                .add(new Node("D2", 5))
                .add(new Node("D3", 2));

        root.add(b).add(c).add(d);
        return root;
    }

    /**
     * Árbol simple de dos niveles.
     *
     * FALTA DIBUJO
     *
     * Resultado esperado: 6
     */
    public static Node treeDos() {
        Node root = new Node("R", true);

        Node a = new Node("A", false);
        a.add(new Node("A1", 6))
                .add(new Node("A2", 7));

        Node b = new Node("B", false);
        b.add(new Node("B1", 2))
                .add(new Node("B2", 9));

        root.add(a).add(b);
        return root;
    }

    /**
     * Árbol del enunciado:
     *
     *            A (MAX)
     *          /         \
     *       B (MIN)     C (MIN)
     *       /   \       /   \
     *      3     5     2     8
     *
     * Minimax esperado: 3
     */
    public static Node treeTres() {
        Node root = new Node("A", true);

        Node b = new Node("B", false);
        b.add(new Node("B1", 3))
                .add(new Node("B2", 5));

        Node c = new Node("C", false);
        c.add(new Node("C1", 2))
                .add(new Node("C2", 8));

        root.add(b).add(c);
        return root;
    }

    /**
     * Árbol de 4 niveles (MAX → MIN → MAX → hojas).
     *
     *                    Root (MAX)
     *                  /            \
     *              A (MIN)         B (MIN)
     *             /      \        /      \
     *         A1(MAX)  A2(MAX) B1(MAX) B2(MAX)
     *          / \      / \      / \      / \
     *         4   7    1   9    2   2    6   0
     *
     * Minimax esperado: 7
     */
    public static Node treeCuatro() {
        Node root = new Node("Root", true);

        // --- Rama A (MIN) ---
        Node a = new Node("A", false);

        Node a1 = new Node("A1", true);
        a1.add(new Node("A1a", 4))
                .add(new Node("A1b", 7));

        Node a2 = new Node("A2", true);
        a2.add(new Node("A2a", 1))
                .add(new Node("A2b", 9));

        a.add(a1).add(a2);

        // --- Rama B (MIN) ---
        Node b = new Node("B", false);

        Node b1 = new Node("B1", true);
        b1.add(new Node("B1a", 2))
                .add(new Node("B1b", 2));

        Node b2 = new Node("B2", true);
        b2.add(new Node("B2a", 6))
                .add(new Node("B2b", 0));

        b.add(b1).add(b2);

        root.add(a).add(b);
        return root;
    }

    /**
     * Árbol con valores negativos — detecta acumuladores mal inicializados.
     *
     *              Root (MAX)
     *             /          \
     *          X (MIN)      Y (MIN)
     *           /  \         /  \
     *         -1   -3      -2   -2
     *
     * Minimax esperado: -2
     */
    public static Node treeNegativo() {
        Node root = new Node("Root", true);

        Node x = new Node("X", false);
        x.add(new Node("X1", -1))
                .add(new Node("X2", -3));

        Node y = new Node("Y", false);
        y.add(new Node("Y1", -2))
                .add(new Node("Y2", -2));

        root.add(x).add(y);
        return root;
    }
}
