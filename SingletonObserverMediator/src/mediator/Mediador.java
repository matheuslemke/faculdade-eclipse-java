package mediator;

public interface Mediador
{
	void send(String msg, String dest);

	public void addActor(String name, Actor a);

	public void removeActor(Actor a);
}
