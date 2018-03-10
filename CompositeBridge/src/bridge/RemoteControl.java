package bridge;

public abstract class RemoteControl
{
	protected TV implementor;

	
	public RemoteControl(TV implementor)
	{
		super();
		this.implementor = implementor;
	}

	public void on()
	{
		implementor.on();
	}

	public void off()
	{
		implementor.off();
	}

	public void setChannel(int channel)
	{
		implementor.tuneChannel(channel);
	}
}
