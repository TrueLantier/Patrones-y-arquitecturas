package escuela.ejerciciofinal.abstractfactory;

public class Main {
    static void main() {
        FabricaWindows fabricaWindows = new FabricaWindows();
        Aplicacion aplicacionWindows = new Aplicacion(fabricaWindows);
        aplicacionWindows.dibujar();

        System.out.println();

        FabricaMac fabricaMac = new FabricaMac();
        Aplicacion aplicacionMac = new Aplicacion(fabricaMac);
        aplicacionMac.dibujar();
    }
}
