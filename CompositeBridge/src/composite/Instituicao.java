package composite;

import java.util.ArrayList;

public class Instituicao implements Participante
{

	private ArrayList<Participante> participantes = new ArrayList<>();

	public Instituicao()
	{
		// TODO Auto-generated constructor stub
	}
	
	public void add(Participante participante)
	{
		this.participantes.add(participante);
	}

	public void remove(Participante participante)
	{
		this.participantes.remove(participante);
	}

	public Participante getParticipante(int i)
	{
		return this.participantes.get(i);
	}

	@Override
	public int getAssentos()
	{
		int assentos = 0;
		for (Participante participante : participantes)
			assentos += participante.getAssentos();
		return assentos;
	}

}
