package ia.minimax.faseuno;

import java.util.ArrayList;
import java.util.List;

public class ArbolUno {

    static class Nodo {
        boolean esMax;
        Integer valor;
        List<Nodo> hijos = new ArrayList<>();

        Nodo(boolean esMax) { this.esMax = esMax; }
        Nodo(int valor)     { this.valor = valor; }

        Nodo add(Nodo hijo) {
            hijos.add(hijo);
            return this;
        }
    }

    public static void main(String[] args) {
        // Hojas
        Nodo n3 = new Nodo(3);
        Nodo n5 = new Nodo(5);
        Nodo n2 = new Nodo(2);
        Nodo n8 = new Nodo(8);

        // Nodos MIN: B y C
        Nodo B = new Nodo(false).add(n3).add(n5);
        Nodo C = new Nodo(false).add(n2).add(n8);

        // Raíz MAX
        Nodo raiz = new Nodo(true).add(B).add(C);
    }
}
