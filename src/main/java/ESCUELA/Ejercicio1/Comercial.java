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
    public boolean plus() {
        if ((edad > 30) && (comisión > 200)) {
            salario += PLUS;
            return true;
        }   else {
            System.out.println("No cumple las condiciones para un aumento salarial.");
            return false;
        }
    }
}
