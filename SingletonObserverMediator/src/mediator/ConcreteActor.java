package mediator;

public class ConcreteActor extends Actor
{
	private String name;

	public ConcreteActor(String name)
	{
		super();
		this.name = name;
	}

	public void send(String msg, String dest)
	{
		mediador.send(msg, dest);
	}
	
	public void notificar(String msg)
	{
		System.out.println("Actor " + name + " received the follow message: \n"
				+ msg);
	}
	
	public String getName()
	{
		return name;
	}
}
