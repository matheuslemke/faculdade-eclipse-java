package mediator;

public abstract class Actor
{
	protected Mediador mediador;

	public void setMediador(Mediador m)
	{
		mediador = m;
	}

	public abstract void notificar(String msg);
	
}
