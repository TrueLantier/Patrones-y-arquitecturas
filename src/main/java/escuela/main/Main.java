package escuela.main;
/*
 Angel Eduardo Pedraza Ordoñez.
 Info 35
 */

import escuela.ejercicio1.*;
import escuela.ejercicio3.ConfiguraciónGlobal;

public class Main {
    public static void main(String[] args) {
        ConfiguraciónGlobal cg = ConfiguraciónGlobal.getInstancia();
        System.out.println(cg.toString());
    }
}
