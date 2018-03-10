package bridge;

public class ConcreteRemote extends RemoteControl
{
	private int currentStation;

	public ConcreteRemote(TV implementor)
	{
		super(implementor);
	}

	public void on()
	{
		super.on();
	}

	public void off()
	{
		super.off();
	}

	public void setStation(int station)
	{
		setChannel(station);
	}

	public void nextChannel()
	{
		setChannel(currentStation + 1);
	}

	public void previousChannel()
	{
		setChannel(currentStation - 1);
	}

}
