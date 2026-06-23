package escuela.ejerciciofinal.factorymethod;

public abstract class CreadorNotification {
    String mensaje;

    // Factory Method
    protected abstract Notification crearNotification();

    // Lógica en común
    public void processNotification() {
        Notification notification = crearNotification();
        notification.enviar(mensaje);
        mensaje = "";
    }
}
