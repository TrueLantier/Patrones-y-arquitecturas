package escuela.ejerciciofinal.factorymethod;

public class CreadorEmail extends CreadorNotification{
    public CreadorEmail(String mensaje) {
        super.mensaje = mensaje;
    }

    @Override
    protected Notification crearNotification() {
        return new NotificationEmail();
    }
}
