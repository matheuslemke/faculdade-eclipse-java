package adapter;

import java.util.Random;

public class DadoNormal implements Dado
{

	private int face;

	public DadoNormal()
	{

	}

	@Override
	public void jogaDado()
	{
		Random aleatorio = new Random();
		face = aleatorio.nextInt(6) + 1;
	}

	@Override
	public int lerFace()
	{
		return face;
	}

}
