package subtractorvisitor;

public interface Visitor
{
	public void visit(IntegerContainer ic);

	public void visit(DoubleContainer dc);
}
