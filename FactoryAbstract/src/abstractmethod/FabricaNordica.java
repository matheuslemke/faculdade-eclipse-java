package abstractmethod;

public class FabricaNordica implements FabricaPersonagens
{

	@Override
	public Heroi criarHeroi()
	{
		return new Beowulf();
	}

	@Override
	public Monstro criarMonstro()
	{
		return new Troll();
	}

}
