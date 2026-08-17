package escuela.ejerciciofinal.abstractfactory;

public class VentanaWindows implements Ventana{
    @Override
    public void abrir() {
        System.out.println("Se ha abierto una ventana en Windows.");
    }
}
