package subtractorvisitor;

public class SubtractVisitor implements Visitor
{

	public void visit(IntegerContainer ic)
	{
		ic.setNumber(ic.getNumber() - 1);
	}

	@Override
	public void visit(DoubleContainer dc)
	{
		dc.setNumber(dc.getNumber() - 1);

	}

}
