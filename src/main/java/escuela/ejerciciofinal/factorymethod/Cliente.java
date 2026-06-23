package escuela.ejerciciofinal.factorymethod;

/*
  Nota: El ejercicio dice que la clase Cliente debe recibir un CreadorNotification por parámetro, lo hice en su
  constructor y con un método aparte para que no halla que crear nuevos objetos cliente para nuevas notificaciones.
 */

public class Cliente {
    // CreadorNotification creador;

    public Cliente(CreadorNotification creador) {
        // this.creador = creador;
        creador.processNotification();
        System.out.println("Se ha recibido una notificación.");
    }

    public void responderNotification(CreadorNotification creador) {
        creador.processNotification();
        System.out.println("Se ha recibido una notificación.");
    }
}
