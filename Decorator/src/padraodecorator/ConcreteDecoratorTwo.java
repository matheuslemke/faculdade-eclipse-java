package padraodecorator;

public class ConcreteDecoratorTwo extends Decorator
{

	public ConcreteDecoratorTwo(Component component)
	{
		super(component);
	}

	@Override
	public int getNumber()
	{
		return component.getNumber() + 2;
	}

}
