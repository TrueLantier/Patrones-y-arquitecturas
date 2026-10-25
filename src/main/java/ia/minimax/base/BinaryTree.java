package ia.minimax.base;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private Node root;

    public boolean isEmpty() {
        return root == null;
    }

    public int height() {
        return height(root);
    }
    private int height(Node n) {
        if (n==null) { return -1;}
        return 1 + Math.max(height(n.left), height(n.right));
    }

    public int size() {
        return size(root);
    }
    private int size(Node n) {
        if (n==null) { return 0;}
        return 1 + size(n.left) + size(n.right);
    }

    public int countLeafs() {
        return countLeafs(root);
    }
    private int countLeafs(Node n) {
        if (n==null) { return 0;}
        if (n.left==null && n.right==null) { return 1;}
        return countLeafs(n.left) + countLeafs(n.right);
    }

    // DFS
    // Preorden n-l-r
    public void preorden(Node n) {
        if (n==null) {return;}
        System.out.print(n.valor + " ");
        preorden(n.left);
        preorden(n.right);
    }
    // Inorden l-n-r
    public void inorden(Node n) {
        if (n==null) {return;}
        inorden(n.left);
        System.out.print(n.valor + " ");
        inorden(n.right);
    }
    // Postorden l-r-n
    public void postorden(Node n) {
        if (n==null) {return;}
        postorden(n.left);
        postorden(n.right);
        System.out.print(n.valor + " ");
    }

    // BFS
    public void forLevels() {
        if (root==null) { return;}
        Queue<Node> cola = new LinkedList<>();
        cola.add(root);
        while (!cola.isEmpty()) {
            Node actual = cola.poll();
            System.out.println(actual.valor + " ");
            if (actual.left != null) { cola.add(actual.left);}
            if (actual.right != null) { cola.add(actual.right);}
        }
    }


}
