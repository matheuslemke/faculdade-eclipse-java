package padraodecorator;

public abstract class Decorator implements Component
{
	protected Component component;

	public Decorator(Component component)
	{
		this.component = component;
	}

	@Override
	public int getNumber()
	{
		return component.getNumber();
	}

}
