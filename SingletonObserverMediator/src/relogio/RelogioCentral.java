package relogio;

public class RelogioCentral extends Relogio
{
	private static RelogioCentral relogio = new RelogioCentral();
	private int hora;

	public static synchronized RelogioCentral getRelogio()
	{
		return relogio;
	}

	public void setRelogio(RelogioCentral relogio)
	{
		RelogioCentral.relogio = relogio;
	}

	private RelogioCentral()
	{

	}

	public int getHora()
	{
		return hora;
	}

	public void alterarHora()
	{
		hora++;
		super.notificar();
	}

}