package calculadora;

public class Divisao implements Operacao
{
	private Calculadora calculadora;

	public Divisao(Calculadora calculadora)
	{
		super();
		this.calculadora = calculadora;
	}

	@Override
	public double execute()
	{
		return calculadora.divisao();
	}

}
