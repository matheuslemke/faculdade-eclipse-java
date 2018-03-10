package textprocessor;

public class CommandUnderline implements Command
{
	private TextProcessor tp;

	public CommandUnderline(TextProcessor tp)
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
		tp.underline();
	}

}
