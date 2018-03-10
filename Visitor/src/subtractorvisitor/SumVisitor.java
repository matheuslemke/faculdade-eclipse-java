package subtractorvisitor;

public class SumVisitor implements Visitor
{

	@Override
	public void visit(DoubleContainer dc)
	{
		dc.setNumber(dc.getNumber() + 1);
	}

	@Override
	public void visit(IntegerContainer ic)
	{
		ic.setNumber(ic.getNumber() + 1);
	}

}
