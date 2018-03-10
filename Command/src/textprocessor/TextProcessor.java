package textprocessor;

public class TextProcessor
{
	private String text;

	public TextProcessor(String text)
	{
		super();
		this.text = text;
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public void italic()
	{
		System.out.println(text + " italic");
	}

	public void bold()
	{
		System.out.println(text + " bold");
	}

	public void underline()
	{
		System.out.println(text + " underline");
	}

}
