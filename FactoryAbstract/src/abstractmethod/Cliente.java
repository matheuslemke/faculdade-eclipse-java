package abstractmethod;

public class Cliente
{
	public static void main(String[] args)
	{
		FabricaPersonagens fe = new FabricaEgipcia();
		FabricaPersonagens fn = new FabricaNordica();
		FabricaPersonagens fg = new FabricaGrega();

		Heroi he = fe.criarHeroi();
		Monstro me = fe.criarMonstro();

		Heroi hn = fn.criarHeroi();
		Monstro mn = fn.criarMonstro();

		Heroi hg = fg.criarHeroi();
		Monstro mg = fg.criarMonstro();

		System.out.println(he.toString());
		System.out.println(me.toString());
		System.out.println(hn.toString());
		System.out.println(mn.toString());
		System.out.println(hg.toString());
		System.out.println(mg.toString());
	}
}
