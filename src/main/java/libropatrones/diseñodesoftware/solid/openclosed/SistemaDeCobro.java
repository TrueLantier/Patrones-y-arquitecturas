package libropatrones.diseñodesoftware.solid.openclosed;

public class SistemaDeCobro {

    // Recibimos la interfaz, no la clase concreta ni un String.
    public double procesarCobro(double monto, CalculadorDescuento calculador) {
        // Al sistema de cobro no le importa qué tipo de cliente es,
        // solo le dice a la interfaz: "¡Calcula!"
        return calculador.calcular(monto);
    }
}

/*
 ¿Por qué está bien?
 Si mañana Marketing lanza el "CLIENTE_PREMIUM", no tocamos la clase SistemaDeCobro. Simplemente creamos una nueva
 clase DescuentoPremium implements CalculadorDescuento. Hemos extendido la funcionalidad (abierto para extensión)
 sin tocar el código existente (cerrado para modificación). ¡Tu código ahora es invencible a los cambios de negocio!
 */
