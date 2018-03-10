package factory;

public class ShapeFactory
{
	public Shape createShape(String shape)
	{
		try
		{
			return (Shape) Class.forName("factory." + shape).newInstance();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
