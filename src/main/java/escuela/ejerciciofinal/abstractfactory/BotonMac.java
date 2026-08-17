package escuela.ejerciciofinal.abstractfactory;

public class BotonMac implements Boton{
    @Override
    public void renderizar() {
        System.out.println("Se ha renderizado un botón en Mac.");
    }
}
