package escuela.ejerciciofinal.factorymethod;

public class NotificationEmail implements Notification{
    @Override
    public void enviar(String mensaje) {
        System.out.println("Enviando Email: " + mensaje);
    }
}
