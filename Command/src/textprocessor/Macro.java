package textprocessor;

import java.util.ArrayList;

public class Macro
{
	ArrayList<Command> macro = new ArrayList<>();

	public void addCommand(Command c)
	{
		macro.add(c);
	}

	public void executeAll()
	{
		for (Command command : macro)
		{
			command.execute();
		}
	}
}
