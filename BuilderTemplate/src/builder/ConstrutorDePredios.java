package builder;

public class ConstrutorDePredios implements Construtor
{
	private Predio resultado = new Predio();

	@Override
	public void construirParteUm()
	{
		System.out.println("Construindo CASA!");
		System.out.println("Base/Sustentação");
	}

	@Override
	public void construirParteDois()
	{
		System.out.println("Estrutura");
	}

	@Override
	public void construirParteTres()
	{
		System.out.println("Fechamento/Paredes");
	}

	@Override
	public void construirParteQuatro()
	{
		System.out.println("Acabamento");
		resultado = new Predio();
	}

	public Predio getPredio()
	{
		System.out.println("PRÉDIO CONCLUÍDO");
		return resultado;
	}

}
