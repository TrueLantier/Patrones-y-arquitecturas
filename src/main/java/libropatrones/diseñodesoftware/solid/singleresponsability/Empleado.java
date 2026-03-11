package libropatrones.diseñodesoftware.solid.singleresponsability;

public class Empleado {
    private String nombre;
    private double salarioBase;

    public Empleado(String nombre, double salarioBase) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }

    public String getNombre() { return nombre; }

    public double calcularSalarioNeto() {
        return salarioBase - (salarioBase * 0.15);
    }
}

class EmpleadoRepository {
    public void guardar(Empleado empleado) {
        System.out.println("Guardando en la BD a: " + empleado.getNombre());
        // Código SQL o de JPA aquí...
    }
}

class EmpleadoReporte {
    public void imprimir(Empleado empleado) {
        System.out.println("--- Reporte de Empleado ---");
        System.out.println("Nombre: " + empleado.getNombre());
        System.out.println("Salario Neto: " + empleado.calcularSalarioNeto());
    }
}

/*
 ¿Por qué está bien?
 Ahora cada clase tiene una única responsabilidad. Si cambia la base de datos, solo tocas EmpleadoRepository.
 El código es limpio, modular y muy fácil de mantener.
 */