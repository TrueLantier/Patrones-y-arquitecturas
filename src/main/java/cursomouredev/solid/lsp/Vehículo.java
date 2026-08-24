package cursomouredev.solid.lsp;

/**
 * En este ejercicio se hace uso de los conceptos relacionados con la palabra reservada "static" para practicar.
 * Es posible asignar la variable capacidadMax al constructor de la superclase Vehículo, personalizando eso para
 * todas las subclases, pero pierde el objetivo.
 */

public class Vehículo {
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
        if (!encendido) {
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

    public static void pruebaVehículo(Vehículo vehículo) {
        vehículo.acelerar(100);
        vehículo.frenar();
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

/*
        Vehículo carro = new Carro("Eléctrico", "Ferrari", 4);
        carro.arrancar(true);
        carro.acelerar(20);
        carro.acelerar(40);
        System.out.println(carro.getVelocidad());
        carro.frenar();
        System.out.println(carro.getVelocidad());

        System.out.println();
        Vehículo motor = new Motor("Eléctrico", "Suzuki", 2);
        motor.arrancar(true);
        motor.acelerar(30);
        motor.acelerar(60);
        System.out.println(motor.getVelocidad());
        motor.frenar();
        System.out.println(motor.getVelocidad());

        System.out.println();
        PruebaVehículo.pruebaVehículo(carro);
        PruebaVehículo.pruebaVehículo(motor);
 */