package padraodecorator;

public class ConcreteDecoratorOne extends Decorator
{

	public ConcreteDecoratorOne(Component component)
	{
		super(component);
	}

	@Override
	public int getNumber()
	{
		return component.getNumber() + 1;
	}

	public void printNumber()
	{
		System.out.println("Number: " + component.getNumber());
	}

}
