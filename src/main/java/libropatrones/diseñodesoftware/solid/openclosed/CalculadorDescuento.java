package libropatrones.diseñodesoftware.solid.openclosed;

// Esta interfaz define el "contrato"
public interface CalculadorDescuento {
    double calcular(double monto);
}

// Implementamos el comportamiento en clases separadas (Extendemos el sistema):

class DescuentoRegular implements CalculadorDescuento {
    @Override
    public double calcular(double monto) {
        return monto;
    }
}

class DescuentoVIP implements CalculadorDescuento {
    @Override
    public double calcular(double monto) {
        return monto * 0.90;
    }
}

class DescuentoEmpleado implements CalculadorDescuento {
    @Override
    public double calcular(double monto) {
        return monto * 0.70;
    }
}