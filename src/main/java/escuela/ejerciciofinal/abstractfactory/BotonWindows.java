package escuela.ejerciciofinal.abstractfactory;

public class BotonWindows implements Boton{
    @Override
    public void renderizar() {
        System.out.println("Se ha renderizado un botón en Windows.");
    }
}
