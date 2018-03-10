package estrategiaguerra;

public class Diplomacia implements Estrategia
{

	@Override
	public void guerrear()
	{
		recuarTropas();
		proporCooperacaoEconomica();
	}

	@Override
	public void concluir()
	{
		desarmarInimigo();
	}

	private void recuarTropas()
	{
		System.out.println("Tropas recuadas");
	}

	private void proporCooperacaoEconomica()
	{
		System.out.println("Cooperação ecômica proposta! Aguardando resposta");
	}

	private void desarmarInimigo()
	{
		System.out.println("Inimigo desarmado");
	}
}
