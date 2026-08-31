package cursomouredev.solid.dip.encendedor;

public abstract class InterruptorTelevisor implements Interruptor{
    @Override
    public void encender() {
        System.out.println("Se ha encendido el televisor.");
    }

    @Override
    public void apagar() {
        System.out.println("Se ha apagado el televisor.");
    }
}
