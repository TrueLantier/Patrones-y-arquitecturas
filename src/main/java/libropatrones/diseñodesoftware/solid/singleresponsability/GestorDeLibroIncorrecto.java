package libropatrones.diseñodesoftware.solid.singleresponsability;

public class GestorDeLibroIncorrecto {
    private String titulo;
    private String autor;
    private String texto;

    public GestorDeLibroIncorrecto(String titulo, String autor, String texto) {
        this.titulo = titulo;
        this.autor = autor;
        this.texto = texto;
    }

    // Busca una palabra en el texto del libro
    public boolean buscarPalabra(String palabra) {
        return texto.contains(palabra);
    }

    // Imprime el libro en la consola
    public void imprimirLibro() {
        System.out.println(titulo + " por " + autor);
        System.out.println(texto);
    }

    // Guarda el libro en un archivo .txt
    public void guardarEnArchivo() {
        System.out.println("Guardando " + titulo + " en archivo de texto...");
        // Lógica de File I/O
    }
}
