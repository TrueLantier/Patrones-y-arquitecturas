package escuela.ejerciciofinal.abstractfactory;

public class Aplicacion {
    FabricaUI fabricaUI;

    public Aplicacion(FabricaUI fabricaUI) {
        this.fabricaUI = fabricaUI;
    }

    public void dibujar() {
        Boton boton = fabricaUI.crearBoton();
        boton.renderizar();

        Ventana ventana = fabricaUI.crearVentana();
        ventana.abrir();
    }
}
