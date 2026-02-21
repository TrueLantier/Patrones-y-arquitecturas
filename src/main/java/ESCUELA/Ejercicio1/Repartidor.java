package ESCUELA.Ejercicio1;

public class Repartidor extends Empleado{
    private String zona;

    public Repartidor(String nombre, int edad, double salario, String zona) {
        super(nombre, edad, salario);
        this.zona = zona;
    }

    public String getZona() { return zona; }

    public void setZona(String zona) { this.zona = zona; }

    @Override
    public String toString() {
        System.out.println("La zona en la que reparte es: " + getZona());
        return null;
    }

    @Override
    public boolean plus() {
        if ((edad < 25) && (zona.equals("zona 3"))) {
            salario += PLUS;
            return true;
        }
        else {
            System.out.println("No cumple las condiciones para un aumento salarial.");
            return false;
        }
    }
}
