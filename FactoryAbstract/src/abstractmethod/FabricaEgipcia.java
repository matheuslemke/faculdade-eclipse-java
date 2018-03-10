package abstractmethod;

public class FabricaEgipcia implements FabricaPersonagens
{

	@Override
	public Heroi criarHeroi()
	{
		return new Farao();
	}

	@Override
	public Monstro criarMonstro()
	{
		return new Anubis();
	}

}
