package flyweight;

public class CharacterB implements Character
{
	private String symbol = "B";

	public CharacterB()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(int size)
	{
		System.out.println(symbol + size);

	}
}
