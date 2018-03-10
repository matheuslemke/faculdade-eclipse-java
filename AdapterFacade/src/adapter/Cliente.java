package adapter;

public class Cliente
{

	public static void main(String[] args)
	{
		Dado d1 = new AdapterDadoViciado(new DadoViciado());
		Dado d2 = new DadoNormal();

		for (int i = 1; i < 6; i++)
		{
			d1.jogaDado();
			d2.jogaDado();
			System.out.println("Jogada " + i + " Viciado: " + d1.lerFace());
			System.out.println("Jogada " + i + " Normal: " + d2.lerFace());
		}

	}

}
