package escuela.ejerciciofinal.abstractfactory;

public class FabricaWindows implements FabricaUI{
    @Override
    public Boton crearBoton() {
        return new BotonWindows();
    }

    @Override
    public Ventana crearVentana() {
        return new VentanaWindows();
    }
}
