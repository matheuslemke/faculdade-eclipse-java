package mediator;

import java.util.HashMap;

public class MediadorConcreto implements Mediador
{
	private HashMap<String, Actor> actors = new HashMap<>();

	@Override
	public void send(String msg, String dest)
	{
		actors.get(dest).notificar(msg);
	}

	@Override
	public void removeActor(Actor a)
	{
		actors.remove(a);
	}

	@Override
	public void addActor(String name, Actor a)
	{
		actors.put(name, a);
	}

}
