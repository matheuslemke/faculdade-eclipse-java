package flyweight;

public class CharacterC implements Character
{
	private String symbol = "C";

	public CharacterC()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(int size)
	{
		System.out.println(symbol + size);

	}
}