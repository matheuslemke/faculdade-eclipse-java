package flyweight;

public class CharacterA implements Character
{
	private String symbol = "A";

	public CharacterA()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(int size)
	{
		System.out.println(symbol + size);

	}

}
