package conversorromanos;

public class TenExpression extends Expression
{

	@Override
	public String one()
	{
		return "X";
	}

	@Override
	public String four()
	{
		// TODO Auto-generated method stub
		return "XL";
	}

	@Override
	public String five()
	{
		// TODO Auto-generated method stub
		return "L";
	}

	@Override
	public String nine()
	{
		// TODO Auto-generated method stub
		return "XC";
	}

	@Override
	public int multiplier()
	{
		return 10;
	}

}
