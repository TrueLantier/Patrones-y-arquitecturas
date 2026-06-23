package escuela.ejerciciofinal.factorymethod;

public class CreadorSMS extends CreadorNotification{
    public CreadorSMS(String mensaje) {
        super.mensaje = mensaje;
    }

    @Override
    protected Notification crearNotification() {
        return new NotificationSMS();
    }
}
