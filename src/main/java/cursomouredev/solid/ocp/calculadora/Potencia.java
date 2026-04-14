package cursomouredev.solid.ocp.calculadora;

public class Potencia {
    public int calcularPotencia(int base, int exponente) {
        int resultado = 1;
        for (int i = 0; i < exponente; i++) {
            resultado *= base;
        }
        return resultado;
    }

    public double calcularPotencia(double base, double exponente) {
        return Math.pow(base, exponente);
    }
}
