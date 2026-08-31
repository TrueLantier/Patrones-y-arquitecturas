package cursomouredev.solid.dip.encendedor;

public abstract class InterruptorLámpara implements Interruptor{
    @Override
    public void encender() {
        System.out.println("Se ha encendido la lámpara.");
    }

    @Override
    public void apagar() {
        System.out.println("Se ha apagado la lámpara.");
    }
}
