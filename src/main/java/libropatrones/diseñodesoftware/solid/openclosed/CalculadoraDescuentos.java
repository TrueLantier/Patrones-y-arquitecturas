package libropatrones.diseñodesoftware.solid.openclosed;

public class CalculadoraDescuentos {

    public double aplicarDescuento(double monto, String tipoCliente) {
        if (tipoCliente.equals("REGULAR")) {
            return monto; // Sin descuento
        } else if (tipoCliente.equals("VIP")) {
            return monto * 0.90; // 10% de descuento
        } else if (tipoCliente.equals("EMPLEADO")) {
            return monto * 0.70; // 30% de descuento
        }
        return monto;
    }
}

/*
 ¿Por qué está mal?
 Imagina que el equipo de Marketing decide crear una nueva membresía: "CLIENTE_PREMIUM". Para añadir esta funcionalidad,
 tienes que entrar a la clase CalculadoraDescuentos y modificarla agregando un nuevo else if.
 Cada vez que modificas código existente, corres el riesgo de introducir bugs (errores) en funcionalidades que antes
 operaban perfectamente. Esta clase está abierta a modificación, lo cual viola el principio.
 */
