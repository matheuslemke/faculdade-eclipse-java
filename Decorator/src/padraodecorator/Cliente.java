package padraodecorator;

public class Cliente
{

	public static void main(String[] args)
	{
		Component c = new ConcreteComponent();
		Component one = new ConcreteDecoratorOne(c);
		Component two = new ConcreteDecoratorTwo(one);
		
		System.out.println(two.getNumber());

	}

}
