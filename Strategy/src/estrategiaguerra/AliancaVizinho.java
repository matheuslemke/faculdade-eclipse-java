package estrategiaguerra;

public class AliancaVizinho implements Estrategia
{

	@Override
	public void guerrear()
	{
		vizinhoPeloNorte();
		atacarPeloSul();
	}

	@Override
	public void concluir()
	{
		dividirBeneficios();
		dividirReconstrucao();
	}

	private void vizinhoPeloNorte()
	{
		System.out.println("Aliança criada com o Norte");
	}

	private void atacarPeloSul()
	{
		System.out.println("Ataque pelo Sul");
	}

	private void dividirBeneficios()
	{
		System.out.println("Benefícios divididos com as alianças");
	}

	private void dividirReconstrucao()
	{
		System.out.println("Gastos de reconstrução divididos");
	}
}
