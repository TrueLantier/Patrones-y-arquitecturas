package escuela.ejerciciofinal.factorymethod;

public class CreadorSMS extends CreadorNotification{
    @Override
    protected Notification crearNotification() {
        super.mensaje = mensaje;
        return new NotificationSMS();
    }
}
