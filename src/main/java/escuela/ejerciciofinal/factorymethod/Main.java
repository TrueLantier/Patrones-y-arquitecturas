package escuela.ejerciciofinal.factorymethod;

public class Main {
    static void main() {
        CreadorNotification notificationEmail = new CreadorEmail("Email");
        CreadorNotification notificationSMS = new CreadorSMS("SMS");
        CreadorNotification notificationPush = new CreadorPush("Push");

        Cliente cliente = new Cliente(notificationEmail);
        System.out.println();
        cliente = new Cliente(notificationSMS);
        System.out.println();
        cliente = new Cliente(notificationPush);

        System.out.println();

        CreadorNotification notificationEmail2 = new CreadorEmail("Nuevo Email");
        CreadorNotification notificationSMS2 = new CreadorSMS("Nuevo SMS");
        CreadorNotification notificationPush2 = new CreadorPush("Nuevo Push");

        cliente.responderNotification(notificationEmail2);
        System.out.println();
        cliente.responderNotification(notificationSMS2);
        System.out.println();
        cliente.responderNotification(notificationPush2);
    }
}
