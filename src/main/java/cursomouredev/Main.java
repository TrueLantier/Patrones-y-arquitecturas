package cursomouredev;

import cursomouredev.solid.ocp.calculadora.*;
import cursomouredev.solid.srp.gestiónbiblioteca.*;

public class Main {
    public static void main(String[] args) {
        Calculadora ca = new Calculadora();
        System.out.println(ca.suma.sumar(1, 2, 3.0));
        System.out.println(ca.potencia.calcularPotencia(2, 4));
        System.out.println(ca.potencia.calcularPotencia(Math.PI, 2));
    }
}
