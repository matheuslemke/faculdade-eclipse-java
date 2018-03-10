package flyweight;

public class Cliente
{

	public static void main(String[] args)
	{
		String text = "ABBCBACB";
		CharacterFactory factory = new CharacterFactory();
		int size = 10;
		
		for (int i = 0; i < text.length(); i++)
		{
			String s = text.substring(i, i+1);
			//System.out.println(s);
			//char ch = text.charAt(i);
			Character c = factory.getCharacter(s);
			c.draw(size);
			size++;

		}

	}

}
