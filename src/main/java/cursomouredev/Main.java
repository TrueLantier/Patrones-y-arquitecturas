package cursomouredev;

import cursomouredev.solid.lsp.*;
import cursomouredev.solid.ocp.calculadora.*;
import cursomouredev.solid.srp.gestiónbiblioteca.*;

public class Main {
    public static void main(String[] args) {
        Vehículo carro = new Carro("Eléctrico", "Ferrari", 4);
        carro.arrancar(true);
        carro.acelerar(20);
        carro.acelerar(40);
        System.out.println(carro.getVelocidad());
        carro.frenar();
        System.out.println(carro.getVelocidad());
    }
}
