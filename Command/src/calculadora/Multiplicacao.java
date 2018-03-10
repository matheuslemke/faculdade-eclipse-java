package calculadora;

public class Multiplicacao implements Operacao
{
	private Calculadora calculadora;

	public Multiplicacao(Calculadora calculadora)
	{
		super();
		this.calculadora = calculadora;
	}

	@Override
	public double execute()
	{
		return calculadora.multiplicao();
	}

}
