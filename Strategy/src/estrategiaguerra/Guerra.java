package estrategiaguerra;

public class Guerra
{
	private Estrategia acao;
	private InimigoDeGuerra inimigo;

	public Guerra()
	{

	}

	public void definirEstrategia()
	{
		if (inimigo.getExercito() > 10000)
			acao = new AliancaVizinho();
		else if (inimigo.isNuclear())
			acao = new Diplomacia();
		else
			acao = new AtacarSozinho();
	}

	public void guerrear()
	{
		acao.guerrear();
	}

	public void concluir()
	{
		acao.concluir();
	}

	public void setInimigo(InimigoDeGuerra inimigo)
	{
		this.inimigo = inimigo;
	}
}
