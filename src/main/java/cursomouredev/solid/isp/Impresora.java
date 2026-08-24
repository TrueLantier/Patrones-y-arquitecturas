package cursomouredev.solid.isp;

public class Impresora implements ImpresoraMultifunción, ImpresoraBlancoNegro, ImpresoraColor{

    @Override
    public void imprimir(String texto) {
        System.out.println(texto);
        System.out.println("Esta es la impresora multifunción.");
    }

    @Override
    public String escanear(String texto) {
        return texto;
    }

    @Override
    public void enviarFax() {
        System.out.println("Se ha enviado el fax de Impresora.");
    }
}

/*

 */