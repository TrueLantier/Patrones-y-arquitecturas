package escuela.ejerciciofinal.factorymethod;

public class NotificationSMS implements Notification{
    @Override
    public void enviar(String mensaje) {
        System.out.println("Enviando SMS: " + mensaje);
    }
}
