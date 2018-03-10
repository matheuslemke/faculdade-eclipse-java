package bridge;

public class TesteBridge
{

	public static void main(String[] args)
	{
		RemoteControl controle = new ConcreteRemote(new Sony());
		controle.on();
		controle.setChannel(2);
		controle.off();
		controle = new ConcreteRemote(new RCA());
		controle.on();
		controle.setChannel(2);
		controle.off();
	}

}
