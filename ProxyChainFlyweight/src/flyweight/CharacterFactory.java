package flyweight;

import java.util.*;

public class CharacterFactory
{
	private Map<String, Character> map = new HashMap<>();

	public Character getCharacter(String c)
	{
		if (map.containsKey(c))
			return map.get(c);
		try
		{
			map.put(c, (Character) Class.forName("flyweight.Character" + c).newInstance());
			return map.get(c);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

}
