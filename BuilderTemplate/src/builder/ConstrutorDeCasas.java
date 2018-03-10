package builder;

public class ConstrutorDeCasas implements Construtor
{
	private Casa resultado;

	@Override
	public void construirParteUm()
	{
		System.out.println("Construindo PRÉDIO!");
		System.out.println("Fundação/Piso");
	}

	@Override
	public void construirParteDois()
	{
		System.out.println("Paredes");
	}

	@Override
	public void construirParteTres()
	{
		System.out.println("Telhado/Teto");
	}

	@Override
	public void construirParteQuatro()
	{
		System.out.println("Acabamento");
		resultado = new Casa();
	}

	public Casa getCasa()
	{
		System.out.println("CASA CONCLUÍDA");
		return resultado;
	}

}
