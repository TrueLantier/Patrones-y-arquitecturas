package escuela.ejerciciofinal.factorymethod;

public class Main {
    static void main() {
        CreadorNotification notificationEmail = new CreadorEmail("Email");
        notificationEmail.processNotification();
    }
}
