package escuela.ejerciciofinal.factorymethod;

public class Cliente {
    CreadorNotification notification;

    public Cliente(CreadorNotification creadorNotification) {
        this.notification = creadorNotification;
    }

    public void responderEmail(CreadorEmail creadorEmail) {

    }
}
