package cursomouredev.solid.ocp.calculadora;

public class Calculadora {
    public final Suma suma;
    public final Resta resta;
    public final Multiplicación multiplicación;
    public final División división;
    public final Potencia potencia;

    public Calculadora() {
        suma = new Suma();
        resta = new Resta();
        multiplicación = new Multiplicación();
        división = new División();
        potencia = new Potencia();
    }
}
