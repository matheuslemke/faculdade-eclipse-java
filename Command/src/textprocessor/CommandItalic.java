package textprocessor;

public class CommandItalic implements Command
{
	private TextProcessor tp;

	public CommandItalic(TextProcessor tp)
	{
		super();
		this.tp = tp;
	}

	public TextProcessor getTp()
	{
		return tp;
	}

	public void setTp(TextProcessor tp)
	{
		this.tp = tp;
	}

	@Override
	public void execute()
	{
		tp.italic();
	}

}
