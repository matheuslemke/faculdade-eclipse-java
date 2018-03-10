package estrategiaguerra;

public class Cliente
{

	public static void main(String[] args)
	{
		InimigoDeGuerra exercito = new InimigoDeGuerra(15000, false);
		InimigoDeGuerra nuclear = new InimigoDeGuerra(8000, true);
		InimigoDeGuerra fraco = new InimigoDeGuerra(5000, false);

		Guerra guerra = new Guerra();

		guerra.setInimigo(exercito);
		guerra.definirEstrategia();
		guerra.guerrear();
		guerra.concluir();
		System.out.println();

		guerra.setInimigo(nuclear);
		guerra.definirEstrategia();
		guerra.guerrear();
		guerra.concluir();
		System.out.println();

		guerra.setInimigo(fraco);
		guerra.definirEstrategia();
		guerra.guerrear();
		guerra.concluir();
	}

}
