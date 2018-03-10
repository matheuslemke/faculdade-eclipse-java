package calculadora;

public class Subtracao implements Operacao
{
	private Calculadora calculadora;

	public Subtracao(Calculadora calculadora)
	{
		super();
		this.calculadora = calculadora;
	}

	@Override
	public double execute()
	{
		return calculadora.subtracao();
	}

}
