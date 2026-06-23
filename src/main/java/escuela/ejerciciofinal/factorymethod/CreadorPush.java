package escuela.ejerciciofinal.factorymethod;

public class CreadorPush extends CreadorNotification{
    public CreadorPush(String mensaje) {
        super.mensaje = mensaje;
    }

    @Override
    protected Notification crearNotification() {
        return new NotificationPush();
    }
}
