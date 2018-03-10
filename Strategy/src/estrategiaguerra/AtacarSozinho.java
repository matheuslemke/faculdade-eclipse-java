package estrategiaguerra;

public class AtacarSozinho implements Estrategia
{

	@Override
	public void guerrear()
	{
		plantarEvidenciasFalsas();
		soltarBombas();
		derrubarGoverno();
	}

	@Override
	public void concluir()
	{
		estabelecerGovernoAmigo();
	}

	private void estabelecerGovernoAmigo()
	{
		System.out.println("Governo amigo estabelecido");
	}

	private void plantarEvidenciasFalsas()
	{
		System.out.println("Evidências falsas plantadas em terreno inimigo");
	}

	private void soltarBombas()
	{
		System.out.println("Bombardeio iniciado");
	}

	private void derrubarGoverno()
	{
		System.out.println("Governo inimigo CAIU!");
	}
}
