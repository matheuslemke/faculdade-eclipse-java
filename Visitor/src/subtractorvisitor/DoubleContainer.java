package subtractorvisitor;

public class DoubleContainer implements Element
{
	private double number;

	public DoubleContainer(double number)
	{
		this.number = number;
	}

	public void setNumber(double number)
	{
		this.number = number;
	}

	public double getNumber()
	{
		return number;
	}

	@Override
	public void accept(Visitor v)
	{
		v.visit(this);
	}

}
