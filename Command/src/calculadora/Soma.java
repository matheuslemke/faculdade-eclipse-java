package calculadora;

public class Soma implements Operacao
{
	private Calculadora calculadora;

	public Soma(Calculadora calculadora)
	{
		super();
		this.calculadora = calculadora;
	}

	@Override
	public double execute()
	{
		return calculadora.soma();
	}

}
