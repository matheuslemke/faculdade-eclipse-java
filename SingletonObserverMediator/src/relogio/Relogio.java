package relogio;

import java.util.ArrayList;
import java.util.List;

public abstract class Relogio
{

	private List<Observador> observadores = new ArrayList<>();

	public void addObservador(Observador o)
	{
		observadores.add(o);
	}

	public void removeObservador(Observador o)
	{
		observadores.remove(o);
	}

	public Relogio()
	{
		super();
	}

	public void notificar()
	{
		for (Observador observador : observadores)
		{
			observador.atualizar();
		}
	}

}