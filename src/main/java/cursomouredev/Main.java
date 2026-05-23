package cursomouredev;

import cursomouredev.solid.lsp.*;

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
