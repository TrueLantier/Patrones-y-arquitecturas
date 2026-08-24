package cursomouredev.solid.isp;

public class TrabajoFinal implements ImpresoraBlancoNegro, Scanner{
    @Override
    public void imprimir(String texto) {
        System.out.println(texto);
        System.out.println("Se ha impreso en blanco y negro.");
    }

    @Override
    public String escanear(String texto) {
        return texto;
    }
}
