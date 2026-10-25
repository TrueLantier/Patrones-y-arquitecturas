package ia.minimax.faseuno;

public class TreePrinter {
    public static void print(Node node, String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "└── " : "├── ") + node);
        String childPrefix = prefix + (isLast ? "    " : "│   ");
        for (int i = 0; i < node.children.size(); i++) {
            print(node.children.get(i), childPrefix, i == node.children.size() - 1);
        }
    }

    public static void print(Node root) {
        System.out.println(root);
        for (int i = 0; i < root.children.size(); i++) {
            print(root.children.get(i), "", i == root.children.size() - 1);
        }
    }
}
