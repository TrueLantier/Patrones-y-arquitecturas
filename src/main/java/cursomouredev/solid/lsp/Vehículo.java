package cursomouredev.solid.lsp;

/**
 * En este ejercicio se hace uso de los conceptos relacionados con la palabra reservada "static" para practicar.
 * Es posible asignar la variable capacidadMax al constructor de la superclase Vehículo, personalizando eso para
 * todas las subclases, pero pierde el objetivo.
 */

public abstract class Vehículo {
    protected int cantidadPasajeros;
    protected double velocidad = 0;
    protected boolean encendido = false;
    protected String tipoVehículo;
    protected String marca;

    public Vehículo(String marca, int cantidadPasajeros) {
        this.marca = marca;
        this.cantidadPasajeros = cantidadPasajeros;
    }

    public void arrancar(boolean operación) {
        encendido = operación;
    }

    public void acelerar(double aceleración) {
        if (encendido == false) {
            System.out.println("El vehículo está apagado.");
            throw new RuntimeException();
        }
    }

    public void frenar() {}

    protected static void verificarPasajeros(int cantidadPasajeros, int máximo) {
        if (cantidadPasajeros > máximo) {
            throw new IllegalArgumentException("Cantidad de pasajeros incorrecta.");
        }
    }

    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public String getTipoVehículo() {
        return tipoVehículo;
    }

    public String getMarca() {
        return marca;
    }
}
