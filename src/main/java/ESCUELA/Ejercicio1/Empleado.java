package ESCUELA.Ejercicio1;
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
        System.out.println("El empleado es: " + getNombre());
        System.out.println("Su edad es: " + getEdad());
        System.out.println("Su salario es: " + getSalario());
        return null;
    }

    public abstract boolean plus();
}
