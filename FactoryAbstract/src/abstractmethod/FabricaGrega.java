package abstractmethod;

public class FabricaGrega implements FabricaPersonagens
{

	@Override
	public Heroi criarHeroi()
	{
		return new Perseu();
	}

	@Override
	public Monstro criarMonstro()
	{
		return new Minotauro();
	}

}
