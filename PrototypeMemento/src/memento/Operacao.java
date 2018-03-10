package memento;

public class Operacao
{
	private double x;
	private double y;
	private String op;
	private double result;

	public Operacao(double x, double y, String op, double result)
	{
		System.out.println("Nova Operação!");
		this.x = x;
		this.y = y;
		this.op = op;
		this.result = result;
	}

	public double getX()
	{
		return x;
	}

	public void setX(double x)
	{
		this.x = x;
	}

	public double getY()
	{
		return y;
	}

	public void setY(double y)
	{
		this.y = y;
	}

	public String getOp()
	{
		return op;
	}

	public void setOp(String op)
	{
		this.op = op;
	}

	public double getResult()
	{
		return result;
	}

	public void setResult(double result)
	{
		this.result = result;
	}

	@Override
	public String toString()
	{
		return x + " " + op + " " + y + " = " + result;
	}
}
