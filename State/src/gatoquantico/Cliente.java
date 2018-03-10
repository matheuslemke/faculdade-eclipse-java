package gatoquantico;

public class Cliente
{
	public static void main(String[] args)
	{
		Gato g = new Gato();
		g.setEstado(g.getVIVO());
		g.miar();

		g.setEstado(g.getQUANTICO());
		g.miar();

		g.setEstado(g.getMORTO());
		g.miar();

	}
}
