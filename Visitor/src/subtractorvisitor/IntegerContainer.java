package subtractorvisitor;

public class IntegerContainer implements Element
{
	private int number;

	public IntegerContainer(int number)
	{
		this.number = number;
	}

	public void setNumber(int number)
	{
		this.number = number;
	}

	public int getNumber()
	{
		return number;
	}

	@Override
	public void accept(Visitor v)
	{
		v.visit(this);

	}

}
