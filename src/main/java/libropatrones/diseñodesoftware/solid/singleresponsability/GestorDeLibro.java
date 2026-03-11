package libropatrones.diseñodesoftware.solid.singleresponsability;

public class GestorDeLibro {
    private String titulo;
    private String autor;
    private String texto;

    public GestorDeLibro(String titulo, String autor, String texto) {
        this.titulo = titulo;
        this.autor = autor;
        this.texto = texto;
    }

    public String getAutor() { return autor; }

    public String getTitulo() { return titulo; }

    public String getTexto() { return texto; }

    // Es simplemente el método que elegí conservar.
    public void guardarEnArchivo() {
        System.out.println("Guardando " + titulo + " en archivo de texto...");
        // Lógica de File I/O
    }
}

// El método de búsqueda puede cambiar o pedir nuevas condiciones.
class BuscarPalabra {
    public boolean buscarPalabra(GestorDeLibro gestorDeLibro, String palabra) {
        return gestorDeLibro.getTexto().contains(palabra);
    }
}

// El método de imprimir puede variar la forma.
class ImprimirLibro {
    private void imprimirLibro(GestorDeLibro gestorDeLibro) {
        System.out.println(gestorDeLibro.getTitulo() + " por " + gestorDeLibro.getAutor());
        System.out.println(gestorDeLibro.getTexto());
    }
}