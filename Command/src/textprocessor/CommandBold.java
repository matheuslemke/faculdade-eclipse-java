package textprocessor;

public class CommandBold implements Command
{
	private TextProcessor tp;

	public CommandBold(TextProcessor tp)
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
		tp.bold();
	}
}
