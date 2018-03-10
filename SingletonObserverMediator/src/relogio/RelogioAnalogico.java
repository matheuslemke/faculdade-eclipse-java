package relogio;

public class RelogioAnalogico implements Observador
{

	private static RelogioCentral relogio = RelogioCentral.getRelogio();
	private int hora;

	public RelogioCentral getRelogio()
	{
		return relogio;
	}

	public RelogioAnalogico()
	{
		
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