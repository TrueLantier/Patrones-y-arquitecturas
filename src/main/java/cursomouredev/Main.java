package cursomouredev;

import cursomouredev.solid.isp.*;
import cursomouredev.solid.lsp.*;
import cursomouredev.solid.ocp.*;
import cursomouredev.solid.srp.*;

public class Main {
    static void main(String[] args) {
        TrabajoFinal trabajoFinal = new TrabajoFinal();
        Fotos fotos = new Fotos();
        Impresora impresoraMultifunción= new Impresora();

        Impresora impresora = new Impresora();
        impresora.imprimir("A");
        System.out.println();

        trabajoFinal.imprimir("Primer texto");
        System.out.println(trabajoFinal.escanear("Trabajo Final"));
        System.out.println();

        fotos.imprimir("Segundo texto.");
        fotos.enviarFax();
        System.out.println();

        impresoraMultifunción.imprimir("Tercer texto.");
        System.out.println(impresoraMultifunción.escanear("Angel Eduardo."));
        impresoraMultifunción.enviarFax();
    }
}
