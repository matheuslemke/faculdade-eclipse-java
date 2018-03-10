package conversorromanos;

public class Context
{
	private String input;
	private int output = 0;

	public Context(String input)
	{
		this.input = input;
	}

	public String getInput()
	{
		return input;
	}

	public int getOutput()
	{
		return output;
	}

	public void setOutput(int output)
	{
		this.output = output;
	}

	public void setInput(String input)
	{
		this.input = input;
	}
}
