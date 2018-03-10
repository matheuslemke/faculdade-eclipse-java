package calculadora;

public class Calculadora
{
	private double x;
	private double y;

	public Calculadora(double x, double y)
	{
		super();
		this.x = x;
		this.y = y;
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

	public double soma()
	{
		return x + y;
	}

	public double subtracao()
	{
		return x - y;
	}

	public double divisao()
	{
		return x / y;
	}

	public double multiplicao()
	{
		return x * y;
	}
}
