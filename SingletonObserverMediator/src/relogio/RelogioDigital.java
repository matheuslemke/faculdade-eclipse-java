package relogio;

public class RelogioDigital implements Observador
{

	private static RelogioCentral relogio;
	private int hora;

	public RelogioCentral getRelogio()
	{
		return relogio;
	}

	public RelogioDigital()
	{
		super();
	}

	public void atualizar()
	{
		hora++;
	}

	public int getHora()
	{
		return hora;
	}
}