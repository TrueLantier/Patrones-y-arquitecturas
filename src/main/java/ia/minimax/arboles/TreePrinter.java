package ia.minimax.arboles;

/**
 * Esta clase es para mostrar los árboles de prueba pequeños, no los árboles de los juegos.
 */

public class TreePrinter {
    public static void print(Node node, String prefijo, boolean isLast) {
        System.out.println(prefijo + (isLast ? "└── " : "├── ") + node);
        String childPrefijo = prefijo + (isLast ? "    " : "│   ");
        for (int i = 0; i < node.children.size(); i++) {
            print(node.children.get(i), childPrefijo, i == node.children.size() - 1);
        }
    }

    public static void print(Node root) {
        System.out.println(root);
        for (int i = 0; i < root.children.size(); i++) {
            print(root.children.get(i), "", i == root.children.size() - 1);
        }
    }
}
