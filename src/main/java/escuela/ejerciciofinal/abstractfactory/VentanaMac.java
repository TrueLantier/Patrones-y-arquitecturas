package escuela.ejerciciofinal.abstractfactory;

public class VentanaMac implements Ventana{
    @Override
    public void abrir() {
        System.out.println("Se ha abierto una ventana en Mac.");
    }
}
