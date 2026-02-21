package ESCUELA.main;
/*
Angel Eduardo Pedraza Ordoñez.
Info 35
 */

import ESCUELA.Ejercicio1.Comercial;
import ESCUELA.Ejercicio1.Empleado;
import ESCUELA.Ejercicio1.Repartidor;

public class Main {
    public static void main(String[] args) {
        Empleado[] empleados = new Empleado[6];

        empleados[0] = new Comercial("Ernesto", 18, 4000, 300);
        empleados[1] = new Comercial("María", 33, 6000, 400);
        empleados[2] = new Comercial("Pedro", 40, 2000, 100);
        empleados[3] = new Repartidor("Lucas", 20, 1500, "zona 1");
        empleados[4] = new Repartidor("Jorge", 27, 2400, "zona 3");
        empleados[5] = new Repartidor("Laura", 19, 900, "zona 3");

        for (Empleado empleado : empleados) {
            System.out.println("El empleado es: " + empleado.getNombre());
            System.out.println("Su edad es: " + empleado.getEdad());
            System.out.println("Su salario es: " + empleado.getSalario());

            if (empleado.plus()) {
                System.out.println("Su nuevo salario es: " + empleado.getSalario());
            }
            System.out.println();
        }
    }
}
