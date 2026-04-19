package cursomouredev.solid.lsp;

public class Motor extends Vehículo{
    private final int RUEDAS = 2;
    private static final int CAPACIDADMAX = 2;

    public Motor(String tipoMoto, String marca, int cantidadPasajeros) {
        verificarPasajeros(cantidadPasajeros, CAPACIDADMAX);
        super(marca, cantidadPasajeros);
        tipoVehículo = tipoMoto;
    }

    @Override
    public void acelerar(double aceleración) {
        super.acelerar(aceleración);
        System.out.println("La Moto está acelerando...");
        velocidad += aceleración;
    }

    @Override
    public void frenar() {
        System.out.println("El carro está frenando...");
        velocidad = 0;
    }
}
