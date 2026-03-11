package libropatrones.diseñodesoftware.solid.singleresponsability;

// Ejemplo incorrecto.

public class EmpleadoIncorrecto {
    private String nombre;
    private double salarioBase;

    public EmpleadoIncorrecto(String nombre, double salarioBase) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }

    // 1. Responsabilidad: Lógica de negocio
    public double calcularSalarioNeto() {
        return salarioBase - (salarioBase * 0.15); // Descuento de impuestos
    }

    // 2. Responsabilidad: Persistencia (Base de datos)
    public void guardarEnBaseDeDatos() {
        System.out.println("Conectando a la BD y guardando a: " + this.nombre);
        // Código SQL aquí...
    }

    // 3. Responsabilidad: Presentación o formateo
    public void imprimirReporte() {
        System.out.println("--- Reporte de Empleado ---");
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Salario Neto: " + calcularSalarioNeto());
    }
}

/*
 ¿Por qué está mal?
 Si mañana cambiamos la base de datos de MySQL a PostgreSQL, tenemos que modificar la clase Empleado. Si la ley de
 impuestos cambia, modificamos la misma clase. Si el formato del reporte cambia de texto a PDF, volvemos a modificar
 Empleado. ¡Tiene tres razones distintas para cambiar!
 */