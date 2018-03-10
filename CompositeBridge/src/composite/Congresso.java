package composite;

import java.util.ArrayList;

public class Congresso
{
	private ArrayList<Participante> participantes = new ArrayList<>();

	public Congresso()
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

	public int totalAssentos()
	{
		int total = 0;
		for (Participante participante : participantes)
			total += participante.getAssentos();
		return total;
	}

	public int totalParticipantes()
	{
		return participantes.size();
	}

}
