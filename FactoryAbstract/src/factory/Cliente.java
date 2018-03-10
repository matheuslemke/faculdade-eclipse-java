package factory;

public class Cliente
{

	public static void main(String[] args)
	{
		ShapeFactory factory = new ShapeFactory();
		
		Shape quad = factory.createShape("Quad");
		System.out.println(quad.toString());
		
		Shape circle = factory.createShape("Circle");
		System.out.println(circle.toString());
		
		Shape triangle = factory.createShape("Triangle");
		System.out.println(triangle.toString());

	}
}
