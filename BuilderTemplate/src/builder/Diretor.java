package builder;

import java.util.ArrayList;

public class Diretor
{
	private ArrayList<Construtor> construtores = new ArrayList<>();

	public void addConstrutor(Construtor c)
	{
		construtores.add(c);
	}

	public void construir()
	{
		for (Construtor construtor : construtores)
		{
			construtor.construirParteUm();
			construtor.construirParteDois();
			construtor.construirParteTres();
			construtor.construirParteQuatro();
		}
	}
}
