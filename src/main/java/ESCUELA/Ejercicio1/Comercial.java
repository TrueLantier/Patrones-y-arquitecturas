package ESCUELA.Ejercicio1;

public class Comercial extends Empleado{
    private double comisión;

    public Comercial(String nombre, int edad, double salario, double comisión) {
        super(nombre, edad, salario);
        this.comisión = comisión;
    }

    public double getComisión() { return comisión; }

    public void setComisión(double comisión) { this.comisión = comisión; }

    @Override
    public String toString() {
        String mensaje = super.toString() + "\nLa comisión que cobra es de: " + getComisión() + " €";
        return mensaje;
    }

    @Override
    public void plus() {
        if ((edad > 30) && (comisión > 200)) {
            salario += PLUS;
            System.out.println("Su nuevo salario es: " + getSalario() + " €");
        }   else {
            System.out.println("No cumple las condiciones para un aumento salarial.");
        }
    }
}
