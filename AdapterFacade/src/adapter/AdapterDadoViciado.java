package adapter;

public class AdapterDadoViciado implements Dado
{

	private int face;
	private DadoViciado dado;

	public AdapterDadoViciado()
	{

	}

	public AdapterDadoViciado(DadoViciado dado)
	{
		super();
		this.dado = dado;
	}

	@Override
	public void jogaDado()
	{
		face = dado.joga();
	}

	@Override
	public int lerFace()
	{
		return face;
	}

}
