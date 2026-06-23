package escuela.ejerciciofinal.factorymethod;

public class CreadorPush extends CreadorNotification{
    @Override
    protected Notification crearNotification() {
        super.mensaje = mensaje;
        return new NotificationPush();
    }
}
