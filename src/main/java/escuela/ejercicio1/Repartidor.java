package escuela.ejercicio1;

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
        String mensaje = super.toString() + "\nLa zona en la que reparte es: " + getZona();
        return mensaje;
    }

    @Override
    public void plus() {
        if ((edad < 25) && (zona.equals("zona 3"))) {
            salario += PLUS;
            System.out.println("Su nuevo salario es: " + getSalario() + " €");
        }   else {
            System.out.println("No cumple las condiciones para un aumento salarial.");
        }
    }
}
