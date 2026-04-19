package cursomouredev.solid.lsp;

public class Carro extends Vehículo{
    private final int RUEDAS = 4;
    private static final int CAPACIDADMAX = 5;

    public Carro(String tipoCarro, String marca, int cantidadPasajeros) {
        Vehículo.verificarPasajeros(cantidadPasajeros, CAPACIDADMAX);
        super(marca, cantidadPasajeros);
        tipoVehículo = tipoCarro;
    }

    @Override
    public void acelerar(double aceleración) {
        super.acelerar(aceleración);
        System.out.println("El carro está acelerando...");
        velocidad += aceleración;
    }

    @Override
    public void frenar() {
        System.out.println("El carro está frenando...");
        velocidad = 0;
    }

    public int getRUEDAS() {
        return RUEDAS;
    }
}
