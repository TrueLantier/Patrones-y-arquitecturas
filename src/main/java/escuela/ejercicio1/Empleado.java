package escuela.ejercicio1;
/*
 Angel Eduardo Pedraza Ordoñez.
 Info 35
 */

public abstract class Empleado {
    protected String nombre;
    protected int edad;
    protected double salario;
    protected final int PLUS = 300;

    public Empleado(String nombre, int edad, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    public String getNombre() { return nombre; }

    public int getEdad() { return edad; }

    public double getSalario() { return salario; }

    public int getPLUS() { return PLUS; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public void setEdad(int edad) { this.edad = edad; }

    public void setSalario(double salario) { this.salario = salario; }

    @Override
    public String toString() {
        String mensaje = "El nombre del empleado es: " + getNombre() + "\nSu edad es: " + getEdad() +
                "\nSu salario es: " + getSalario() + " €";

        return mensaje;
    }

    public abstract void plus();
}
