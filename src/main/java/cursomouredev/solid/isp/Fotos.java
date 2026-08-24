package cursomouredev.solid.isp;

public class Fotos implements ImpresoraColor, Fax{
    @Override
    public void imprimir(String texto) {
        System.out.println(texto);
        System.out.println("Se ha impreso a Color.");
    }

    @Override
    public void enviarFax() {
        System.out.println("Se ha enviado el fax de Fotos.");
    }
}
